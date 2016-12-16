package adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import demo.helpscout.R;
import objects.Conversation;
import objects.Ticket;

import adapters.NumberedAdapter;
import utils.MarginDecoration;

/**
 * Created by Gabriel on 13/12/2016.
 */
public class ConversationAdapter2  extends RecyclerView.Adapter<ConversationAdapter2.ViewHolder>{
    Context context;
    public static List<Conversation> conversationItems;

    public ConversationAdapter2(Context context) {
        this.context = context;
    }


    public ConversationAdapter2(Context context, List<Conversation> conversationItems) {
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

        holder.recyclerView.setAdapter(new NumberedAdapter(conversationItems.get(position).getListTicket()));

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
           // recyclerView.addItemDecoration(new MarginDecoration(context));
            //recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(context, 4));

        }

    }

}


