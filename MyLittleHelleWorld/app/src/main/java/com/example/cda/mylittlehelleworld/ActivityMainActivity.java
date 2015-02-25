package com.example.cda.mylittlehelleworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityMainActivity extends ActionBarActivity {

    private EditText EnterText;
    private TextView textViewOUT;

    public final static String KEY = "com.example.cda.mylittlehelloworld.MESSAGE";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);

  }

    public void sendMessage (View v){

        //Intent provides runtime binding between separate components, f.eks. two activities
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //Finds the user input and assigens it to the variable EnterText
        EnterText = (EditText) findViewById(R.id.inputTextField);
        //The variable message holds the user data from EnterText and converts it to a string
        String message = EnterText.getText().toString();
        //a intent can carry daa as key-value pairs, the putExtra method takes the key in the first parameter and the value in the second
        intent.putExtra(KEY, message);
        //Start the intent
        startActivity(intent);

        /*
        EnterText = (EditText) findViewById(R.id.inputTextField);
        textViewOUT = (TextView) findViewById(R.id.outPutTextField);

        textViewOUT.setText(EnterText.getText());

        //Button button = (Button) v;
        ((Button) v).setText("Lort");
        */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //from the actionbar.xml file i made
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       switch (item.getItemId()) {
           case R.id.action_search:
               openSearch();
               return true;
           case R.id.action_settings:
               openSettings();
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }






        /*
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
        */
    }

    private void openSettings() {
        Toast.makeText(this, "Settings button pressed", Toast.LENGTH_SHORT).show();
    }

    private void openSearch() {
        Toast.makeText(this, "Search button pressed", Toast.LENGTH_SHORT).show();
    }
}
