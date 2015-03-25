package com.example.cda.threadsplashscreen;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {



    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Thread that wait stall 3 seconds before continue to second
        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(3000);    //Actual sleeping!!

                } catch (InterruptedException e) {  }
                finally {
                    Intent i = new Intent(getThis(), SecondActivity.class);
                    startActivity(i);
                }
            }
        };

        thread.start();


        //switch to second screen
        //Intent i = new Intent(this, SecondActivity.class);
        //startActivity(i);
    }

    public MainActivity getThis(){
        return this;
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
