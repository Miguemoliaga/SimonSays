package com.mmartine.simonsays;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        ArrayList<String> elementosSuperiores = new ArrayList<>();
        ArrayList<String> elementosInferiores = new ArrayList<>();

        inicializaElementosListado(elementosInferiores, elementosSuperiores);

        Adapter adaptadorSuperior = getAdaptador (R.id.rvSuperior, elementosSuperiores);

        // comportamiento del botón de bajar elementos

    }

    public void inicializaElementosListado(ArrayList<String> elementosInferiores, ArrayList<String> elementosSuperiores) {
        int i = 0;
        elementosSuperiores.add(i++ + " Amparo");
        elementosSuperiores.add(i++ + " Manuel");
        elementosSuperiores.add(i++ + " Rosa");
        elementosSuperiores.add(i++ + " Davinia");
        elementosSuperiores.add(i++ + " Ángel");
        elementosSuperiores.add(i++ + " Óscar");
        elementosSuperiores.add(i++ + " Nerea");
        elementosSuperiores.add(i++ + " Silvia");
        elementosSuperiores.add(i++ + " Estrella");
        elementosSuperiores.add(i++ + " José");
        elementosSuperiores.add(i++ + " Francisco");
        elementosSuperiores.add(i++ + " Daniela");
        elementosSuperiores.add(i++ + " Triana");
    }

    public Adapter getAdaptador (int idRecyclerView, ArrayList<String> lista){
        RecyclerView rv = findViewById(idRecyclerView);
        LinearLayoutManager managerLayout = new LinearLayoutManager(this);
        rv.setLayoutManager(managerLayout);
        Adapter adaptador = new Adapter(this, lista);
        rv.setAdapter(adaptador);

        DividerItemDecoration decorador = new DividerItemDecoration(
                rv.getContext(), managerLayout.getOrientation());
        rv.addItemDecoration(decorador);
        return adaptador;
    }
}