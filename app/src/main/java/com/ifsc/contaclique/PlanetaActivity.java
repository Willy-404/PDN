package com.ifsc.contaclique;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PlanetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_planeta);

        Bundle bundle = getIntent().getExtras();
        //obtendo objeto serializado
        Planeta p = (Planeta) bundle.getSerializable("planeta");

        ImageView imageView = findViewById(R.id.imageViewPlaneta);
        TextView textView = findViewById(R.id.tvPlaneta);

        imageView.setImageResource(p.imagem);
        textView.setText(p.nome);
    }
}