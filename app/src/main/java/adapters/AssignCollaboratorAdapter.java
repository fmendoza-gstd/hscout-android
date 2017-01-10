package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import demo.helpscout.R;

/**
 * Created by Gabriel on 05/01/2017.
 */
public class AssignCollaboratorAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_collaborator, parent, false);
        }
        return convertView;
    }
}