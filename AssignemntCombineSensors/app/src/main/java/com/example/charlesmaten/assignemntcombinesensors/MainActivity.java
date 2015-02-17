package com.example.charlesmaten.assignemntcombinesensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



    //Laver SensorListeneren
public class MainActivity extends ActionBarActivity implements SensorEventListener {

    private Vibrator vibo;
    Sensor accelerometer;
    SensorManager sm;
    TextView acceleration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickVibrate(View v){

        vibo = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibo.vibrate(500);

        //tilføjer Sensormangeren
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        //tilføjer accelerometer sensoren
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Registarer listener
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        acceleration = (TextView) findViewById(R.id.accelerationLayout);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        acceleration.setText("X: " + event.values[0] +
            "\nAway from you: " + event.values[1] +
            "\nZ " +event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
