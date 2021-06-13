package com.claseipst51android2021cl.grupo4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

public class MenuActivityInvitado extends AppCompatActivity {
    //Declaro las vbles, para usar los botones del menu_activity y llamar las sgtes act. dentro de un cardview
    CardView ubicacion, listadoeco, compartir, iniciarse;

    //Crear una alerta para encender gps
    AlertDialog alertaGPS = null;

    //Crear una alerta para encender internet
    AlertDialog alertaINT = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_invitado);

        //Titulo de la aplicacion o action bar que lo centre
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_titulo);

        //Castear referenciar las vbles con las del menu_activity por vble+id
        ubicacion = (CardView) findViewById(R.id.idcard1);
        listadoeco = (CardView) findViewById(R.id.idcard2);
        compartir = (CardView) findViewById(R.id.idcard3);
        iniciarse = (CardView) findViewById(R.id.idcard4);

        //Recordando que los CardView son las tarjetas o botones que enlazan"Botones del menú"

        //Llamo a los metodos
        getUbicacion();
        getListaEco();
        getCompartir();
        getIniciarSe();
        getAlertaNotGps();
        getAlertaNotInternet();
    }



    //Metodos para los botones solo redireccion a pestañas"Activities":
    // Ubicación, Lista Ecos, Compartir la app, Iniciar sesión.

    private void getAlertaNotInternet() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hola bienvenid@s a ecos. Revisar tu conexion a internet?")
                .setCancelable(false)
                .setIcon(R.drawable.iconturist)
                .setTitle("GPS")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                dialog.cancel();

            }
        });
        alertaINT = builder.create();
        alertaINT.show();

    }


    //Alerta de gps apagado
    private void getAlertaNotGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Por favor encienda el GPS. Desea activarlo?")
                .setCancelable(false)
                .setIcon(R.drawable.marca3)
                .setTitle("GPS")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                dialog.cancel();

            }
        });
        alertaGPS = builder.create();
        alertaGPS.show();
    }

    //Ubicación
    private void getUbicacion() {
            ubicacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent im1 = new Intent(MenuActivityInvitado.this, MainActivityUbicacion.class);
                    StyleableToast.makeText(getApplicationContext(), "Re-direccion ubicación",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                    startActivity(im1);
                }
            });
        }

        //Lista ecos
    private void getListaEco() {
            listadoeco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent im3 = new Intent(MenuActivityInvitado.this, MainActivityListadoEco.class);
                    StyleableToast.makeText(getApplicationContext(), "Re-direccion Listado de Ecos",
                            Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                    startActivity(im3);
                }
            });
        }

        //Compartir la app
    private void getCompartir() {
        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im3 = new Intent(MenuActivityInvitado.this, MainActivityCompartirApp.class);
                StyleableToast.makeText(getApplicationContext(), "Compartamos nuestra app",
                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                startActivity(im3);
            }
        });
    }

        //Back inicio
    private void getIniciarSe() {
        iniciarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im3 = new Intent(MenuActivityInvitado.this, MainActivityInicio.class);
                StyleableToast.makeText(getApplicationContext(), "Bienvenidos a Ecos",
                        Toast.LENGTH_LONG, R.style.ColoredStroke).show();
                startActivity(im3);
            }
        });
    }

    //Metodo
    }