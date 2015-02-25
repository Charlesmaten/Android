package com.example.cda.mylittlehelleworld;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_message);

        //Gets the message from the intent and assign it to a local variable
        Intent intent = getIntent();
        String message = intent.getStringExtra(ActivityMainActivity.KEY);



            //Create the text view
            TextView textView = new TextView(this);
            textView.setTextSize(40);

            textView.setTextColor(Color.RED);
            textView.setText(message);

            //Sets the background in the textView
            textView.setBackgroundResource(R.drawable.androidvsapplefight);

            //Set the text view as the activity layout
            setContentView(textView);

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //from the actionbar.xml file i made
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }
}
