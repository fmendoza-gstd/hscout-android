package demo.helpscout.activitys;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import demo.helpscout.R;
import fragments.ConversationsFragment2;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout; //Instancia del drawer
    private String drawerTitle; //Titulo inicial del drawer 1D1D1D
    private String ACTIONBAR_COLOR="#3ac065";
    public static CharSequence mTitle;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setToolbar(); // Setear Toolbar como action bar

        selectItem("conversations");
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            //ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void selectItem(String opcSelected) {
        //getSupportActionBar().setTitle(opcSelected);

        // Enviar título como arguemento del fragmento
        Fragment fragment = null;
        String TAG = "TEST_A";

        if (opcSelected.equals(getString(R.string.conversations))) {
            mTitle = getString(R.string.conversations);
            //TAG = TAG_HOME;
            fragment = new ConversationsFragment2();
        }

        else{
            fragment = new ConversationsFragment2();
        }


        if (fragment != null) {
            FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
            //fragmentManager.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left);
            fragmentManager.replace(R.id.main_content, fragment, TAG);
            //fragmentManager.addToBackStack(TAG);
            fragmentManager.commit();

        } else {
            //Log.e("Error  ", "MostrarFragment" + position);//Si el fragment es nulo mostramos un mensaje de error.
        }
       // drawerLayout.closeDrawers(); // Cerrar drawer
        setTitle(mTitle); // Setear título actual

    }
}
