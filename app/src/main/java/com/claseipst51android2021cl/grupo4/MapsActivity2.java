package com.claseipst51android2021cl.grupo4;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.claseipst51android2021cl.grupo4.databinding.ActivityMaps2Binding;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Ubicación del faro la serena
        LatLng FMLS = new LatLng(-29.905562377935368, -71.27430388326685);
        mMap.addMarker(new MarkerOptions().position(FMLS).title("Faro monumental de la serena").snippet("Lugar turístico se caracteriza por ser el símbolo de reconocimiento público de la ciudad es un faro funcional").icon(BitmapDescriptorFactory.fromResource(R.drawable.mexico)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(FMLS));


        // Ubicación plaza de armas la serena
        LatLng PALS = new LatLng(-29.902721444016393, -71.2520044996031);
        mMap.addMarker(new MarkerOptions().position(PALS).title("Plaza de armas la serena").snippet("Plaza principal de la ciudad de La Serena se caracteriza por su masiva concurrencia entre las 11:00 y 18:00 hrs").icon(BitmapDescriptorFactory.fromResource(R.drawable.mexico)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PALS));


        //Este es para centrar la vista o camara al cargar el mapa en una ubicacion predeterminada + un zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FMLS,12));
    }
}