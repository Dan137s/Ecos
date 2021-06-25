package com.claseipst51android2021cl.grupo4.Maps;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.claseipst51android2021cl.grupo4.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.claseipst51android2021cl.grupo4.databinding.ActivityMaps1Binding;

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback {
    //Variable privada de googlemaps
    private GoogleMap mMap;
    private ActivityMaps1Binding binding;
    private Button btnEcos, btnSitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMaps1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtiene SupportMapFragment y recibe una notificación cuando el mapa esté listo para ser utilizado.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getLocalizacion();

        //Casteo de los botones
        btnEcos = (Button) findViewById(R.id.btn_ec);
        btnSitios = (Button) findViewById(R.id.btn_sit);

        /**Eventos de botones **/

        //Ecos
        btnEcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent (getApplicationContext(),MapsActivity3.class);
                startActivity(i1);
            }
        });
        //Sitios Turisticos
        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent (getApplicationContext(),MapsActivity2.class);
                startActivity(i2);
            }
        });
    }

    /**
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
**/
    //Metodo de Geolocalización
    private void getLocalizacion() {
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permiso == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    //La variable onMapReady que recibe los parametros desde el permiso en el manifest de localizacion
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //Mi locacion
        mMap.setMyLocationEnabled(true);

        //Añado el boton (+, -) del zoom en pantalla
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);

        LocationManager locationManager = (LocationManager) MapsActivity1.this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {

            //Este es el metodo de cambio de ubicacion actual latitud y longitud
            @Override
            public void onLocationChanged(Location location) {
                LatLng miUbicacion = new LatLng(location.getLatitude(), location.getLongitude());

                //Marcador de la ub. actual
                mMap.addMarker(new MarkerOptions().position(miUbicacion).title("Ubicación actual").icon(BitmapDescriptorFactory.fromResource(R.drawable.marca3)));

                //Foco de la camara según la ubicación
                mMap.moveCamera(CameraUpdateFactory.newLatLng(miUbicacion));
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(miUbicacion)
                        .zoom(14)
                        .bearing(90)
                        .tilt(45)
                        .build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);


        // Ubicación Pais Chile principal no Australia, sidney ya bueno disney
        LatLng CpCL = new LatLng(-33.43782949348624, -70.65044066638902);
        mMap.addMarker(new MarkerOptions().position(CpCL).title("Chile").snippet("Capital de chile, Santiago Región Metropolitana").icon(BitmapDescriptorFactory.fromResource(R.drawable.chile)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CpCL));

        // Ubicación Pais Argentina
        LatLng CpAR = new LatLng(-34.6075682, -58.4370894);
        mMap.addMarker(new MarkerOptions().position(CpAR).title("Argentina").snippet("Capital de argentina, Buenos Aires es la gran capital cosmopolita").icon(BitmapDescriptorFactory.fromResource(R.drawable.argentina)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CpAR));

        // Ubicación Pais Brasil
        LatLng CpBR = new LatLng(-15.7754462, -47.7970891);
        mMap.addMarker(new MarkerOptions().position(CpBR).title("Brasil").snippet("Capital de Brasil, Brasilia fue construida con el fin de ser la nueva capital de Brasil").icon(BitmapDescriptorFactory.fromResource(R.drawable.brasil)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CpBR));

        //Este es para centrar la vista o camara al cargar el mapa en una ubicacion predeterminada + un zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CpCL,5));

    }
}











