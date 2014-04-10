package com.church.GraceRoad;

import android.content.Context;

import fr.days.android.uitableview.adapter.UITableViewAdapter;
import fr.days.android.uitableview.listener.OnCellClickListener;
import fr.days.android.uitableview.model.AccessoryType;
import fr.days.android.uitableview.model.IndexPath;
import fr.days.android.uitableview.model.UITableCellItem;
import fr.days.android.uitableview.model.UITableHeaderItem;
import fr.days.android.uitableview.view.UITableCellView;
import fr.days.android.uitableview.view.UITableHeaderView;

/**
 * Created by Mac003 on 14-4-10.
 */
public class TableViewDataSource extends UITableViewAdapter implements OnCellClickListener
{

    private int[] color_line1_default;
    private int[] color_line2_default;
    private int[] color_line1_pressed;
    private int[] color_line2_pressed;

    public TableViewDataSource()
    {
        // Prepare two sets of colors for odd and even lines
        int color1 = 0;
        int color2 = 1;

        color_line1_default = new int[]{color1, color2};
        color_line2_default = new int[]{color1, color2};
        color_line1_pressed = new int[]{color1, color2};
        color_line2_pressed = new int[]{color1, color2};
    }

    @Override
    public int numberOfGroups()
    {
        return 4;
    }

    @Override
    public int numberOfRows(int group)
    {
        return (group + 1) * 2;
    }

    @Override
    public UITableHeaderItem headerItemForGroup(Context context, IndexPath indexPath)
    {
        return new UITableHeaderItem("Group " + indexPath.getGroup());
    }

    @Override
    public UITableCellItem cellItemForRow(Context context, IndexPath indexPath)
    {
        String title = "Cell number " + indexPath.getRow() + " in group " + indexPath.getGroup();
        String subtitle = (indexPath.getRow() % 2 == 0) ? "Subtitle " + indexPath.getRow() : null;
        return new UITableCellItem(title, subtitle);
    }

    @Override
    public UITableHeaderView headerViewForGroup(Context context, IndexPath indexPath, UITableHeaderItem headerItem, UITableHeaderView convertView)
    {
        UITableHeaderView headerView;
        if (convertView == null)
        {
            // If the recycled view is null, we just creating one
            headerView = new UITableHeaderView(context, indexPath);
        } else
        {
            headerView = (UITableHeaderView) convertView;
        }

        headerView.setTitle(headerItem.title);

        return headerView;
    }

    @Override
    public UITableCellView cellViewForRow(Context context, IndexPath indexPath, UITableCellItem cellItem, UITableCellView convertView)
    {
        UITableCellView cellView;
        if (convertView == null)
        {
            // If the recycled view is null, we just creating one with cell's commons parameters
            cellView = new UITableCellView(context, indexPath);
            cellView.setMinimumHeight(80);
            cellView.setAccessory(AccessoryType.DISCLOSURE);
        } else
        {
            cellView = (UITableCellView) convertView;
        }

        cellView.setTitle(cellItem.title);
        cellView.setSubtitle(cellItem.subtitle);

        // Set alternated background color
        if (indexPath.getRow() % 2 == 0)
        {
            cellView.setBackgroundColor(color_line1_default, color_line1_pressed);
        } else
        {
            cellView.setBackgroundColor(color_line2_default, color_line2_pressed);
        }

        return cellView;
    }

    @Override
    public void onCellClick(IndexPath indexPath)
    {
//        Toast.makeText(getApplicationContext(), "Cell clicked : " + indexPath, 1000).show();
    }

//    @Override
//    public boolean onCellLongClick(IndexPath indexPath)
//    {
////        Toast.makeText(getApplication(), "Cell long clicked : " + indexPath, 1000).show();
//        return indexPath.getRow() % 2 == 0; // Consume the long click one row out of two
//    }
//
//    @Override
//    public void onCellAccessoryClick(IndexPath indexPath)
//    {
////        Toast.makeText(getApplication(), "Cell accessory clicked : " + indexPath, 1000).show();
//    }
//
//    @Override
//    public void onHeaderClick(IndexPath indexPath)
//    {
////        Toast.makeText(getApplicationContext(), "Header clicked : " + indexPath, 1000).show();
//    }
//
//    @Override
//    public boolean onHeaderLongClick(IndexPath indexPath)
//    {
////        Toast.makeText(getApplicationContext(), "Header long clicked : " + indexPath, 1000).show();
//        return indexPath.getGroup() % 2 == 0;   // Consume the long click one row out of two
//    }
}
