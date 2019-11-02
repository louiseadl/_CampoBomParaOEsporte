package com.telahome.campobomparaoesporte;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;

import android.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.telahome.campobomparaoesporte.ui.login.LoginActivity;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class Main_LoginMapsActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener,OnMapReadyCallback{

    SupportMapFragment sMapFragment;

    private AppBarConfiguration mAppBarConfiguration;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        sMapFragment = SupportMapFragment.newInstance();

        setContentView(R.layout.activity_main__login_maps);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawer , toolbar , R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       FragmentManager fm= getFragmentManager();
      /*
         fm.beginTransaction().replace(R.id.nav_host_fragment, new MainFragment()).commit();
         Passing each menu ID as a set of Ids because each
         menu should be considered as top level destinations.
        */


        mAppBarConfiguration = new AppBarConfiguration.Builder(
               R.id.nav_view, R.id.nav_tools, R.id.nav_slideshow,R.id.nav_home,R.id.nav_share, R.id.nav_send,R.id.map)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        sMapFragment.getMapAsync(this);
    }
    @Override
    public void onBackPressed () {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main__login_maps, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.action_settings) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng campo_bom = new LatLng(-29.675577,-51.060874);
        mMap.addMarker(new MarkerOptions().position(campo_bom).title("Marcador em Campo Bom"));
        CameraPosition cameraPosition = new CameraPosition.Builder().zoom(20).target(campo_bom).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fragmentManager = getFragmentManager();

        int id = item.getItemId();

        if (id == R.id.nav_view) {
            Toast.makeText(Main_LoginMapsActivity.this, "nav_viwer", Toast.LENGTH_LONG).show();

            //fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, new ConfiguracaoContaFragment()).commit();

        } else if (id == R.id.nav_tools) {
            Toast.makeText(Main_LoginMapsActivity.this, "nav_tools", Toast.LENGTH_LONG).show();
           // fragmentManager.beginTransaction().replace(R.id.nav_criacao_layout, new CriacaoFragment()).commit();

        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(Main_LoginMapsActivity.this, "nav_slideshow", Toast.LENGTH_LONG).show();
           // fragmentManager.beginTransaction().replace(R.id.nav_criacao_layout, new MainActivity()).commit();

        } else if (id == R.id.nav_home) {
            Toast.makeText(Main_LoginMapsActivity.this, "nav_home", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(Main_LoginMapsActivity.this, "nav_share", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(Main_LoginMapsActivity.this, "nav_send", Toast.LENGTH_LONG).show();

        } else if (id == R.id.map){
            Toast.makeText(Main_LoginMapsActivity.this, "nav_map", Toast.LENGTH_LONG).show();





        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}



