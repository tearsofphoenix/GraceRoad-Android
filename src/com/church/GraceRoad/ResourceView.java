package com.church.GraceRoad;

import android.graphics.Color;
import android.util.Log;
import pl.polidea.sectionedlist.*;

/**
 * Created by Mac003 on 14-4-9.
 */
public class ResourceView extends ContentView
{
    TableView _contentView;

    public ResourceView()
    {
        super();

        setTitle("资料");
        this.setBackgroundColor(Color.BLUE);

        _contentView = new TableView(getContext());
        addView(_contentView);

        SectionListItem[] exampleArray = { // Comment to prevent re-format
                new SectionListItem("Test 1 - A", "A"), //
                new SectionListItem("Test 2 - A", "A"), //
                new SectionListItem("Test 3 - A", "A"), //
                new SectionListItem("Test 4 - A", "A"), //
                new SectionListItem("Test 5 - A", "A"), //
                new SectionListItem("Test 6 - B", "B"), //
                new SectionListItem("Test 7 - B", "B"), //
                new SectionListItem("Test 8 - B", "B"), //
                new SectionListItem("Test 9 - Long", "Long section"), //
                new SectionListItem("Test 10 - Long", "Long section"), //
                new SectionListItem("Test 11 - Long", "Long section"), //
                new SectionListItem("Test 12 - Long", "Long section"), //
                new SectionListItem("Test 13 - Long", "Long section"), //
        };

        StandardArrayAdapter adapter = new StandardArrayAdapter(this.getContext(), R.id.example_text_view, exampleArray);
        SectionListAdapter sectionAdapter = new SectionListAdapter(adapter);

        _contentView.setDataSource(sectionAdapter);
    }

    @Override
    public void setFrame(Rect frame)
    {
        super.setFrame(frame);
        Rect bounds = frame.clone();
        bounds.origin.x = 0;
        bounds.origin.y = 0;

        GR.log("%s", bounds);
        _contentView.setFrame(bounds);
    }
}
