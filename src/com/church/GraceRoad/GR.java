package com.church.GraceRoad;

import android.content.Context;
import android.view.View;

/**
 * Created by Mac003 on 14-3-5.
 */
public class GR
{

    public static final String LogTag;
    public static Context viewContext;
    public static final int navigationBarHeight;
    public static final int tabHeight;
    static
    {
        navigationBarHeight = 44;
        tabHeight = 44;
        LogTag = "GraceRod";
    }
    public static final Rect  getFrame(View view)
    {
        if (view instanceof ContentView)
        {
            return ((ContentView) view).frame();
        }

        final int x = view.getLeft();
        final int y = view.getTop();

        return new Rect(x, y, view.getRight() - x, view.getBottom() - y);
    }
    public static void setFrame(View view, final Rect frame)
    {
        if (view instanceof ContentView)
        {
            ((ContentView) view).setFrame(frame);
        }else
        {
            final int x = frame.origin.x;
            final int y = frame.origin.y;

            view.layout(x, y, x + frame.size.width, y + frame.size.height);
        }
    }

}
