package fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import java.util.ArrayList;
import java.util.List;

import demo.helpscout.R;
import midgardsystems.library.editTag.EditTag;

/**
 * Created by Gabriel on 04/01/2017.
 */
public class TagsFragment extends Fragment implements SwitchCompat.OnCheckedChangeListener{
    View rootView;
    public static Context context;
    private EditTag editTagView;
    private SwitchCompat statusSwitchView;
    private List<String> tagStrings = new ArrayList<>();

    public TagsFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        context = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tags, container, false);

        editTagView = (EditTag) rootView.findViewById(R.id.edit_tag_view);
        statusSwitchView = (SwitchCompat) rootView.findViewById(R.id.status_switch);
        statusSwitchView.setOnCheckedChangeListener(this);

        for (int i = 0; i < 10; i++) {
            tagStrings.add("test" + i);
        }
        editTagView.setTagList(tagStrings);

        editTagView.addTag("hello world!");

        return rootView;

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        editTagView.setEditable(isChecked);
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



}