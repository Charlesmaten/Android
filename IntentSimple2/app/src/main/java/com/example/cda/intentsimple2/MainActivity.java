package com.example.cda.intentsimple2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity   {

    private Button buttonNextScreen;
    private EditText EnterText;

    public final static String KEY = "com.example.cda.IntentSimple2.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

    }

    private void initUI(){
        buttonNextScreen = (Button) findViewById(R.id.buttonNextScreen);

        buttonNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Intent intent = new Intent(getApplicationContext(), Activity2.class);
                Intent intent = new Intent(getApplicationContext(), Activity2.class);

                EnterText = (EditText) findViewById(R.id.editTextUserInput);

                String message = EnterText.getText().toString();

                intent.putExtra(KEY, message);

                startActivity(intent);
            }
        });
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
