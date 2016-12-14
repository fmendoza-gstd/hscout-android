package adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.helpscout.R;
import objects.Ticket;

/**
 * Created by Gabriel on 13/12/2016.
 */
public class TickersAdapter2 extends BaseAdapter {
    private Context context;
    private final List<Ticket> items;

    public TickersAdapter2(Context context, List<Ticket> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolde viewHolde;
        final Ticket obj = (Ticket) getItem(position);

        //Asociamos el layout de la lista que hemos creado
        if(convertView == null) {
            convertView = inflater.inflate( R.layout.item_ticket, null);
            viewHolde = new ViewHolde();

            viewHolde.cv= (CardView)convertView.findViewById(R.id.cv);
            viewHolde.txtTicket = (TextView)convertView.findViewById(R.id.txtTicket);
            convertView.setTag(viewHolde);
        }
        else{
            viewHolde = (ViewHolde)convertView.getTag();
        }

        viewHolde.txtTicket.setText(obj.getName());
        viewHolde.cv.setCardBackgroundColor(obj.getColor());


        return convertView;
    }
}

class ViewHolde{
    CardView cv;
    TextView txtTicket;
}