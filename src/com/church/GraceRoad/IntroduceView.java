package com.church.GraceRoad;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.nakardo.atableview.uikit.UILabel;
import com.nakardo.atableview.view.ATableView;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Mac003
 * Date: 14-3-5
 * Time: AM10:35
 * To change this template use File | Settings | File Templates.
 */
public class IntroduceView extends ContentView
{
    UILabel _titleLabel;
    ATableView _tableView;
    ArrayAdapter<HashMap> _data;

    public IntroduceView()
    {
        super();
        setTitle("新松江恩典教会");
        setBackgroundColor(Color.RED);

        _titleLabel = new UILabel(GR.viewContext);
        GR.setFrame(_titleLabel, new Rect(0, 0, 320, 40));
        _titleLabel.setText("        以马内利！新松江恩典教会欢迎您！愿神把您带到我们当中，在基督里我们是一家人，愿在以后的生活里我们共同学习神的话语。耶稣爱你");

         addView(_titleLabel);

        TableViewDataSource tableViewAdapter = new TableViewDataSource();
        _tableView = new ATableView(ATableView.ATableViewStyle.Plain, getContext());
        _tableView.setDataSource(tableViewAdapter);

        addView(_tableView);
    }

    @Override
    public void setFrame(final Rect frame)
    {
        super.setFrame(frame);

        GR.setFrame(_titleLabel, new Rect(0, 0, frame.size.width, 120));
        GR.setFrame(_tableView, new Rect(0, 120, frame.size.width, frame.size.height - 120));
    }
}
