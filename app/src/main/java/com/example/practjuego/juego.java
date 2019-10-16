package com.example.practjuego;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class juego extends AppCompatActivity {
    GridLayout g;
    Button b;
    TextView t,ta;
    SeekBar seekBar;
    int n=0;
    //int[] num=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        g=findViewById(R.id.GridLayout);


        crear();

    }
    public void crear() {

       n= Integer.parseInt(getIntent().getStringExtra("numero"));

        for (int i = 1; i <= n; i++) {
           // restar();
           // texto();
          // sumar();

            //resta
            b=new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setText("-");
            b.setId(View.generateViewId());
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //((Button)v).setVisibility(View.GONE);
                    //resta a su text correspondiente 1
                    if(Integer.parseInt(t.getText()+"")>0)
                    {
                        ((TextView)t).setText(String.valueOf(Integer.parseInt(t.getText() + "") - 1));
                    }
                }
            });
            g.addView(b);
            //fin de resta

            //texto
            t=new TextView(this);
            t.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            t.setText("0");

            t.setId(View.generateViewId());

            g.addView(t);
            //fin de texto

            //suma
            b=new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setText("+");
            b.setId(View.generateViewId());
            b.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View v) {
                    t.setText(String.valueOf(Integer.parseInt(t.getText()+"")+1));

                }
            });

            g.addView(b);
            //fin de suma
            //texto para indicar el número de jugador
            ta=new TextView(this);
            ta.setText("Jug"+i);
            g.addView(ta);
            //comprobamos si ya hemos introducido a todos los jugadores y creamos el seekbar y el boton reset
            if(i==n){
               /* seekBar=new SeekBar(this);
                seekBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                // seekBar.setOnSeekBarChangeListener();
                seekBar.setId(View.generateViewId());
                g.addView(seekBar);*/

               //seekbar
                seekBar=new SeekBar(this);
                seekBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //textView.setText(String.valueOf(progress));
                        //textView.setTextSize(progress);

                       //textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,seekBar.getProgress());

                    }
                });
                //fin seekbar
               //boton de reset
                b=new Button(this);
                b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                b.setText("RESET");
                b.setId(View.generateViewId());
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    g.removeAllViews();
                        crear();



                    }
                });
                g.addView(b);
                //fin de reset
            }

        }
    }
    public void sumar(){

        b=new Button(this);
        b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        b.setText("+");
        b.setId(View.generateViewId());
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
               // ((Button)v).setVisibility(View.GONE);
                //suma a su text correspondiente 1
               // t.getId();
                /*t=findViewById(i);
                t.setText((Integer.parseInt((String) t.getText()))+1)+"");*/

            }
        });

        g.addView(b);
    }
    public void restar()
    {
        b=new Button(this);
        b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        b.setText("-");
        b.setId(View.generateViewId());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((Button)v).setVisibility(View.GONE);
                //resta a su text correspondiente 1
            }
        });
        g.addView(b);
    }
    public void texto(){
        t=new TextView(this);
        t.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        t.setText("0");

        t.setId(View.generateViewId());

        g.addView(t);
    }


}
