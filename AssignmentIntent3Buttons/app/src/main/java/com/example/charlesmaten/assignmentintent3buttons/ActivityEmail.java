package com.example.charlesmaten.assignmentintent3buttons;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.protocol.HTTP;

import java.net.URLEncoder;


public class ActivityEmail extends ActionBarActivity {


    private Button buttonOnPressDone;
    private EditText UserEmail;
    private EditText UserMessage;
    private EditText UserSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        initUI();
    }

    private void initUI(){
        buttonOnPressDone = (Button) findViewById(R.id.buttonDone);
        UserEmail = (EditText) findViewById(R.id.editTextEmail);
        UserMessage = (EditText) findViewById(R.id.editTextMessage);
        UserSubject = (EditText) findViewById(R.id.editTextSubject);

        buttonOnPressDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String message = UserMessage.getText().toString();
                //String emailTo = UserEmail.getText().toString();
                sendEmail(message);


            }
        });
    }

    private void sendEmail(String message) {
        String emailTo = UserEmail.getText().toString();
        String theSubject = UserSubject.getText().toString();

        String[] to = new String[]{emailTo};
        //String subject = ("A message from your app!");

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, theSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        //emailIntent.setType("text/plain");
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_email, menu);
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
