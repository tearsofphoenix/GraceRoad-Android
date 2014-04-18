package com.church.GraceRoad;

import com.nakardo.atableview.protocol.ATableViewDataSource;
import com.nakardo.atableview.view.ATableView;
import com.nakardo.atableview.view.ATableViewCell;

/**
 * Created by Mac003 on 14-4-18.
 */
public class ResourceTableViewDataSource extends ATableViewDataSource
{
    private ResourceView _view;

    public ResourceTableViewDataSource(ResourceView view)
    {
        super();
        _view = view;
    }

    @Override
    public ATableViewCell cellForRowAtIndexPath(ATableView tableView, com.nakardo.atableview.foundation.NSIndexPath indexPath)
    {
        final String cellIdentifier = "SIMPLE_CELL";

        ATableViewCell cell = dequeueReusableCellWithIdentifier(cellIdentifier);
        if (cell == null)
        {
            cell = new ATableViewCell(ATableViewCell.ATableViewCellStyle.Default, cellIdentifier, GR.viewContext);
        }

        String text = "Add 100 More Rows";

        cell.getTextLabel().setText(text);

        return cell;
    }

    @Override
    public int numberOfSectionsInTableView(ATableView tableView) {
        return 1;
    }

    @Override
    public int numberOfRowsInSection(ATableView tableView, int section)
    {
        int count = 10;
        return count;
    }
}
