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


public class ActivityEmail extends ActionBarActivity {


    private Button buttonOnPressDone;
    private EditText UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        initUI();
    }

    private void initUI(){
        buttonOnPressDone = (Button) findViewById(R.id.buttonDone);
        UserEmail = (EditText) findViewById(R.id.editTextEmail);

        buttonOnPressDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String message = UserEmail.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(emailIntent.EXTRA_EMAIL, message);

                startActivity(emailIntent);



               // emailIntent.setType("*/*");
                //emailIntent.putExtra(Intent.EXTRA_EMAIL,  UserEmail);

            }
        });
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
