package demo.helpscout.activitys;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.EntypoModule;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.joanzapata.iconify.fonts.MeteoconsModule;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.joanzapata.iconify.fonts.TypiconsModule;
import com.joanzapata.iconify.fonts.WeathericonsModule;

import demo.helpscout.R;
import fragments.MailBoxFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout; //Instancia del drawer
    private String drawerTitle; //Titulo inicial del drawer 1D1D1D
    private String ACTIONBAR_COLOR="#3ac065";
    public static CharSequence mTitle;
    public NavigationView navigationView;
    public NavigationView navigationViewMailBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Iconify
                .with(new FontAwesomeModule())
                .with(new EntypoModule())
                .with(new TypiconsModule())
                .with(new MaterialModule())
                .with(new MaterialCommunityModule())
                .with(new MeteoconsModule())
                .with(new WeathericonsModule())
                .with(new SimpleLineIconsModule())
                .with(new IoniconsModule());

        setContentView(R.layout.activity_main);

        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationViewMailBox = (NavigationView) findViewById(R.id.nav_mailBox);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        // drawerTitle = getResources().getString(R.string.welcome);
        if (savedInstanceState == null) {
            selectItem("MailBox");
            loadNavHeader();
        }
    }

    /***
     * Load navigation menu header information
     * like background image, profile image
     * name, website, notifications action view (dot)
     */
    private void loadNavHeader() {
        /*
        // name, website
        txtName.setText("Ravi Tamada");
        txtWebsite.setText("www.androidhive.info");

        // loading header background image
        Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // Loading profile image
        Glide.with(this).load(urlProfileImg)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);

        */

        // showing dot next to notifications label
        //navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_counter);
        navigationView.getMenu().findItem(R.id.nav_unassugned).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_square_o)
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());

        navigationView.getMenu().findItem(R.id.nav_unassugned).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_list_ul)
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());

        navigationView.getMenu().findItem(R.id.nav_mine).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_hand_paper_o)
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());

        navigationView.getMenu().findItem(R.id.nav_drafts).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_files_o)
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());

        navigationView.getMenu().findItem(R.id.nav_assigned).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_files_o )
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());

        navigationView.getMenu().findItem(R.id.nav_closed).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_archive )
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());

        navigationView.getMenu().findItem(R.id.nav_spam).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_ban )
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());


        navigationView.getMenu().findItem(R.id.nav_product).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_users )
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());

        navigationView.getMenu().findItem(R.id.nav_marketing).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_users )
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());



        navigationView.getMenu().findItem(R.id.nav_folder_1).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_folder_open_o )
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());

        navigationView.getMenu().findItem(R.id.nav_folder_2).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_folder_open_o )
                        .colorRes(R.color.md_disabled_hint_text)
                        .actionBarSize());


        //TextView view = (TextView) navigationView.getMenu().findItem(1).getActionView();
        //view.setText(6 > 0 ? String.valueOf(6) : null);
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        String title = menuItem.getTitle().toString();
                        selectItem(title);
                        mTitle = title;
                        return true;
                    }
                }
        );

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_conv_details, menu);
        return true;
    }
    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        //actionBar.setLogo(R.drawable.icon_header);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(ACTIONBAR_COLOR)));//Cambia el color de fondo de ActionBar
    }

    /* btn Back in fragments */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            case R.id.menuSupport:
                //drawerLayout.openDrawer(GravityCompat.START);
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(String opcSelected) {
        //getSupportActionBar().setTitle(opcSelected);

        // Enviar título como arguemento del fragmento
        Fragment fragment = null;
        String TAG = "TEST_A";

        if (opcSelected.equals("MailBox")) {
            mTitle = "MailBox";
            //TAG = TAG_HOME;
            fragment = new MailBoxFragment();
        }


        if (opcSelected.equals(getString(R.string.conversations))) {
            mTitle = getString(R.string.conversations);
            //TAG = TAG_HOME;
            //fragment = new ConversationsFragment2();
        }

        else{
            fragment = new MailBoxFragment();
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
