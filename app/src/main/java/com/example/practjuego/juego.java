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
    Button b1,b2,b3;
    TextView t,ta;
    SeekBar seekBar;
    int n=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        g=findViewById(R.id.GridLayout);


        crear();

    }
    public void crear() {

       n= Integer.parseInt(getIntent().getStringExtra("numero"));


        for (int i = 1; i <= n; i++) {
            restar();
            texto();
            sumar();

            //texto para indicar el número de jugador
            ta=new TextView(this);
            ta.setText("Jug"+i);
            g.addView(ta);

            //comprobamos si ya hemos introducido a todos los jugadores y creamos el seekbar y el boton reset
            if(i==n){

               //seekbar
                seekBar=new SeekBar(this);
                seekBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));

                seekBar.setMax(100);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        ((Button)b1).setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                        ((Button)b2).setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                         t.setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                         ta.setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                         //textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,seekBar.getProgress());

                    }
                });
                g.addView(seekBar);
                //fin seekbar

               //boton de reset
                b3=new Button(this);

                b3.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                b3.setText("RESET");
                b3.setId(View.generateViewId());
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    g.removeAllViews();
                        crear();



                    }
                });
                g.addView(b3);
                //fin de reset
            }

        }
    }
    public void sumar(){

        b2=new Button(this);
        b2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        b2.setText("+");
        b2.setBackgroundResource(R.drawable.boton_redondo);
        b2.setId(View.generateViewId());

        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
              
                t.setText(String.valueOf(Integer.parseInt(t.getText()+"")+1));

            }
        });

        g.addView(b2);
    }
    public void restar()
    {
        b1=new Button(this);
        b1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        b1.setText("-");
        b1.setBackgroundResource(R.drawable.boton_redondo);
        b1.setId(View.generateViewId());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(t.getText()+"")>0)
                {
                    ((TextView)t).setText(String.valueOf(Integer.parseInt(t.getText() + "") - 1));
                }
            }
        });
        g.addView(b1);
    }
    public void texto(){
        t=new TextView(this);
        t.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        t.setText("0");
        t.setTextSize(20);

        t.setId(View.generateViewId());
        t.setGravity(Gravity.CENTER_VERTICAL);
        g.addView(t);
    }


}
