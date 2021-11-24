package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.examen.Adaptadores.AdaptadorIntents;
import com.example.examen.Modelos.Foto;
import com.example.examen.Modelos.MyIntent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView re;
    List<Permiso> Permisos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Permisos=new ArrayList<>();
        Permisos.add(new Permiso("LLamar", Manifest.permission.CALL_PHONE));

        verficarPermisos(Permisos);

        List<MyIntent> MyIntents = new ArrayList<>();

        int x=5;
        Intent i=new Intent(Intent.ACTION_CALL, Uri.parse("tel:871-276-5065"));

        MyIntents.add(
                new MyIntent("Llamar",i)
        );
        MyIntents.add(new MyIntent("ira 2 actividad",new Intent(this,MainActivity2.class)));
        MyIntents.add(new MyIntent("Navegador",new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))));
        MyIntents.add(new MyIntent("Dialer",new Intent(Intent.ACTION_DIAL)));
        MyIntents.add(new MyIntent("mapa",new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?z=4&q;=restaurantes"))));
        MyIntents.add(
                new MyIntent("mapa",
                        new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?z=4&q;=restaurantes")),
                        new Foto(new ImageView(this))
                             )
        );

        re = findViewById(R.id.lista);
        re.setHasFixedSize(true);

        AdaptadorIntents awd = new AdaptadorIntents(MyIntents,this);
        LinearLayoutManager lr = new LinearLayoutManager(this);
        re.setLayoutManager(lr);
        re.setAdapter(awd);


    }

    private void verficarPermisos(List<Permiso> Permisos) {

        String[] permisosDenegados=new String[10];

        for(int i=0;i<Permisos.size();i++){
            if(ContextCompat.checkSelfPermission(this,Permisos.get(i).getNombre_Real())== PackageManager.PERMISSION_DENIED ){
                permisosDenegados[i]=Permisos.get(i).getNombre_Real();
            }
            //
        }
//        String[] PermisosDenegados =  Permisos.stream().filter(
//                (p)-> ContextCompat.checkSelfPermission(getApplicationContext(),p.getNombre_Real()) == PackageManager.PERMISSION_DENIED
//                    ).collect(Collectors.toList()).stream().map((permiso) ->{ return permiso.getNombre_Real(); }).collect(Collectors.toList()).toArray(new  String[10]);

        requestPermissions(permisosDenegados,2000);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 2000:

                if (permissions.length > 0 &&  grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //volver hacer la accion

                } else {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {



                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage("Debes aceptar el permiso para que funcione la app");

                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                verficarPermisos(Permisos);
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }

                }

        }


    }
}