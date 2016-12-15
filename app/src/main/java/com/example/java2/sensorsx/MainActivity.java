package com.example.java2.sensorsx;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "SENSOR";
    private Sensor sensorAccelerometer;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        checkSensors();
    }

    private void init() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Sensor sensorProxymity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorManager.registerListener(this,sensorProxymity,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.v(TAG, "accuracy: " + event.accuracy + "sensor: " + event.sensor + " values: " + event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.v(TAG, accuracy + " " + sensor.getName());
    }
    private void checkSensors(){
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s:sensorList
             ) {Log.v(TAG,String.format("Name:%s, Ventor:%s,Type%d",s.getName(),s.getVendor(),s.getType()));

        }
    }
}
