package dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import demo.helpscout.R;
import midgardsystems.library.editTag.EditTag;

/**
 * Created by Gabriel on 05/01/2017.
 */
public class TagDialog  extends DialogFragment implements SwitchCompat.OnCheckedChangeListener {
    public static Context context;
    public View rootView;

    private EditTag editTagView;
    private SwitchCompat statusSwitchView;
    private List<String> tagStrings = new ArrayList<>();

    public TagDialog() {}

    @Override
    public void onAttach(Activity activity) {
        context=(FragmentActivity) activity;
        super.onAttach(activity);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);

        return createDialog();
    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    /**
     * Crea un PopUp con personalizado para comportarse
     * como formulario de PopUp
     *
     * @return PopUp
     */
    public AlertDialog createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //rootView.setAlpha(0.5f);
        rootView = inflater.inflate(R.layout.dialog_tags, null);
        builder.setView(rootView);        // Obtiene el btn de cerrar de menu bar

        init();

        return builder.create();
    }


    public void init(){

        editTagView = (EditTag) rootView.findViewById(R.id.edit_tag_view);
        statusSwitchView = (SwitchCompat) rootView.findViewById(R.id.status_switch);
        statusSwitchView.setOnCheckedChangeListener(this);

        for (int i = 0; i < 10; i++) {
            tagStrings.add("test" + i);
        }
        editTagView.setTagList(tagStrings);

        editTagView.addTag("hello world!");
//        Typeface fontOpenSans = Typeface.createFromAsset(getActivity().getAssets(), "fonts/OpenSansLight.ttf");
        //      Typeface fontOpenSansBold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/OpenSansBold.ttf");

        //    TextView lblTitle = (TextView) rootView.findViewById(R.id.lblTitle);

//        lblTitle.setTypeface(fontOpenSansBold);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        editTagView.setEditable(isChecked);
    }

}

