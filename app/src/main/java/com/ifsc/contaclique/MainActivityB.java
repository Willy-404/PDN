package com.ifsc.contaclique;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_b);

            Bundle bundle = getIntent().getExtras();
            String msg = bundle.getString("Mensagem");
            TextView txtView = findViewById(R.id.textView);
            txtView.setText(msg);
        };
    }