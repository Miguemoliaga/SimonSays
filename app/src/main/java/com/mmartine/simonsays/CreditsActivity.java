package com.mmartine.simonsays;

import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreditsActivity extends AppCompatActivity {

    private static final float MILLISECONDS_PER_INCH = 1000f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        ArrayList<String> elementosSuperiores = new ArrayList<>();
        inicializaElementosListado(elementosSuperiores);
        Adapter adaptadorSuperior = getAdaptador (R.id.rvSuperior, elementosSuperiores);
    }

    public void inicializaElementosListado(ArrayList<String> elementosSuperiores) {
        elementosSuperiores.add(" Amparo");
        elementosSuperiores.add(" Manuel");
        elementosSuperiores.add(" Rosa");
        elementosSuperiores.add(" Davinia");
        elementosSuperiores.add(" Ángel");
        elementosSuperiores.add(" Óscar");
        elementosSuperiores.add(" Nerea");
        elementosSuperiores.add(" Silvia");
        elementosSuperiores.add(" Estrella");
        elementosSuperiores.add(" José");
        elementosSuperiores.add(" Francisco");
        elementosSuperiores.add(" Daniela");
        elementosSuperiores.add(" Triana");
        elementosSuperiores.add(" Amparo");
        elementosSuperiores.add(" Manuel");
        elementosSuperiores.add(" Rosa");
        elementosSuperiores.add(" Davinia");
        elementosSuperiores.add(" Ángel");
        elementosSuperiores.add(" Óscar");
        elementosSuperiores.add(" Nerea");
        elementosSuperiores.add(" Silvia");
        elementosSuperiores.add(" Estrella");
        elementosSuperiores.add(" José");
        elementosSuperiores.add(" Francisco");
        elementosSuperiores.add(" Daniela");
        elementosSuperiores.add(" Triana");
        elementosSuperiores.add(" Amparo");
        elementosSuperiores.add(" Manuel");
        elementosSuperiores.add(" Rosa");
        elementosSuperiores.add(" Davinia");
        elementosSuperiores.add(" Ángel");
        elementosSuperiores.add(" Óscar");
        elementosSuperiores.add(" Nerea");
        elementosSuperiores.add(" Silvia");
        elementosSuperiores.add(" Estrella");
        elementosSuperiores.add(" José");
        elementosSuperiores.add(" Francisco");
        elementosSuperiores.add(" Daniela");
        elementosSuperiores.add(" Triana");
    }

    public Adapter getAdaptador (int idRecyclerView, ArrayList<String> lista){
        RecyclerView rv = findViewById(idRecyclerView);
        LinearLayoutManager managerLayout = new LinearLayoutManager(this);
        rv.setLayoutManager(managerLayout);
        Adapter adaptador = new Adapter(this, lista);
        rv.setAdapter(adaptador);
        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(this) {
            @Override protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
            }
        };
        smoothScroller.setTargetPosition(lista.size() - 1);
        managerLayout.startSmoothScroll(smoothScroller);
        return adaptador;
    }
}