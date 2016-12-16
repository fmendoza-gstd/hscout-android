package adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo.helpscout.R;
import objects.Ticket;

/**
 * Created by Gabriel on 13/12/2016.
 */
public class NumberedAdapter extends RecyclerView.Adapter<TextViewHolder> {
    private List<String> labels;
    private List<Ticket> ticketItems;

    public NumberedAdapter(int count) {
        labels = new ArrayList<String>(count);
        for (int i = 0; i < count; ++i) {
            labels.add(String.valueOf(i));
        }
    }

    public NumberedAdapter(List<Ticket> ticketItems) {
        this.ticketItems=ticketItems;
        labels = new ArrayList<String>(ticketItems.size());
        for (int i = 0; i < ticketItems.size(); ++i) {
            labels.add(ticketItems.get(i).getName());
        }

    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TextViewHolder holder, final int position) {
        final String label = labels.get(position);
        holder.txtTicket.setText(label);
        holder.bgTicket.setBackgroundColor(ticketItems.get(position).getColor());
        holder.bgTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }
}

class TextViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout bgTicket;
    public TextView txtTicket;
    public TextViewHolder(View itemView) {
        super(itemView);
        bgTicket = (RelativeLayout) itemView.findViewById(R.id.bgTicket);
        txtTicket = (TextView) itemView.findViewById(R.id.txtTicket);
    }
}