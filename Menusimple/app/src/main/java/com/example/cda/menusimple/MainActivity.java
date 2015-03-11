package com.example.cda.menusimple;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private void sensSMS(){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("29904588", null, "I AM ALIVE", null, null);
            Toast.makeText(getApplicationContext(), "SMS sent!", Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Sms failed", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.topmenu_sms :
                //do something here
                Toast.makeText(getApplicationContext(), "SMS", Toast.LENGTH_SHORT).show();
                break;  //return true
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
