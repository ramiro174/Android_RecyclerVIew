package com.example.examen.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.Modelos.MyIntent;
import com.example.examen.R;

import java.util.List;

public class AdaptadorIntents   extends RecyclerView.Adapter<AdaptadorIntents.ViewHolder> {
    private List<MyIntent> LISTA;

    private Context con;


    public AdaptadorIntents(List<MyIntent> LISTA) {
        this.LISTA = LISTA;
    }
    public AdaptadorIntents(List<MyIntent> LISTA, Context c) {
        this.LISTA = LISTA;
        this.con=c;

    }

    @NonNull
    @Override
    public AdaptadorIntents.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  v= LayoutInflater.from(con).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorIntents.ViewHolder holder, int position) {
        holder.llenar(LISTA.get(position));
    }

    @Override
    public int getItemCount() {
        return  this.LISTA.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView  Texto;
        ImageView txt;
        Intent I;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Texto=itemView.findViewById(R.id.txt1);


            itemView.setOnClickListener(this);
        }

        public void llenar(MyIntent myIntent) {
            Texto.setText(myIntent.getNombre());



            I=myIntent.getMyIntent();

        }

        @Override
        public void onClick(View view) {

            view.getContext().startActivity(I);

        }



    }
}
