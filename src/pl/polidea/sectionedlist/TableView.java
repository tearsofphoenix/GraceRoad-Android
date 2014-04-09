package pl.polidea.sectionedlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.church.GraceRoad.ContentView;
import com.church.GraceRoad.GR;
import com.church.GraceRoad.Rect;

/**
 * Created by Mac003 on 14-4-9.
 */
public class TableView extends FrameLayout
{
    TableViewInternal _internal;

    private void _init(Context context)
    {
        _internal = new TableViewInternal(context);
        addView(_internal);
    }

    public TableView(Context context)
    {
        super(context);
        _init(context);
    }

    public TableView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        _init(context);
    }

    public TableView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        _init(context);
    }

    public void setDataSource(ListAdapter adapter)
    {
        _internal.setAdapter(adapter);
    }

    public void setFrame(Rect frame)
    {
        GR.setFrame(this, frame);
        Rect bounds = frame.clone();
        bounds.origin.x = 0;
        bounds.origin.y = 0;

        GR.log("%s", bounds);

        GR.setFrame(_internal, bounds);
    }
}
