package com.example.practjuego;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class juego extends AppCompatActivity {
    GridLayout g;
    Button b3;
    SeekBar seekBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        g = findViewById(R.id.GridLayout);
        seekBar = findViewById(R.id.seekBar);
        int n;
        n = Integer.parseInt(getIntent().getStringExtra("numero"));
         final Button b1[] = new Button[n];
         final Button b2[] = new Button[n];
         final TextView t[]= new TextView[n];
         final  TextView ta[]=new TextView[n];

        for (int i = 0; i < n; i++) {

            //crear botón menos
            b1[i] = new Button(this);
            b1[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            b1[i].setText("-");
            b1[i].setBackgroundResource(R.drawable.boton_redondo);
            b1[i].setId(View.generateViewId());
            g.addView(b1[i]);

            //crear textview
            t[i] = new TextView(this);
            t[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            t[i].setText("0");
            t[i].setTextSize(30);
            t[i].setId(View.generateViewId());
            t[i].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            g.addView(t[i]);


            //crear boton más
            b2[i] = new Button(this);
            b2[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            b2[i].setText("+");
            b2[i].setBackgroundResource(R.drawable.boton_redondo);
            b2[i].setId(View.generateViewId());
            g.addView(b2[i]);


            //texto para indicar el número de jugador
            ta[i] = new TextView(this);
            ta[i].setText("Jug" + (i+1));
            ta[i].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            g.addView(ta[i]);

            //click boton menos
           final int finalI = i;
            b1[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //compruebe que el textview no sea menor a 0
                    if (Integer.parseInt(t[finalI].getText() + "") > 0) {

                        t[finalI].setText(String.valueOf(Integer.parseInt(t[finalI].getText().toString()) - 1));
                    }
                }
            });

            //click boton más
            final int finalI1 = i;
            b2[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    t[finalI1].setText(String.valueOf(Integer.parseInt(t[finalI1].getText().toString()) + 1));

                }
            });
            //comprobamos si ya hemos introducido a todos los jugadores y creamos el boton reset
            if ((i+1) == n) {

                //boton de reset
                b3 = new Button(this);

                b3.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                b3.setText("RESET");
                b3.setId(View.generateViewId());

                final int finalN = n;
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int a = 0; a < finalN; a++)
                        {
                            t[a].setText("0");
                        }


                    }
                });
                g.addView(b3);
                //fin de reset

                //recorro todos los elementos para agrandarlos o disminuirlos
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        for (int a = 0; a < finalN; a++)
                        {
                            b1[a].setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                            b2[a].setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                            t[a].setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                            ta[a].setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                        }

                        b3.setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        //textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,seekBar.getProgress());

                    }
                });


            }


        }


    }

}
