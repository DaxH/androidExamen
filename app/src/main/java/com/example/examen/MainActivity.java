package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButtonSend;
    private EditText mEditTextDate;
    private String obtenerTexto;
    private final String color = "COLORES";
    private final String letra = "LETRAS";
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }

    private void setViews() {

        // Button
        mButtonSend = (Button) findViewById(R.id.button);

        // EditText
        mEditTextDate = (EditText) findViewById(R.id.editText);
        spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_data, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void Snipper_Validar(View v){

        if (spinner.getSelectedItem().toString().equals("Colores")){
            obtenerTexto = mEditTextDate.getText().toString();

            if (obtenerTexto.isEmpty()){
                mEditTextDate.setError("El campo no puede quedar vacio");
            }else {
                Intent cambiar = new Intent(this, Resultado.class);
                cambiar.putExtra(color,obtenerTexto);
                startActivity(cambiar);
            }

        }else {

            obtenerTexto = mEditTextDate.getText().toString();

            if (obtenerTexto.isEmpty()){

                mEditTextDate.setError("El campo no puede quedar vacio");

            }else {
                Intent cambiar = new Intent(this, Resultado.class);
                cambiar.putExtra(letra,obtenerTexto);
                startActivity(cambiar);
            }
        }
    }
}
