package com.church.GraceRoad;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nakardo.atableview.uikit.UILabel;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by Mac003 on 14-4-9.
 */
public class ResourceView extends ContentView
{

    private ArrayList<HashMap> _data;

    public ResourceView()
    {
        super();

        setTitle("资料");
        this.setBackgroundColor(Color.BLUE);

        _data = new ArrayList<HashMap>();
        HashMap map = new HashMap();
        map.put("name", "Hello");

        _data.add(map);
    }

    @Override
    public void setFrame(Rect frame)
    {
        super.setFrame(frame);
        Rect bounds = frame.clone();
        bounds.origin.x = 0;
        bounds.origin.y = 0;

        GR.log("%s", bounds);
    }
}
