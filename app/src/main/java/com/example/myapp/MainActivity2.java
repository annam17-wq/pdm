package com.example.myapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements SensorEventListener {

    TextView tvSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        tvSensor=findViewById(R.id.tvSensor);
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor sensor=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,sensor, SensorManager.SENSOR_DELAY_FASTEST);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float v=event.values[0];
        tvSensor.setText(Float.toString(v));
    }
}