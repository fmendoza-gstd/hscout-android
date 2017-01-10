package fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import demo.helpscout.R;
import dialogs.AddReplyDialog;
import dialogs.AssignCollaboratorDialog;
import dialogs.AttachFilesDialog;
import dialogs.StatusDialog;
import dialogs.TagDialog;

/**
 * Created by Gabriel on 05/01/2017.
 */
public class NoteFragment   extends Fragment {
    View rootView;
    public static Context context;

    //public static ArrayList<Conversation> lstConversations = new ArrayList<Conversation>();
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredLayoutManager;

    private static final String TAG_MAILBOX_DETAILS = "tag_mailBox_details";

    public NoteFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        context = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_notes, container, false);
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
        inflater.inflate(R.menu.menu_conv_details, menu);

        // Set an icon in the ActionBar
        menu.findItem(R.id.action_menu_tools).setIcon(
                new IconDrawable(context, FontAwesomeIcons.fa_list_ul)
                        .colorRes(R.color.md_white_1000)
                        .actionBarSize());

        menu.findItem(R.id.action_tag).setIcon(
                new IconDrawable(context, FontAwesomeIcons.fa_tag)
                        .colorRes(R.color.md_divider)
                        .actionBarSize());


        menu.findItem(R.id.action_flag).setIcon(
                new IconDrawable(context, FontAwesomeIcons.fa_flag)
                        .colorRes(R.color.md_secondary_text_icons)
                        .actionBarSize());

        menu.findItem(R.id.action_user).setIcon(
                new IconDrawable(context, FontAwesomeIcons.fa_user)
                        .colorRes(R.color.md_secondary_text_icons)
                        .actionBarSize());


        menu.findItem(R.id.action_trash).setIcon(
                new IconDrawable(context, FontAwesomeIcons.fa_trash)
                        .colorRes(R.color.md_secondary_text_icons)
                        .actionBarSize());




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

        LinearLayout status = (LinearLayout) rootView.findViewById(R.id.status);
        LinearLayout assign = (LinearLayout) rootView.findViewById(R.id.assign);

        RelativeLayout btnTags = (RelativeLayout) rootView.findViewById(R.id.btnTags);
        RelativeLayout btnReply = (RelativeLayout) rootView.findViewById(R.id.btnReply);
        RelativeLayout btnAttachFiles = (RelativeLayout) rootView.findViewById(R.id.btnAttachFiles);

        btnTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTagsDialog();
            }
        });
        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showReplyDialog();
            }
        });
        btnAttachFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAttachFileDialog();
            }
        });


        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStatusDialog();
            }
        });
        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAssignDialog();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_tag) {
            showTags();
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }

    public void showStatusDialog(){
        // Create the fragment and show it as a dialog.
        StatusDialog dialog = new StatusDialog();
        dialog.show(getFragmentManager(), "tag_somepopup");
    }
    public void showAssignDialog(){
        // Create the fragment and show it as a dialog.
        AssignCollaboratorDialog dialog = new AssignCollaboratorDialog();
        dialog.show(getFragmentManager(), "tag_somepopup");
    }

    public void showTagsDialog(){
        // Create the fragment and show it as a dialog.
        TagDialog dialog = new TagDialog();
        dialog.show(getFragmentManager(), "tag_somepopup");
    }
    public void showReplyDialog(){
        // Create the fragment and show it as a dialog.
        AddReplyDialog dialog = new AddReplyDialog();
        dialog.show(getFragmentManager(), "tag_somepopup");
    }
    public void showAttachFileDialog(){
        // Create the fragment and show it as a dialog.
        AttachFilesDialog dialog = new AttachFilesDialog();
        dialog.show(getFragmentManager(), "tag_somepopup");
    }


}