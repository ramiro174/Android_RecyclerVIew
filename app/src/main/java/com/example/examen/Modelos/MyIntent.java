package com.example.examen.Modelos;

import android.content.Intent;

public class MyIntent {
    private  String Nombre;
    private Intent MyIntent;
    private  Foto Imagen;

    public MyIntent(String nombre, Intent myIntent) {
        Nombre = nombre;
        MyIntent = myIntent;
    }

    public MyIntent(String nombre, Intent myIntent, Foto imagen) {
        Nombre = nombre;
        MyIntent = myIntent;
        Imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Intent getMyIntent() {
        return MyIntent;
    }

    public void setMyIntent(Intent myIntent) {
        MyIntent = myIntent;
    }
}
