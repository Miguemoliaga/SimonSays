package com.mmartine.simonsays.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.mmartine.simonsays.CreditsActivity;
import com.mmartine.simonsays.R;

public class MainMenuFragment extends Fragment {


    Button enter;
    Button credits;
    Button sound;
    public MainMenuFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.menu_fragment, container, false);
        enter = (Button) myView.findViewById(R.id.b_play);
        credits = (Button) myView.findViewById(R.id.b_credits);
        sound = (Button) myView.findViewById(R.id.b_fsound);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreditsActivity.class);
                startActivity(intent);
            }
        });


        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreditsActivity.class);
                startActivity(intent);
            }
        });



        sound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast1 = Toast.makeText(getContext(), "Try to swipe left", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });
        return myView;
    }


}