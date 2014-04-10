package com.church.GraceRoad;

import android.widget.TextView;

import java.nio.Buffer;

/**
 * Created by Mac003 on 14-3-25.
 */
public class UILabel extends ContentView
{
    private TextView _internal;
    public UILabel()
    {
        super();
        _internal = new TextView(getContext());

        addView(_internal);
    }

    public void setFrame(final Rect frame)
    {
        super.setFrame(frame);
        Rect bounds = frame;
        bounds.origin.x = 0;
        bounds.origin.y = 0;

        GR.setFrame(_internal, bounds);
    }
    public void setText(int stringID)
    {
        _internal.setText(stringID);
    }
    public void setText(CharSequence text)
    {
        _internal.setText(text);
    }
    public void setText(CharSequence text, TextView.BufferType type)
    {
        _internal.setText(text, type);
    }
}
