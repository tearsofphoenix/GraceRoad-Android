package com.church.GraceRoad;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends Activity implements ContentViewObserver
{
    private TextView _navigationBarView;
    private LinearLayout _tabView;
    private ContentView _contentView;
    /**
     * Called when the activity is first created.
     */
    private void _viewDidLoad()
    {
        final int[] viewIDs = {R.id.HomeButton, R.id.ResourceButton, R.id.SermonButton, R.id.PreferenceButton};
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
                int tabWidth = _tabView.getWidth() / viewIDs.length;

                for (int iLooper : viewIDs)
                {
                    Button buttonLooper =  (Button)findViewById(iLooper);
                    //buttonLooper.setBackground(null);
                    buttonLooper.setWidth(tabWidth);
                }

                //_tabView.postInvalidate();

                Log.e(GR.LogTag, String.format("tab width: %d", tabWidth));
            }
        });

        //put our first view
        IntroduceView inView = new IntroduceView();
        pushContentView(inView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        GR.viewContext = this;
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main);

        _viewDidLoad();
    }

    public void pushContentView(final ContentView view)
    {
        view.setObserver(this);
        _contentView.addView(view);

        final ViewTreeObserver observer = _contentView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                _contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                view.layout(0, 0, _contentView.getWidth(), _contentView.getHeight());

                Log.e(GR.LogTag, _contentView.frame().toString());

            }
        });
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
