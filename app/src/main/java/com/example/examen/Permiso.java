package com.example.examen;

public class Permiso {
    private  String Nombre;
    private  String Nombre_Real;

    public Permiso(String nombre, String nombre_Real) {
        Nombre = nombre;
        Nombre_Real = nombre_Real;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre_Real() {
        return Nombre_Real;
    }

    public void setNombre_Real(String nombre_Real) {
        Nombre_Real = nombre_Real;
    }
}
