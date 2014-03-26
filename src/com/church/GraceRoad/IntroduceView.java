package com.church.GraceRoad;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Mac003
 * Date: 14-3-5
 * Time: AM10:35
 * To change this template use File | Settings | File Templates.
 */
public class IntroduceView extends ContentView
{
    public IntroduceView()
    {
        super();
        setTitle("新松江恩典教会");
        setBackgroundColor(Color.RED);
        //LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.introduce, null);
//        View view  = LayoutInflater.from(this.getContext()).inflate(R.layout.introduce, null);
//        Log.e(GR.LogTag, view.toString());
//
//        this.addView(view);

        UILabel titleLabel = new UILabel();
        titleLabel.setFrame(new Rect(0, 0, 320, 40));
        titleLabel.setText(R.string.introduce_title0);
        addView(titleLabel);

    }
}
