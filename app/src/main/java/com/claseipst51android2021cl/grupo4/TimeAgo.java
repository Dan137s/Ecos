package com.claseipst51android2021cl.grupo4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeAgo {

    //Clase para crear el tiempo de la grabacion
    public String getTimeAgo(long duration) {
        Date now = new Date();

        //El tiempo es en MILISEGUNDOS
        long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - duration);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - duration);
        long hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - duration);
        long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - duration);

        if(seconds < 60){
            //En este momento
            return "Ahora";
        } else if (minutes == 1) {
            //hace un minuto
            return " un minuto atrás";
            //hace minutos
        } else if (minutes > 1 && minutes < 60) {
            return minutes + " minutos atrás";
        } else if (hours == 1) {
            //hace una hora
            return " hora atrás";
        } else if (hours > 1 && hours < 24) {
            //horas atras
            return hours + " horas atrás";
        } else if (days == 1) {
            //Hace un día
            return " Día atrás";
        } else {
            //hace días
            return days + " días atrás";
        }

    }

}
