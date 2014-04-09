package pl.polidea.sectionedlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Mac003 on 14-4-9.
 */
public class StandardArrayAdapter extends ArrayAdapter<SectionListItem>
{

    private final SectionListItem[] items;

    public StandardArrayAdapter(final Context context,
                                final int textViewResourceId, final SectionListItem[] items)
    {
        super(context, textViewResourceId, items);
        this.items = items;
    }

    @Override
    public View getView(final int position, final View convertView,
                        final ViewGroup parent)
    {
        TextView cell = (TextView)convertView;
        if (cell == null)
        {
            cell = new TextView(parent.getContext());
        }

        cell.setText("This is text");

        return cell;
    }
}
