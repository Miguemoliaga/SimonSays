package com.mmartine.simonsays;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameActivity extends AppCompatActivity {
    private ArrayList<Integer> simon = new ArrayList<Integer>();
    private ArrayList<Integer> user = new ArrayList<Integer>();
    private ImageButton ib_enun;
    private ImageButton ib_red;
    private ImageButton ib_yellow;
    private ImageButton ib_green;
    private ImageButton ib_blue;
    private static int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ib_enun = findViewById(R.id.ib_enun);
        ib_red = findViewById(R.id.ib_red);
        ib_yellow = findViewById(R.id.ib_yellow);
        ib_green = findViewById(R.id.ib_green);
        ib_blue = findViewById(R.id.ib_blue);

        ib_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.add(0);
                checkSizes(simon, user, getApplicationContext());

            }
        });

        ib_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.add(1);
                checkSizes(simon, user, getApplicationContext());

            }
        });

        ib_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.add(2);
                checkSizes(simon, user, getApplicationContext());

            }
        });

        ib_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.add(3);
                checkSizes(simon, user, getApplicationContext());
            }
        });

        fillArray(simon, 3);
        printArray(simon, getApplicationContext());

    }

    private static void checkSizes(ArrayList simon, ArrayList user, Context context){
        if(simon.size() == user.size())
            checkAnswer(simon, user, context);
    }


    private static void checkAnswer(ArrayList simon, ArrayList user, Context context){
        boolean fin = false;
        for (int i = 0; i < simon.size(); i++) {
            if(simon.get(i) != user.get(i)){
                fin = true;
                break;
            }
        }
        if (!fin){
            points += simon.size() * 100;
            Toast ifx = Toast.makeText(context, " Tu puntuacion es de: "+ String.valueOf(points) , Toast.LENGTH_LONG);
            ifx.show();
            user.clear();
            fillArray(simon, 1);
            printArray(simon, context);
            //idk.setText(points);
        }
        else{
            Intent intent = new Intent(context, EndActivity.class);
            intent.putExtra("points", points);
        }
    }

    private static void printArray(ArrayList<Integer> simon, Context context){
        Handler handler = new Handler();

                for (int i = 0; i < simon.size(); i++) {
                    Integer n = simon.get(i);
                    Toast ifx = Toast.makeText(context, String.valueOf(n) + " en la posicion: "+ String.valueOf(i) , Toast.LENGTH_LONG);
                    ifx.show();
//                    if (n == 0)
//                        ((ImageButton) view).setImageResource(R.drawable.red);
//
//                    else if (n == 1)
//                        ((ImageButton) view).setImageResource(R.drawable.yellow);
//                    else if (n == 2)
//                        ((ImageButton) view).setImageResource(R.drawable.green);
//                    else if (n == 3)
//                        ((ImageButton) view).setImageResource(R.drawable.blue);
//                    ((ImageButton) view).setImageResource(R.drawable.black);
                }
    }


    private static void fillArray(ArrayList<Integer> lista, int c){
        for (int i = 0; i < c; i++)
        {
            int n = (int)(Math.random() * 4);
            lista.add(n);
        }
    }
}