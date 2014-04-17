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
public class IntroduceTableViewDataSource extends ATableViewDataSource
{
    //static final private int[] sectionTitles = {R.string.event_section_title, R.string.phone_section_title};
    static final private int[] eventTitles = {R.string.event0, R.string.event1, R.string.event2, R.string.event3, R.string.event4};
    static final public String[] phoneTitles = {"孙牧师  电话：137-9535-2317",
                                                "张传道  电话：135-6426-9605",
                                                "李传道  电话：158-0193-5868"};

    @Override
    public ATableViewCell cellForRowAtIndexPath(ATableView tableView, NSIndexPath indexPath)
    {
        final String cellIdentifier = "SIMPLE_CELL";

        ATableViewCell cell = dequeueReusableCellWithIdentifier(cellIdentifier);
        if (cell == null)
        {
            cell = new ATableViewCell(ATableViewCell.ATableViewCellStyle.Default, cellIdentifier, GR.viewContext);
        }

        int section = indexPath.getSection();
        int row = indexPath.getRow();

        switch (section)
        {
            case 0:
            {
                cell.getTextLabel().setText(eventTitles[row]);
                break;
            }
            case 1:
            {
                cell.getTextLabel().setText(phoneTitles[row]);
                break;
            }
            default:
            {
                 break;
            }
        }


        return cell;
    }

    @Override
    public int numberOfSectionsInTableView(ATableView tableView) {
        return 2;
    }

    @Override
    public int numberOfRowsInSection(ATableView tableView, int section)
    {
        switch (section)
        {
            case 0:
            {
                return eventTitles.length;
            }
            case 1:
            {
                return phoneTitles.length;
            }
            default:
            {
                return 0;
            }
        }
    }

    public String titleForHeaderInSection(ATableView tableView, int section)
    {
        switch (section)
        {
            case 0:
            {
                return "礼拜天事项";
            }
            case 1:
            {
                return "联系方式";
            }
            default:
            {
                return "";
            }
        }
    }

}