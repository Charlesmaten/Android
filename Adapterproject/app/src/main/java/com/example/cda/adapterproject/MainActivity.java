package com.example.cda.adapterproject;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity implements View.OnClickListener {

    List<String> itemlist;
    ArrayAdapter<String> adap;
    Button buttonTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize:
        itemlist = new ArrayList<String>();
        buttonTime = (Button)findViewById(R.id.buttonTime);
        buttonTime.setOnClickListener(this);
        adap = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, itemlist);
        setListAdapter(adap);
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

    @Override
    public void onClick(View v) {
        //Add an item to the entity:itemlist
        itemlist.add("Second: " + System.currentTimeMillis()/1000);
        adap.notifyDataSetChanged();
    }
}
