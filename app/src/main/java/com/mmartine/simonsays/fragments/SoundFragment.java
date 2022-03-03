package com.mmartine.simonsays.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

import com.mmartine.simonsays.MusicService;
import com.mmartine.simonsays.R;


public class SoundFragment extends Fragment {

    Button b_ton;
    Button b_toff;
    Button b_link;

    public SoundFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.sound_fragment, container, false);

        b_ton = (Button) myView.findViewById(R.id.b_ton);
        b_toff = (Button) myView.findViewById(R.id.b_toff);
        b_link = (Button) myView.findViewById(R.id.b_link);

        b_ton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getActivity(),MusicService.class));
            }
        });

        b_toff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getActivity(),MusicService.class));
            }
        });

        return myView;

    }

}