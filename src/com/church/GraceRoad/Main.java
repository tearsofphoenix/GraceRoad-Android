package com.church.GraceRoad;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Main extends Activity implements ContentViewObserver
{
    private TextView _navigationBarView;
    private LinearLayout _tabView;
    private ContentView _contentView;
    private ArrayList<ArrayList<ContentView> >  _viewStack = new ArrayList<ArrayList<ContentView>>();
    private int _currentTabIndex = -1;

    static final int[] tabButtonIDs = {R.id.HomeButton, R.id.ResourceButton, R.id.SermonButton, R.id.PreferenceButton};
    /**
     * Called when the activity is first created.
     */
    private int _indexOfButton(int id)
    {
        for(int iLooper = 0; iLooper < tabButtonIDs.length; ++iLooper)
        {
            if (id == tabButtonIDs[iLooper])
            {
                return iLooper;
            }
        }

        return -1;
    }

    private void _navigateToTabAtIndex(int index)
    {
        if (_currentTabIndex != index)
        {
            _currentTabIndex = index;
            ArrayList<ContentView> views = _viewStack.get(index);
            int size = views.size();
            if (size > 0)
            {
                ContentView lastView = views.get(size - 1);
                _updateForContentView(lastView);
            }
        }
    }

    private void _viewDidLoad()
    {

        _navigationBarView = (TextView)findViewById(R.id.navigationView);
        _tabView = (LinearLayout)findViewById(R.id.tabView);
        _contentView = (ContentView)findViewById(R.id.contentView);

        final View mainView = (View)findViewById(R.id.mainView);
        ViewTreeObserver mainObserver = mainView.getViewTreeObserver();
        mainObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                mainView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Rect frame = GR.getFrame(mainView);

//                Rect frame = GR.getFrame(findViewById(R.id.mainView));
                Log.e(GR.LogTag, frame.toString());

                final int height = frame.size.height;
                final int width = frame.size.width;

                _contentView.setFrame(new Rect(0, GR.navigationBarHeight, width, height - GR.navigationBarHeight - GR.tabHeight));
                GR.setFrame(_tabView, new Rect(0, height - GR.tabHeight, width, GR.tabHeight));
            }
        });
        //fix tab views
        //

        ViewTreeObserver observer = _tabView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                _tabView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int tabWidth = _tabView.getWidth() / tabButtonIDs.length;

                for (int iLooper : tabButtonIDs)
                {
                    Button buttonLooper =  (Button)findViewById(iLooper);
                    //buttonLooper.setBackground(null);
                    buttonLooper.setWidth(tabWidth);
                    buttonLooper.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            Button sender = (Button)v;

                            int index =  _indexOfButton(sender.getId());
                            _navigateToTabAtIndex(index);
                        }
                    });
                }

                //_tabView.postInvalidate();

                Log.e(GR.LogTag, String.format("tab width: %d", tabWidth));
            }
        });

        //put our first view
        IntroduceView inView = new IntroduceView();
        _currentTabIndex = 0;
        pushContentView(inView);

        ResourceView resourceView = new ResourceView();
        _viewStack.get(1).add(resourceView);

        SermonView sermonView = new SermonView();
        _viewStack.get(2).add(sermonView);

        PreferenceView preferenceView = new PreferenceView();
        _viewStack.get(3).add(preferenceView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        GR.viewContext = this;
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main);

        for (int iLooper = 0; iLooper < tabButtonIDs.length; ++iLooper)
        {
            _viewStack.add(new ArrayList<ContentView>());
        }
        _viewDidLoad();
    }

    private void _updateForContentView(final ContentView view)
    {
        view.setObserver(this);

        _contentView.removeView(view);
        _contentView.addView(view);

        _navigationBarView.setText(view.title());

        final ViewTreeObserver observer = _contentView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                _contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Rect bounds = new Rect(0, 0, _contentView.getWidth(), _contentView.getHeight());
                view.setFrame(bounds);
//                view.layout(0, 0, _contentView.getWidth(), _contentView.getHeight());
            }
        });
    }

    public void pushContentView(final ContentView view)
    {
         _updateForContentView(view);
        ArrayList<ContentView> currentStack = _viewStack.get(_currentTabIndex);
        currentStack.add(view);
    }
    public void popContentView()
    {

    }

    //ContentView observer

    @Override
    public void didContentVeiwTitleChanged(ContentView view)
    {
        _navigationBarView.setText(view.title());
    }
}
