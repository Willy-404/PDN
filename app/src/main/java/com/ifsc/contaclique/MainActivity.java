package com.ifsc.contaclique;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    int i=0;
    SensorManager mSensorManager;
    Sensor sensor;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //metodo para verificar sensores
        //mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        mSensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tv.setText(Float.toString(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}