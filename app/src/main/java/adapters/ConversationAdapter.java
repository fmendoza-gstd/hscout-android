package adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import objects.Ticket;
import utils.BadgeLayout;

import java.util.ArrayList;
import java.util.List;

import demo.helpscout.R;
import objects.Conversation;

/**
 * Created by Gabriel on 12/12/2016.
 */
public class ConversationAdapter  extends RecyclerView.Adapter<ConversationAdapter.ViewHolder>{
    Context context;
    public static List<Conversation> conversationItems;
    OnItemClickListener onItemClickListener;
    public TickersAdapter adapter;

    public ConversationAdapter(Context context) {
        this.context = context;
    }


    public ConversationAdapter(Context context, List<Conversation> conversationItems) {
        this.context = context;
        this.conversationItems = conversationItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversation, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.listTicket.setLayoutManager(holder.staggeredLayoutManager);
        holder.listTicket.setHasFixedSize(true); //Data size is fixed - improves performance

        //adapter = new TickersAdapter(context, conversationItems.get(position).getListTicket());
        //holder.listTicket.setAdapter(adapter);
        holder.listTicket.setAdapter(getTickersAdapter(context, conversationItems.get(position).getListTicket()));



        holder.txtUserName.setText(conversationItems.get(position).getUser().getName() + " " + conversationItems.get(position).getUser().getLastName());
        holder.txtData.setText(conversationItems.get(position).getData());
        holder.txtTitleMessage.setText(conversationItems.get(position).getTitleMessage());
        holder.txtPartContentMessage.setText(conversationItems.get(position).getContentMessage());

/*
        holder.app_badge_layout.setBadgeBackground(R.drawable.badge_gray);
        holder.app_badge_layout.setBadgeBackground(R.drawable.badge_green);*/
    }

    public TickersAdapter getTickersAdapter(Context context, List<Ticket> ticketList){
        return new TickersAdapter(context, ticketList);
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cv;
        public TextView txtUserName;
        public TextView txtData;
        public TextView txtTitleMessage;
        public TextView txtPartContentMessage;
       // public BadgeLayout app_badge_layout;
        public RecyclerView listTicket;
        public StaggeredGridLayoutManager staggeredLayoutManager;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);

            txtUserName = (TextView) itemView.findViewById(R.id.txtUserName);
            txtData = (TextView) itemView.findViewById(R.id.txtData);
            txtTitleMessage = (TextView) itemView.findViewById(R.id.txtTitleMessage);
            txtPartContentMessage = (TextView) itemView.findViewById(R.id.txtPartContentMessage);
         //   app_badge_layout = (BadgeLayout) itemView.findViewById(R.id.app_badge_layout);
            listTicket = (RecyclerView) itemView.findViewById(R.id.list);
            staggeredLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);

            cv.setOnClickListener(this);
            cv.setCardBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.onItemClickListener = mItemClickListener;
    }
}


