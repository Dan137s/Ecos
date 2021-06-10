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

        //Las localizaciones

        // Ubicación "el faro" la serena
        LatLng FMLS = new LatLng(-29.905562377935368, -71.27430388326685);
        mMap.addMarker(new MarkerOptions().position(FMLS).title("Faro Monumental de La Serena").snippet("Lugar turístico se caracteriza por ser el símbolo de reconocimiento público de la ciudad es un faro funcional").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconturist)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(FMLS));

        // Ubicación "plaza de armas" la serena
        LatLng PALS = new LatLng(-29.902721444016393, -71.2520044996031);
        mMap.addMarker(new MarkerOptions().position(PALS).title("Plaza de Armas La Serena").snippet("Plaza principal de la ciudad de La Serena se caracteriza por su masiva concurrencia entre las 11:00 y 18:00 hrs").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconturist)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PALS));

        // Ubicación "Espejo de agua" la serena
        LatLng ESPA = new LatLng(-29.9026167, -71.2552734);
        mMap.addMarker(new MarkerOptions().position(ESPA).title("Espejo de Agua La Serena").snippet("Parque recreacional con aguas danzantes, un anfiteatro y un pueblo de artesanos").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconturist)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ESPA));

        // Ubicación "Parque Japones" la serena
        LatLng PAJP = new LatLng(-29.903850430766212, -71.2555715110424);
        mMap.addMarker(new MarkerOptions().position(PAJP).title("Parque Japones La Serena").snippet("Un parque recreacional se caracteriza por tener un jardin estilo japon con fauna asiatica").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconturist)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PAJP));

        // Ubicación "Parque Pedro de valdivia" la serena
        LatLng PADV = new LatLng(-29.8997269, -71.2548726);
        mMap.addMarker(new MarkerOptions().position(PADV).title("Parque Pedro de Valdivia la serena").snippet("Parque recreacional se caracteriza por tener gran parte de fauna chilena y campestre #Condor, #Vicuñas, #Tortugas...").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconturist)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PADV));

        // Ubicación "La Recova" la serena
        LatLng LRCV = new LatLng(-29.901573970737054, -71.24588645434174);
        mMap.addMarker(new MarkerOptions().position(LRCV).title("La Recova La Serena").snippet("Parque recreacional se caracteriza por tener gran parte de fauna chilena #Condores, #Vicuñas, #Tortugas...").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconturist)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LRCV));


        //Este es para centrar la vista o camara al cargar el mapa en una ubicacion predeterminada + un zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FMLS,12));
    }
}