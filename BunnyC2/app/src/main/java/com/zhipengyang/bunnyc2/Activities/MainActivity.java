package com.zhipengyang.bunnyc2.activities;

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
import com.zhipengyang.bunnyc2.data_structure.CommonFunctions;
import com.zhipengyang.bunnyc2.fragments.actives.HomeFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private int internalVersion = 11;

    /**
     * Alert if update available
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (item.getItemId()) {
            case R.id.nav_city:
                Toast.makeText(getApplicationContext(), "City (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.school:
                Toast.makeText(getApplicationContext(), "School (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.hospital:
                Toast.makeText(getApplicationContext(), "Hospital (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.park:
                Toast.makeText(getApplicationContext(), "Park (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.restaurant:
                Toast.makeText(getApplicationContext(), "Restaurant (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.microsoft_research:
                Toast.makeText(getApplicationContext(), "Microsoft Research (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.google_corp:
                Toast.makeText(getApplicationContext(), "Google Corp (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.rotten_apple:
                Toast.makeText(getApplicationContext(), "Rotten apple Corp (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.abandoned_house:
                Toast.makeText(getApplicationContext(), "Abandoned house (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_home:
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction.add(R.id.main_container, homeFragment).commit();
                setTitle(R.string.nav_home);
                break;
            case R.id.nav_gallery:
                Toast.makeText(getApplicationContext(), "Gallery (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_shop:
                Toast.makeText(getApplicationContext(), "Shop (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_share:
                Toast.makeText(getApplicationContext(), "Share (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_send:
                Toast.makeText(getApplicationContext(), "Send (Not been implemented yet)", Toast.LENGTH_LONG).show();
                break;
        }

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
