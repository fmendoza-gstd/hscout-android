package adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.helpscout.R;
import objects.Conversation;
import objects.Ticket;
import utils.MarginDecoration;

/**
 * Created by Gabriel on 13/12/2016.
 */
public class ConversationAdapter3  extends RecyclerView.Adapter<ConversationAdapter3.ViewHolder>{
    Context context;
    int i=0;
    public static List<Conversation> conversationItems;

    public ConversationAdapter3(Context context) {
        this.context = context;
    }


    public ConversationAdapter3(Context context, List<Conversation> conversationItems) {
        this.context = context;
        this.conversationItems = conversationItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversation2, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.txtUserName.setText(conversationItems.get(position).getUser().getName() + " " + conversationItems.get(position).getUser().getLastName());
        holder.txtData.setText(conversationItems.get(position).getData());
        holder.txtTitleMessage.setText(conversationItems.get(position).getTitleMessage());
        holder.txtPartContentMessage.setText(conversationItems.get(position).getContentMessage());

        List<Ticket> lstTickets3 = new ArrayList<Ticket>();
        lstTickets3.add(new Ticket(1, "Pendientes", R.color.ranting_5));
        lstTickets3.add(new Ticket(2, "Correcciones", R.color.ranting_1));
        lstTickets3.add(new Ticket(3, "Contrato", R.color.ranting_3));
        lstTickets3.add(new Ticket(4, "Planeacion", R.color.ranting_4));

        List<Ticket> lstTickets2 = new ArrayList<Ticket>();
        lstTickets2.add(new Ticket(1, "Software", R.color.ranting_2));

        //holder.recyclerView.setAdapter(new TickersAdapter3(context, conversationItems.get(position).getListTicket()));


        if(i==0){
            holder.recyclerView.setAdapter(new TickersAdapter3(context, lstTickets3));
        }else if(i>=1){
            holder.recyclerView.setAdapter(new TickersAdapter3(context, lstTickets2));
        }
        i++;
    }



    @Override
    public int getItemCount() {
        //return (bettingItems.size()!= 0 ? bettingItems.size() : 0);
        return conversationItems.size();
    }


    public static String byIdString(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView txtUserName;
        public TextView txtData;
        public TextView txtTitleMessage;
        public TextView txtPartContentMessage;
        // public BadgeLayout app_badge_layout;
        RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);

            txtUserName = (TextView) itemView.findViewById(R.id.txtUserName);
            txtData = (TextView) itemView.findViewById(R.id.txtData);
            txtTitleMessage = (TextView) itemView.findViewById(R.id.txtTitleMessage);
            txtPartContentMessage = (TextView) itemView.findViewById(R.id.txtPartContentMessage);
            //   app_badge_layout = (BadgeLayout) itemView.findViewById(R.id.app_badge_layout);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view);
            recyclerView.addItemDecoration(new MarginDecoration(context));
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
//            recyclerView.setAdapter(new TickersAdapter3());

        }

    }

}
