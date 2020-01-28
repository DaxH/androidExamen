package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class Resultado extends AppCompatActivity {

    private Button btnRegresar;
    private TextView txtResultado;
    private String obtenerTexto;
    private final String color = "COLORES";
    private final String letra = "LETRAS";
    private String arrrayColores[]= {"amarillo","negro","celeste","azul"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btnRegresar = findViewById(R.id.btnRegresar);
        MainActivity m = new MainActivity();
        if (m.getSpinner().getSelectedItem().toString().equals("Colores")){
            Validar_Opciones();
        }else {
            Cantidad_Letras();

        }

    }

    public void Validar_Opciones(){

        txtResultado = findViewById(R.id.txtResultado);

        obtenerTexto = getIntent().getStringExtra("COLORES");

        Random random = new Random();
        int color = random.nextInt(3);

        for (int i=0; i < 4; i++){
              if (obtenerTexto.equals(arrrayColores[color])){
                 txtResultado.setText("GANASTE");
                  txtResultado.setTextColor(Color.GREEN);

              }else {
                   txtResultado.setText("PERDISTE");
                   txtResultado.setTextColor(Color.RED);
                }
            }
        }

    public void Cantidad_Letras(){
        txtResultado = findViewById(R.id.txtResultado);

        obtenerTexto = getIntent().getStringExtra("LETRAS");
        char charArray [] = obtenerTexto.toCharArray();

        for (int i = 0; i <= obtenerTexto.length(); i++){
            txtResultado.setText(obtenerTexto + " cantidad letras " + i);
        }
    }

    public void Regresar(View vista){

        Intent cambiar = new Intent(this, MainActivity.class);
        startActivity(cambiar);
    }
}
