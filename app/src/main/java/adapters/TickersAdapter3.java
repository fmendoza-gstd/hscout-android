package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo.helpscout.R;
import objects.Ticket;

/**
 * Created by Gabriel on 13/12/2016.
 */
public class TickersAdapter3  extends RecyclerView.Adapter<TicketViewHolder> {
    Context context;
    public static List<Ticket> ticketItems;

    public TickersAdapter3( Context context, List<Ticket> ticketItems ) {
        this.context = context;
        this.ticketItems = ticketItems;
    }

    @Override
    public TicketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TicketViewHolder holder, final int position) {

        holder.textView.setText(ticketItems.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        holder.textView.getContext(), ticketItems.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ticketItems.size();
    }
}

class TicketViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public TicketViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }
}