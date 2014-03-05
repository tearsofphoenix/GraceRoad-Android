package com.church.GraceRoad;

import android.graphics.Point;

/**
 * Created by Mac003 on 14-3-5.
 */
public class Rect
{
    Point origin;
    Size size;

    public Rect(int x, int y, int width, int height)
    {
        super();
        origin = new Point(x, y);
        size = new Size(width, height);
    }

    @Override
    public final boolean equals(Object obj)
    {
        if (obj instanceof Rect)
        {
            Rect rect = (Rect)obj;
            return origin.equals(rect.origin) && size.equals(rect.size);
        }

        return false;
    }

    @Override
    public final String toString()
    {
        return String.format("{{%d,%d},{%d,%d}}", new Object[]{origin.x, origin.y, size.width, size.height});
    }

}
