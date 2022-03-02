package com.mmartine.simonsays;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<String> lista;    // alimenta al RecyclerView
    private LinkedHashMap<TextView,Integer> candidatosTraspaso;
    private LayoutInflater inflador;

    Adapter(Context contexto, ArrayList<String> lista){
        this.lista = lista;
        this.candidatosTraspaso = new LinkedHashMap<>();
        this.inflador = LayoutInflater.from(contexto);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflador.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String elemento = lista.get(position);
        holder.tvElemento.setText(elemento);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public LinkedHashMap<TextView, Integer> getCandidatosTraspaso (){
        return this.candidatosTraspaso;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvElemento;
        ViewHolder (View item){
            super(item);
            tvElemento = item.findViewById(R.id.tvElemento);
        }
    }

}