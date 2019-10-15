package com.example.practjuego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.practjuego.MainActivity.NOMBRE;

public class juego extends AppCompatActivity {
    GridLayout g;
    Button b;
    TextView t;
    SeekBar seekBar;
    int n=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        g=findViewById(R.id.GridLayout);


        crear();
        seekBar=new SeekBar(this);
        seekBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
       // seekBar.setOnSeekBarChangeListener();
        seekBar.setId(View.generateViewId());
        g.addView(seekBar);
    }
    public void crear() {
     //  n=Integer.parseInt(String.valueOf(getIntent().getExtras()));

        n = 2;
        for (int i = 0; i < n; i++) {
            sumar();
            texto();
            restar();
            if(i==n){
                b=new Button(this);
                b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                b.setText("RESET");
                b.setId(View.generateViewId());
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    //boton reset para poner a cero los text



                    }
                });
                g.addView(b);
            }

        }
    }
    public void sumar(){

        b=new Button(this);
        b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        b.setText("+");
        b.setId(View.generateViewId());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ((Button)v).setVisibility(View.GONE);
                //suma a su text correspondiente 1
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
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode==VUELVO_DE_MULT && resultCode==RESULT_OK){
            String nombre = data.getStringExtra(NOMBRE);
            int res= Integer.parseInt(nombre)*2;

            textViewResultado.setText( String.valueOf(res));
        }
        if ( requestCode==VUELVO_DE_DIV && resultCode==RESULT_OK){
            String nombre = data.getStringExtra(NOMBRE);
            int res= Integer.parseInt(nombre)/2;
            textViewResultado.setText(String.valueOf(res));
        }


    }*/

}
