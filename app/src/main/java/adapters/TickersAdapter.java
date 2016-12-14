package adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demo.helpscout.R;
import objects.Ticket;

/**
 * Created by Gabriel on 12/12/2016.
 */
public class TickersAdapter extends RecyclerView.Adapter<TickersAdapter.ViewHolder>{
    Context context;
    int idAnterior=0;
    public static List<Ticket> ticketItems;

    public TickersAdapter(Context context) {
        this.context = context;
    }


    public TickersAdapter(Context context, List<Ticket> ticketItems) {
        this.context = context;
        this.ticketItems = ticketItems;
        this.idAnterior=0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket, parent, false);
        ViewHolder holder = new ViewHolder(view);
        //return new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Ticket ticket = ticketItems.get(position);
        int id=ticket.getId();
        if(id!=idAnterior){
            holder.txtTicket.setText(ticket.getName());
            holder.cv.setCardBackgroundColor(ticket.getColor());
            idAnterior = 0;
            idAnterior=id;
            String name="";
        }



    }

    @Override
    public int getItemCount() {
        //return (bettingItems.size()!= 0 ? bettingItems.size() : 0);
    return ticketItems.size();
}

public class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cv;
        public TextView txtTicket;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            txtTicket = (TextView) itemView.findViewById(R.id.txtTicket);
        }
    }
}


