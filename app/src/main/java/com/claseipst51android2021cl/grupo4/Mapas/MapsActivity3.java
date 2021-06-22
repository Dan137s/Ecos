package com.claseipst51android2021cl.grupo4.Mapas;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.claseipst51android2021cl.grupo4.Fragments.RegimientoAricaFragment;
import com.claseipst51android2021cl.grupo4.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.claseipst51android2021cl.grupo4.databinding.ActivityMaps3Binding;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.Locale;

public class MapsActivity3 extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMaps3Binding binding;
    private Button btn_hibrido, btn_normal, btn_satelital, btn_terreno;

    //Variable de tipo marcador para añadir despues manualmente los marcadores o usar los mmap
    private Marker markerPrueba;
    //Variable de tipo marcador Drag para mover el punto seleccionado
    private Marker markerDrag;
    //Variable de tipo ventana de información
    private Marker InfoWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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
        mMap = googleMap;
        //Mi locacion
        mMap.setMyLocationEnabled(true);
        //Añado el boton (+, -) del zoom en pantalla
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);

        LocationManager locationManager = (LocationManager) MapsActivity3.this.getSystemService(Context.LOCATION_SERVICE);
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



        /**Las localizaciones usando mMap**/
        // Ubicación "el faro" la serena
        LatLng FMLS = new LatLng(-29.905562377935368, -71.27430388326685);
        mMap.addMarker(new MarkerOptions().position(FMLS).draggable(true).title("Faro Monumental de La Serena").snippet("Lugar turístico se caracteriza por ser el símbolo de reconocimiento público de la ciudad es un faro funcional").icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(FMLS));

        // Ubicación "plaza de armas" la serena
        LatLng PALS = new LatLng(-29.902721444016393, -71.2520044996031);
        mMap.addMarker(new MarkerOptions().position(PALS).draggable(true).title("Plaza de Armas La Serena").snippet("Plaza principal de la ciudad de La Serena se caracteriza por su masiva concurrencia entre las 11:00 y 18:00 hrs").icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PALS));

        // Ubicación "Espejo de agua" la serena
        LatLng ESPA = new LatLng(-29.9026167, -71.2552734);
        mMap.addMarker(new MarkerOptions().position(ESPA).draggable(true).title("Espejo de Agua La Serena").snippet("Parque recreacional con aguas danzantes, un anfiteatro y un pueblo de artesanos").icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ESPA));

        // Ubicación "Parque Japones" la serena
        LatLng PAJP = new LatLng(-29.903850430766212, -71.2555715110424);
        mMap.addMarker(new MarkerOptions().position(PAJP).draggable(true).title("Parque Japones La Serena").snippet("Un parque recreacional se caracteriza por tener un jardin estilo japon con fauna asiatica").icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PAJP));

        // Ubicación "Parque Pedro de valdivia" la serena
        LatLng PADV = new LatLng(-29.8997269, -71.2548726);
        mMap.addMarker(new MarkerOptions().position(PADV).draggable(true).title("Parque Pedro de Valdivia la serena").snippet("Parque recreacional se caracteriza por tener gran parte de fauna chilena y campestre #Condor, #Vicuñas, #Tortugas...").icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PADV));

        // Ubicación "La Recova" la serena
        LatLng LRCV = new LatLng(-29.901573970737054, -71.24588645434174);
        mMap.addMarker(new MarkerOptions().position(LRCV).draggable(true).title("La Recova La Serena").snippet("Parque recreacional se caracteriza por tener gran parte de fauna chilena #Condores, #Vicuñas, #Tortugas...").icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LRCV));

        //Manual con variable declarada
        //Ubicación de marcador manual para trabajar con eventos
        LatLng prueba = new LatLng(-29.9119218, -71.2523748);
        markerPrueba = googleMap.addMarker(new MarkerOptions()
                .position(prueba)
                .title("Estadio la portada")
                .snippet("Club de Deportes La Serena local")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1))
        );

        //Manual con variable declarada
        //Ubicación de marcador manual aeropuerto para trabajar con eventos
        LatLng prueba2 = new LatLng(-29.915546, -71.2019442);
        markerDrag = googleMap.addMarker(new MarkerOptions()
                .position(prueba2)
                .title("Aeropuerto La Florida")
                .snippet("Condominio Portal La Florida, 172 1885 La Serena, Chile")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1))
                .draggable(true)
        );

        //Ubicación de marcador manual regimiento para trabajar con informacion extendida
        LatLng prueba3 = new LatLng(-29.905164,  -71.238731);
        InfoWindow = googleMap.addMarker(new MarkerOptions()
                .position(prueba3)
                .title("Regimiento Arica")
                .snippet("Regimiento de Infanteria N 21 Arica de la Serena")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ecosound1))
                .draggable(true)
        );
        /**Metodos Que use en esta clase**/
        //1-Camara es para centrar la vista o camara al cargar el mapa en una ubicacion predeterminada + un zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FMLS, 13));
        //2-Clik en el marcador
        googleMap.setOnMarkerClickListener(this);
        //3-Arrastrar el marcador
        googleMap.setOnMarkerDragListener(this);
        //4-Dialogo
        googleMap.setOnInfoWindowClickListener(this);
    }

    /**2- Clik en el marcador**/
    //Esto me servira para reproducir los ecos al tocar el icono puedo hacer un swcht o con un if manejar las ubicaciones
    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(markerPrueba)) {

            //Voy a declarar 2  variables longitud y latitud para mostrar en el toast
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            StyleableToast.makeText(getApplicationContext(), lat + ", " + lng,
                    Toast.LENGTH_LONG, R.style.ColoredStroke).show();

        }
        return false;
    }


    /**3- Drag listener**/
    //1-Cuando comienza arrastrar
    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker.equals(markerDrag)) {
            StyleableToast.makeText(getApplicationContext(), "Moviendo de posición",
                    Toast.LENGTH_LONG, R.style.ColoredStroke).show();
        }
    }
    //2-Esta arrastrando
    @Override
    public void onMarkerDrag(Marker marker) {
        if (marker.equals(markerDrag)) {
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlng),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);
            setTitle(newTitle);
        }
    }
    //3-Cuando termina de arrastrar
    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker.equals(markerDrag)) {
            StyleableToast.makeText(getApplicationContext(), "Soltaste y cambiaste la posición",
                    Toast.LENGTH_LONG, R.style.ColoredStroke).show();
            setTitle(R.string.title_activity_maps2);
        }
    }
    /**4 Ventanas de dialogos**/
    @Override
    public void onInfoWindowClick(Marker marker) {
        if(marker.equals(InfoWindow)){
            RegimientoAricaFragment.newIntance(marker.getTitle(),
                    getString(R.string.Regimientoinfo))
                    .show(getSupportFragmentManager(),null);
        }

    }
}
