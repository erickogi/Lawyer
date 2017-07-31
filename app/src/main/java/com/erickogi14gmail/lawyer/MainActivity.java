package com.erickogi14gmail.lawyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.erickogi14gmail.lawyer.AskLawyer.AskLawyerFragment;
import com.erickogi14gmail.lawyer.Login.LoginActivity;
import com.erickogi14gmail.lawyer.Login.LoginFragment;
import com.erickogi14gmail.lawyer.Login.PrefrnceManager;
import com.erickogi14gmail.lawyer.Notifications.FragmentNotifications;

import com.erickogi14gmail.lawyer.ServicesList.Pricing;
import com.erickogi14gmail.lawyer.ServicesList.ServicesList;
import com.erickogi14gmail.lawyer.UserProfile.ProfileFragment;
import com.erickogi14gmail.lawyer.chat.Chat;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static Fragment fragment = null;
    public static  boolean isMain=true;
    public static  String serviceName="";
    public static String product="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PrefrnceManager prefrnceManager=new PrefrnceManager();

        if(prefrnceManager.onorof(getApplicationContext())) {
            fragment = new HomeFragment();
            setUpView();


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }
        else {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(getFragmentManager().getBackStackEntryCount()!=0){
           getFragmentManager().popBackStack();
//            fragment=new HomeFragment();
//            isMain=true;
//            setUpView();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
           // isMain=true;
            fragment=new HomeFragment();
            setUpView();



            // Handle the camera action
        } else if (id == R.id.nav_chats) {

            startActivity(new Intent(MainActivity.this,Chat.class));

        } else if (id == R.id.nav_notices) {
            fragment=new FragmentNotifications();
          //  isMain=false;
            setUpView();
        } else if (id == R.id.nav_settings) {
           // isMain=true;
           // fragment=new LoginFragment();
           // setUpView();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
        }

    }



    public void editProfile(View view) {
        fragment=new ProfileFragment();

        //isMain=false;
        setUpView();

    }

    public void openPersonal(View view) {
        fragment=new ServicesList();
       // product="Personal";
        isMain=false;
        setUpView();
    }


    public void openCourtMatters(View view) {
        fragment=new ServicesList();
        product="Court Matters";
       // isMain=false;
        setUpView();
    }

    public void askALawyer(View view) {
        fragment=new AskLawyerFragment();
       // isMain=false;
        setUpView();
    }

    public void openeservice(View view) {
    }

    public void openHowItWorks(View view) {
    }

    public void openebusiness(View view) {
        fragment=new ServicesList();
        product="E-Business";
       // isMain=false;
        setUpView();
    }

    public void openPricing(View view) {
        fragment=new Pricing();
        product="E-Business";
       // isMain=false;
        setUpView();
    }

    public void save(View view) {
    }



    public void sendQuestion(View view) {
    }
}
