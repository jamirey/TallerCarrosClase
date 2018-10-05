package com.holamundo.tallercarrosclase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCarro extends
        RecyclerView.Adapter<AdaptadorCarro.CarrosViewHolder> {

    private ArrayList<Carros> Carross;
    private Context context;

    public AdaptadorCarro(ArrayList<Carros> Carross){
        this.Carross=Carross;
    }
    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carros,parent,false);
        return new CarrosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarrosViewHolder holder, int position) {
        Carros p = Carross.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.placa.setText(p.getPlaca());
        holder.color.setText(p.getColor());
        holder.precio.setText(p.getPrecio());
        holder.marca.setText(p.getMarca());
    }

    @Override
    public int getItemCount() {
        return Carross.size();
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView color;
        private TextView precio;
        private TextView marca;
        private View v;

        public CarrosViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            placa = v.findViewById(R.id.lblPlaca);
            color = v.findViewById(R.id.lblColor);
            precio = v.findViewById(R.id.lblPrecio);
            marca = v.findViewById(R.id.lblMarca);
        }
    }
}
    
    
    

