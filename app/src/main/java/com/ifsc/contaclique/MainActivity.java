package com.ifsc.contaclique;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    TextView tvLatitude, tvLongitude, tvStatus;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLatitude=findViewById(R.id.tvLatitude);
        tvLongitude=findViewById(R.id.tvLongitude);
        tvStatus=findViewById(R.id.tvStatus);

        button = findViewById(R.id.button);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        button.setOnClickListener(view -> {
            getLocalizacao();
        });

        public void getLocalizacao(){
            if (checaSolicitaPermicao()){
                Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                tvLatitude.setText(Double.toString(l.getLatitude()));
                tvLongitude.setText(Double.toString(l.getLongitude()));
            }else{
                tvLatitude.setText("Permissão Negada");
            }
        }

        public boolean checaSolicitaPermicao(){
            //verifica se tem e caso não, pede permissão
            if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
            ||
            ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
            )
            {//codego
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION
                                },
                    PackageManager.PERMISSION_GRANTED
                    );
            return false;
            }else{
            return true;
            }
        }
    }
}