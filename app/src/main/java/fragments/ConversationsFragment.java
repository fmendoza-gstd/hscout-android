package fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapters.ConversationAdapter;
import demo.helpscout.R;
import objects.Conversation;
import objects.Ticket;
import objects.User;

/**
 * Created by Gabriel on 08/12/2016.
 */
public class ConversationsFragment  extends Fragment {
    View rootView;
    public static Context context;
    public static ArrayList<Conversation> lstConversations= new ArrayList<Conversation>();
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredLayoutManager;
    public ConversationAdapter adapter;

    private static final String TAG_LIST_MATCH= "tag_list_match";

    public ConversationsFragment(){}
    @Override
    public void onAttach(Activity activity) {
        context=(FragmentActivity) activity;
        super.onAttach(activity);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        init();


        return rootView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//Make sure you have this line of code.
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        //inflater.inflate(R.menu.menu_main, menu);
    }
    @Override
    public void onResume() {
        super.onResume();
        //((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.title_fragment_details));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    private void init(){
        getAllConversations();
        initializeAdapter();
    }

    public static void getAllConversations(){

        User user1 = new User("Shawn", "Arden");
        User user2 = new User("Alen", "Johnson");
        User user3 = new User("Greg", "Fromme");
        User user4 = new User("Jon", "Avila");
        User user5 = new User("Sudi", "Green");
        User user6 = new User("Valerie", "Mettaliano");


        ArrayList<Ticket> lstTickets1= new ArrayList<Ticket>();
        lstTickets1.add(new Ticket(1, "Urgente", R.color.ranting_5));
        lstTickets1.add(new Ticket(3, "Ventas", R.color.ranting_1));

        ArrayList<Ticket> lstTickets2= new ArrayList<Ticket>();
        lstTickets2.add(new Ticket(1, "1", R.color.ranting_2));
        lstTickets2.add(new Ticket(2, "2", R.color.ranting_5));
        lstTickets2.add(new Ticket(3, "3", R.color.ranting_1));
        lstTickets2.add(new Ticket(4, "4", R.color.ranting_3));
        lstTickets2.add(new Ticket(5, "5", R.color.ranting_4));
        lstTickets2.add(new Ticket(6, "6", R.color.ranting_3));
        lstTickets2.add(new Ticket(7, "7", R.color.ranting_4));

        ArrayList<Ticket> lstTickets3= new ArrayList<Ticket>();
        lstTickets3.add(new Ticket(1, "A", R.color.ranting_5));
        lstTickets3.add(new Ticket(2, "B", R.color.ranting_1));
        lstTickets3.add(new Ticket(3, "C", R.color.ranting_3));
        lstTickets3.add(new Ticket(4, "D", R.color.ranting_4));

        lstConversations.add(new Conversation(user1, "9:15am", "10:25am", "Your J and G care package", "Note added", lstTickets3));
        lstConversations.add(new Conversation(user2, "Jul 12", "9:15am", "Please Check to see if you received my order?",  "Kellie can you please help Mark while I'm away? Wou...", lstTickets2));

    }
    private void initializeAdapter() {
        staggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(staggeredLayoutManager);
        recyclerView.setHasFixedSize(true); //Data size is fixed - improves performance

        adapter = new ConversationAdapter(getActivity(), lstConversations);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(onItemClickListener);
    }


    ConversationAdapter.OnItemClickListener onItemClickListener = new ConversationAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            conversationDescrition();
        }
    };

    private void conversationDescrition() {
        //Snackbar.make(rootView, "No puedes aceptar una apuesta lanzada por ti", Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }
}
