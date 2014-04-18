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
public class ResourceView extends ContentView  implements ListAdapter
{
    private ListView _contentView;
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

        _contentView = new ListView(getContext());
        addView(_contentView);

        _contentView.setAdapter(this);
    }

    @Override
    public void setFrame(Rect frame)
    {
        super.setFrame(frame);
        Rect bounds = frame.clone();
        bounds.origin.x = 0;
        bounds.origin.y = 0;

        GR.log("%s", bounds);
        GR.setFrame(_contentView, bounds);
//        _contentView.setFrame(bounds);
    }

    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer)
    {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer)
    {

    }

    @Override
    public int getCount()
    {
        return _data.size();
    }

    @Override
    public Object getItem(int position)
    {
        return _data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        UILabel cell = new UILabel(GR.viewContext);
        cell.setText("Cell" + position);
        GR.setFrame(cell,  new Rect(0, 300, 300, 40));
        return cell;
    }

    @Override
    public int getItemViewType(int position)
    {
        return 12;
    }

    @Override
    public int getViewTypeCount()
    {
        return 1;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }
}
