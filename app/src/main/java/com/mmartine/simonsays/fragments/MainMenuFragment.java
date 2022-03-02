package com.mmartine.simonsays.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import com.mmartine.simonsays.CreditsActivity;
import com.mmartine.simonsays.R;

public class MainMenuFragment extends Fragment {


    Button enter;
    Button credits;

    public MainMenuFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.menu_fragment, container, false);
        enter = (Button) myView.findViewById(R.id.b_juego);
        credits = (Button) myView.findViewById(R.id.b_creditos);


        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreditsActivity.class);
                startActivity(intent);
            }
        });

        return myView;

    }


}