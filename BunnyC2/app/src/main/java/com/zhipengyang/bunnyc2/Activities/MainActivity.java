package com.zhipengyang.bunnyc2.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.data.TestAction;
import com.zhipengyang.bunnyc2.data.TestListener;
import com.zhipengyang.bunnyc2.data_structure.CommonFunctions;
import com.zhipengyang.bunnyc2.fragments.actives.HomeFragment;
import com.zhipengyang.bunnyc2.gameManagers.HeartBeat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static int internalVersion = 19; //App version for detecting updates
    private Fragment fragmentOpened = null;
    private static HeartBeat heartBeat = null;

    private void removeOpenedFragment() {
        if (fragmentOpened != null) {
            getFragmentManager().beginTransaction().remove(fragmentOpened).commit();
            fragmentOpened = null;
        }
    }

    /**
     * Alert if update available
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Begin the game loop
        TestListener testListener = new TestListener();
        HeartBeat heartBeat = HeartBeat.getInstance();
        heartBeat.setEventListener(testListener, new TestAction(), 1000);

        //Detect updates
        CommonFunctions.detectUpdates(getApplicationContext(), this, internalVersion);

        FloatingActionButton fab;
        if ((fab = (FloatingActionButton) findViewById(R.id.fab)) == null) {
            Toast.makeText(getApplicationContext(), "Error code: 0x0001", Toast.LENGTH_LONG).show();
            return;
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.contact_author), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView == null) {
            Toast.makeText(getApplicationContext(), "Error code: 0x0002", Toast.LENGTH_LONG).show();
            return;
        }
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer == null) {
            Toast.makeText(getApplicationContext(), "Error code: 0x0003", Toast.LENGTH_LONG).show();
            return;
        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            startActivity(new Intent(this, SettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        // Handle navigation view item clicks here.

        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        switch (item.getItemId()) {
                            //0
                            case R.id.nav_city:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "City (Working)", Toast.LENGTH_LONG).show();
                                break;
                            //1
                            case R.id.school:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "School (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //2
                            case R.id.hospital:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Hospital (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //3
                            case R.id.park:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Park (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //4
                            case R.id.restaurant:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Restaurant (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //5
                            case R.id.microsoft_research:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Microsoft Research (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //6
                            case R.id.google_corp:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Google Corp (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //7
                            case R.id.rotten_apple:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Rotten apple Corp (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //8
                            case R.id.factory:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Factory (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //9
                            case R.id.abandoned_house:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Abandoned house (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //10
                            case R.id.nav_home:
                                HomeFragment homeFragment = new HomeFragment();
                                fragmentTransaction.add(R.id.main_container, homeFragment).commit();
                                setTitle(R.string.nav_home);
                                removeOpenedFragment();
                                fragmentOpened = homeFragment;
                                break;
                            //11
                            case R.id.nav_gallery:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Gallery (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //12
                            case R.id.nav_shop:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Shop (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //13
                            case R.id.nav_share:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Share (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                            //14
                            case R.id.nav_send:
                                removeOpenedFragment();
                                Toast.makeText(getApplicationContext(), "Send (Coming Soon..)", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                });
            }
        }).start();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer == null)

        {
            Toast.makeText(getApplicationContext(), "Error code: 0x0004", Toast.LENGTH_LONG).show();
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
