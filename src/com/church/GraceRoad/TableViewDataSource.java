package com.church.GraceRoad;

import android.content.Context;

import android.graphics.Color;
import com.nakardo.atableview.foundation.*;
import com.nakardo.atableview.protocol.ATableViewDataSource;
import com.nakardo.atableview.view.ATableView;
import com.nakardo.atableview.view.ATableViewCell;

/**
 * Created by Mac003 on 14-4-10.
 */
public class TableViewDataSource extends ATableViewDataSource
{
    private enum SimpleListSection { ROWS, SHOW_SELECTED_ROWS, ADD_MORE };
    private SimpleListSection getListSection(int section) {
        return SimpleListSection.values()[section];
    }
    @Override
    public ATableViewCell cellForRowAtIndexPath(ATableView tableView, com.nakardo.atableview.foundation.NSIndexPath indexPath) {
        final String cellIdentifier = "SIMPLE_CELL";

        ATableViewCell cell = dequeueReusableCellWithIdentifier(cellIdentifier);
        if (cell == null) {
            cell = new ATableViewCell(ATableViewCell.ATableViewCellStyle.Default, cellIdentifier, GR.viewContext);
        }

        String text = "Add 100 More Rows";

        SimpleListSection theSection = getListSection(indexPath.getSection());
        if (theSection == SimpleListSection.ROWS) {
            text = "Row " + String.valueOf(indexPath.getRow());
        } else if (theSection == SimpleListSection.SHOW_SELECTED_ROWS) {
            text = "Show Selected Rows";
        }
        cell.getTextLabel().setText(text);

        return cell;
    }

    @Override
    public int numberOfSectionsInTableView(ATableView tableView) {
        return SimpleListSection.values().length;
    }

    @Override
    public int numberOfRowsInSection(ATableView tableView, int section)
    {
        int count = 100;

        SimpleListSection theSection = getListSection(section);
        if (theSection == SimpleListSection.SHOW_SELECTED_ROWS ||
                theSection == SimpleListSection.ADD_MORE) {
            count = 1;
        }

        return count;
    }
}