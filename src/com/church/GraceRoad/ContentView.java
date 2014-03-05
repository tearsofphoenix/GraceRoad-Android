package com.church.GraceRoad;

import android.content.Context;
import android.util.AttributeSet;

import android.view.ViewGroup;

/**
 * Created with IntelliJ IDEA.
 * User: Mac003
 * Date: 14-3-5
 * Time: AM10:27
 * To change this template use File | Settings | File Templates.
 */
public class ContentView extends ViewGroup
{
    ContentViewObserver _observer;
    String _title;
    Rect _frame;

    public void setTitle(String title)
    {
        if (_title != title)
        {
            _title = title;
            if (_observer != null)
            {
                _observer.didContentVeiwTitleChanged(this);
            }
        }
    }
    public String title()
    {
        return _title;
    }

    public void setFrame(final Rect frame)
    {
        if (_frame != frame)
        {
            _frame = frame;
            final int x = _frame.origin.x;
            final int y = _frame.origin.y;

            layout(x, y, x + _frame.size.width, y + _frame.size.height);
        }
    }

    public final Rect frame()
    {
        if (_frame == null)
        {
            final int x = getLeft();
            final int y = getTop();

            _frame = new Rect(x, y, getRight() - x, getBottom() - y);
        }

        return _frame;
    }

    //constructors
    //
    public ContentView()
    {
        super(GR.viewContext);
    }
    public ContentView(Context context)
    {
        super(context);
    }
    public ContentView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ContentView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public void setObserver(ContentViewObserver observer)
    {
        if (_observer != observer)
        {
            _observer = observer;
            if (_observer != null)
            {
                _observer.didContentVeiwTitleChanged(this);
            }
        }
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        ///Log.e(GR.LogTag, String.format("view: %s on layout: %d %d %d %d", toString(), l, t, r, b));
    }
}
