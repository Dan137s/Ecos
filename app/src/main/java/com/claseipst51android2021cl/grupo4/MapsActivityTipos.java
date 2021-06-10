package com.claseipst51android2021cl.grupo4;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.claseipst51android2021cl.grupo4.databinding.ActivityMapsTiposBinding;

public class MapsActivityTipos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btn_hibrido, btn_normal, btn_satelital, btn_terreno;
    private ActivityMapsTiposBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsTiposBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtenga SupportMapFragment y reciba una notificación cuando el mapa esté listo para usarse.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Casteo de los botones
        btn_hibrido = (Button) findViewById(R.id.btn_hibrido);
        btn_satelital = (Button) findViewById(R.id.btn_satelital);
        btn_normal = (Button) findViewById(R.id.btn_normal);
        btn_terreno = (Button) findViewById(R.id.btn_terreno);

    }

    //Aqui cargara el mapa segun la version seleccionada con el evento del boton
    public void CambiarHibrido(View view)
    {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
    public void CambiarSatelital(View view)
    {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
    public void CambiarTerreno(View view)
    {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }
    public void CambiarNormal(View view)
    {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        //Añado el boton (+, -) del zoom en pantalla
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Ubicación Pais Chile principal no Australia, sidney ya bueno disney
        LatLng CpCL = new LatLng(-33.43782949348624, -70.65044066638902);
        mMap.addMarker(new MarkerOptions().position(CpCL).title("Chile").snippet("Capital de chile, Santiago Región Metropolitana").icon(BitmapDescriptorFactory.fromResource(R.drawable.chile)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CpCL));

        //Este es para centrar la vista o camara al cargar el mapa en una ubicacion predeterminada + un zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CpCL,8));
    }
}











