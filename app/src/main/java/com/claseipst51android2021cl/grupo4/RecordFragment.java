package com.claseipst51android2021cl.grupo4;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment implements View.OnClickListener {

    private NavController navController;

    private ImageButton listBtn;
    private ImageButton recordBtn;
    private TextView filenameText;

    private boolean isRecording = false;

    private String recordPermission = Manifest.permission.RECORD_AUDIO;
    private int PERMISSION_CODE = 21;

    private MediaRecorder mediaRecorder;
    private String recordFile;

    private Chronometer timer;

    public RecordFragment() {
        //Constructor público vacío requerido
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflar el diseño de este fragmento
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Inicializar variables
        navController = Navigation.findNavController(view);
        listBtn = view.findViewById(R.id.record_list_btn);
        recordBtn = view.findViewById(R.id.record_btn);
        timer = view.findViewById(R.id.record_timer);
        filenameText = view.findViewById(R.id.record_filename);

        /* Configuración de escucha de clics
            - La clase debe implementar 'View.OnClickListener' y anular el método 'onClick'
         */
        listBtn.setOnClickListener(this);
        recordBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        /*  Verifique qué botón está presionado y realice la tarea en consecuencia
         */
        switch (v.getId()) {
            case R.id.record_list_btn:
                /*
                  Controlador de navegación
                  Parte de Android Jetpack, que se utiliza para la navegación entre ambos fragmentos.
                 */
                if(isRecording){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                    alertDialog.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            navController.navigate(R.id.action_recordFragment_to_audioListFragment);
                            isRecording = false;
                        }
                    });
                    alertDialog.setNegativeButton("CANCEL", null);
                    alertDialog.setTitle("Grabación de audio fija");
                    alertDialog.setMessage("¿Estás seguro de que quieres detener la grabación?");
                    alertDialog.create().show();
                } else {
                    navController.navigate(R.id.action_recordFragment_to_audioListFragment);
                }
                break;

            case R.id.record_btn:
                if(isRecording) {
                    //Para de grabar
                    stopRecording();

                    //Cambiar la imagen del botón y establecer el estado de grabación en falso
                    recordBtn.setImageDrawable(getResources().getDrawable(R.drawable.record_btn_stopped, null));
                    isRecording = false;
                } else {
                    //Verifica el permiso para grabar audio
                    if(checkPermissions()) {
                        //Iniciar la grabación
                        startRecording();

                        //Cambiar la imagen del botón y establecer el estado de grabación en falso
                        recordBtn.setImageDrawable(getResources().getDrawable(R.drawable.record_btn_recording, null));
                        isRecording = true;
                    }
                }
                break;
        }
    }

    private void stopRecording() {
        //Temporizador de parada, muy obvio xD
        timer.stop();

        //Cambiar el texto de la página al archivo guardado
        filenameText.setText("Grabación detenida, archivo guardado : " + recordFile);

        //Detenga la grabadora de medios y configúrela en nulo para su uso posterior para grabar audio nuevo
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }

    private void startRecording() {
        //Iniciar temporizador desde 0
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        //Obtener la ruta del directorio externo de la aplicación
        String recordPath = getActivity().getExternalFilesDir("/").getAbsolutePath();

        //Obtener la fecha y hora actual
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss", Locale.CANADA);
        Date now = new Date();

        //Inicializar la variable de nombre de archivo con la fecha y la hora al final para asegurarse de que el nuevo archivo no sobrescriba el archivo anterior
        recordFile = "Grabación_" + formatter.format(now) + ".3gp";

        filenameText.setText("Grabación, nombre de archivo : " + recordFile);

        //Configurar Media Recorder para grabar
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(recordPath + "/" + recordFile);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Iniciar la grabación
        mediaRecorder.start();
    }

    private boolean checkPermissions() {
        //Verificar permiso
        if (ActivityCompat.checkSelfPermission(getContext(), recordPermission) == PackageManager.PERMISSION_GRANTED) {
            //Permiso concedido
            return true;
        } else {
            //Permiso no otorgado, pedir permiso
            ActivityCompat.requestPermissions(getActivity(), new String[]{recordPermission}, PERMISSION_CODE);
            return false;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(isRecording){
            stopRecording();
        }
    }
}
