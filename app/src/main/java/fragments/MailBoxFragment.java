package fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import adapters.MailboxAdapter;
import demo.helpscout.R;

/**
 * Created by Gabriel on 16/12/2016.
 */
public class MailBoxFragment extends Fragment {
    View rootView;
    public static Context context;

    //public static ArrayList<Conversation> lstConversations = new ArrayList<Conversation>();
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredLayoutManager;
    public MailboxAdapter adapter;

    private static final String TAG_MAILBOX = "tag_mailBox";

    public MailBoxFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        context = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
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
        inflater.inflate(R.menu.menu_main, menu);

        menu.findItem(R.id.menuSupport).setIcon(
                new IconDrawable(context, FontAwesomeIcons.fa_angle_down)
                        .colorRes(R.color.md_white_1000)
                        .actionBarSize());
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


    private void init() {
        //getAllConversations();
        initializeAdapter();
    }

    public static void getAllConversations() {
/*
        User user1 = new User("Shawn", "Arden");
        User user2 = new User("Alen", "Johnson");
        User user3 = new User("Greg", "Fromme");
        User user4 = new User("Jon", "Avila");
        User user5 = new User("Sudi", "Green");
        User user6 = new User("Valerie", "Mettaliano");


        List<Ticket> lstTickets1 = new ArrayList<Ticket>();
        lstTickets1.add(new Ticket(1, "Urgente", R.color.ranting_5));
        lstTickets1.add(new Ticket(2, "Ventas", R.color.ranting_1));

        List<Ticket> lstTickets2 = new ArrayList<Ticket>();
        lstTickets2.add(new Ticket(1, "Software", R.color.ranting_2));


        List<Ticket> lstTickets3 = new ArrayList<Ticket>();
        lstTickets3.add(new Ticket(1, "Pendientes", R.color.ranting_5));
        lstTickets3.add(new Ticket(2, "Correcciones", R.color.ranting_1));
        lstTickets3.add(new Ticket(3, "Contrato", R.color.ranting_3));
        lstTickets3.add(new Ticket(4, "Planeacion", R.color.ranting_4));

        lstConversations.add(new Conversation(user1, "9:15am", "10:25am", "Your J and G care package", "Note added", lstTickets3));
        lstConversations.add(new Conversation(user2, "Jul 12", "9:15am", "Please Check to see if you received my order?", "Kellie can you please help Mark while I'm away? Wou...", lstTickets2));
        lstConversations.add(new Conversation(user3, "Jul 4", "9:08am", "Re: Welcome to J and G, Let's get you started", "Kellie can you please help Mark while I'm away? Wou..", lstTickets1));
*/
    }

    private void initializeAdapter() {
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(new MailboxAdapter());


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = new MailBoxDetailsFragment();
                FragmentTransaction fragmentManager = getFragmentManager().beginTransaction();
                //fragmentManager.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left);
                fragmentManager.replace(R.id.main_content, fragment, TAG_MAILBOX);
                //fragmentManager.addToBackStack(TAG);
                fragmentManager.commit();
            }
        });
    }



    private void conversationDescrition() {
        //Snackbar.make(rootView, "No puedes aceptar una apuesta lanzada por ti", Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }
}