package com.ifsc.contaclick;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ifsc.contaclick.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int posicao = 0;
    EditText edpeso, edaltura;
    TextView tvresultadoimc;
    Button Button, ButtonNextImage;

    ImageView imageView;
    Integer imagens[] = new Integer[]{
            R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.happy,
            R.drawable.patinho
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ciclo de vida", "metodo onCreate");
        setContentView(R.layout.activity_main);
        edpeso = findViewById(R.id.edpeso);
        edaltura = findViewById(R.id.edaltura);
        tvresultadoimc = findViewById(R.id.tvresultadoimc);
        Button = findViewById(R.id.button);
        ButtonNextImage = findViewById(R.id.button2);
        imageView = findViewById(R.id.imageView);

        Button.setOnClickListener(v -> {
        });
        ButtonNextImage.setOnClickListener(v -> {
            imageView.setImageResource(imagens[posicao]);
            if(posicao < imagens.length-1) {
                posicao++;
            }else {
                posicao=0;
            }

        });

    }
}