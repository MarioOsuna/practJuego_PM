package com.example.practjuego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button button;
   // static String NOMBRE="NOMBRE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editTextNum);
        button=findViewById(R.id.buttonJugar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(MainActivity.this,juego.class);

             //   intent.putExtra("numero",editText.getText().toString());
                intent.putExtra("numero",editText.getText()+"");
                startActivity(intent);


            }
        });

    }
}
