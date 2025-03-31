package com.ifsc.contaclique;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int i=0;
    EditText edpeso,edaltura;
    TextView tvresultado;
    Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edpeso=findViewById(R.id.edpeso);
        edaltura=findViewById(R.id.edaltura);
        tvresultado=findViewById(R.id.tvresultadoimc);
        buttonCalcular=findViewById(R.id.button);
        //define um tratamento do botão
        buttonCalcular.setOnClickListener(v->{
            //calcular imc
            //recuperar os dados de peso e altura
            double peso,altura,imc;
            peso = Double.parseDouble(edpeso.getText().toString());
            altura = Double.parseDouble(edaltura.getText().toString());
            imc = peso/altura;
            //formatando resultado ##,##
            DecimalFormat dc = new DecimalFormat("##.##");

            tvresultado.setText(dc.format(imc));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo de Vida","metodo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo de Vida","metodo onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo de Vida","metodo onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo de Vida","metodo onPause");
    }
}