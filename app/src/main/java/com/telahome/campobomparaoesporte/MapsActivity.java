package com.telahome.campobomparaoesporte;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Camera;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng campo_bom = new LatLng(-29.675577,-51.060874);
        mMap.addMarker(new MarkerOptions().position(campo_bom).title("Marcador em Campo Bom"));
        CameraPosition cameraPosition = new CameraPosition.Builder().zoom(20).target(campo_bom).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));




    }
}

