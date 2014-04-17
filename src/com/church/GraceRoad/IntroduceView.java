package com.church.GraceRoad;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import com.nakardo.atableview.foundation.NSIndexPath;
import com.nakardo.atableview.protocol.ATableViewDelegate;
import com.nakardo.atableview.uikit.UILabel;
import com.nakardo.atableview.view.ATableView;
import com.nakardo.atableview.view.ATableViewCell;

import java.util.HashMap;

import static android.view.ViewGroup.LayoutParams.*;

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
        setBackgroundColor(Color.WHITE);

        _titleLabel = new UILabel(GR.viewContext);
        GR.setFrame(_titleLabel, new Rect(0, 0, 320, 40));
        _titleLabel.setText("        以马内利！新松江恩典教会欢迎您！愿神把您带到我们当中，在基督里我们是一家人，愿在以后的生活里我们共同学习神的话语。耶稣爱你");

         addView(_titleLabel);

        IntroduceTableViewDataSource tableViewAdapter = new IntroduceTableViewDataSource();
        _tableView = new ATableView(ATableView.ATableViewStyle.Plain, getContext());
        _tableView.setDataSource(tableViewAdapter);

        addView(_tableView);

//        IntroduceDelegate delegate = new IntroduceDelegate(_tableView);
//        _tableView.setDelegate(delegate);
    }

    @Override
    public void setFrame(final Rect frame)
    {
        super.setFrame(frame);

        int titleLabelHeight = 200;

        GR.setFrame( _titleLabel, new Rect(0, 0, frame.size.width, titleLabelHeight));
        GR.setFrame(_tableView, new Rect(0, titleLabelHeight, frame.size.width, frame.size.height - titleLabelHeight));
    }

    private class IntroduceDelegate extends ATableViewDelegate
    {
        private View _view;
        public IntroduceDelegate(View view)
        {
            super();
            _view = view;
        }
        @Override
        public void didSelectRowAtIndexPath(ATableView tableView, NSIndexPath indexPath)
        {
            int section = indexPath.getSection();
            int row = indexPath.getRow();
            if (section == 1)
            {
                String title = IntroduceTableViewDataSource.phoneTitles[row];
                int length = title.length();
                String phoneNumber = title.substring(length - 1 - 13, length - 1);
                GR.log("number: %s", phoneNumber);

                showActionSheet(_view);
            }
        }

        public void showActionSheet(View v)
        {
            final Dialog myDialog = new Dialog(GR.viewContext);

            myDialog.setContentView(R.layout.actionsheet);

            TextView tvNewButton = (TextView) myDialog.findViewById(R.id.tvButtonExample);

            tvNewButton.setOnClickListener(new OnClickListener()
            {
                @Override

                public void onClick(View v)
                {
                    myDialog.dismiss();

                    Toast.makeText(GR.viewContext.getApplicationContext(), "Example message", Toast.LENGTH_LONG).show();
                }

            });

            TextView tvCancel = (TextView) myDialog.findViewById(R.id.tvCancel);

            tvCancel.setOnClickListener(new OnClickListener()
            {
                @Override

                public void onClick(View v)
                {
                    myDialog.dismiss();
                }
            });

//            myDialog.getWindow().getAttributes().windowAnimations = ;

            myDialog.show();

            myDialog.getWindow().setGravity(Gravity.BOTTOM);

        }
    }
}
