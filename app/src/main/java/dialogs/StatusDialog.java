package dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import demo.helpscout.R;

/**
 * Created by Gabriel on 06/01/2017.
 */
public class StatusDialog  extends DialogFragment {
    public static Context context;
    public View rootView;

    public StatusDialog() {}

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
        //  rootView.setAlpha(0.5f);
        rootView = inflater.inflate(R.layout.dialog_status, null);
        builder.setView(rootView);        // Obtiene el btn de cerrar de menu bar

        init();

        return builder.create();
    }


    public void init(){

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


}

