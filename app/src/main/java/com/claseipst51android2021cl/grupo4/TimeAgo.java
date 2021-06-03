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
            return "just now";
        } else if (minutes == 1) {
            //hace un minuto
            return "a minute ago";
            //hace minutos
        } else if (minutes > 1 && minutes < 60) {
            return minutes + " minutes ago";
        } else if (hours == 1) {
            //hace una hora
            return "an hour ago";
        } else if (hours > 1 && hours < 24) {
            //horas atras
            return hours + " hours ago";
        } else if (days == 1) {
            //Hace un día
            return "a day ago";
        } else {
            //hace días
            return days + " days ago";
        }

    }

}
