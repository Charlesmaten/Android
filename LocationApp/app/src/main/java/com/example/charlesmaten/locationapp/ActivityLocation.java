package com.example.charlesmaten.locationapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.util.ArrayList;


public class ActivityLocation extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        initUI();
    }

    public void initUI() {


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        map.setMyLocationEnabled(true);
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (marker != null) {
                    marker.remove();
                }
                marker = map.addMarker(new MarkerOptions()
                        .position(
                                new LatLng(latLng.latitude,
                                        latLng.longitude)).title("Your chosen position").snippet("Sent this marker, or move it")
                        .draggable(true).visible(true));
                marker.getPosition();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Switch-Case that handles the actionbar.
        //Calls the method corresponding to the action item chosen.
        switch (item.getItemId()){
            case R.id.action_hybrid:
                mapTypeHybrid();
                return true;
            case R.id.action_normal:
                mapTypeNormal();
                return true;
            case R.id.action_terrain:
                mapTypeTerrain();
                return true;
            case R.id.action_sendSms:
                try {
                    sendSms();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            case R.id.action_sendMail:
                try {
                    sendMail();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            default:
        return super.onOptionsItemSelected(item);
    }

}

    private void sendMail() throws Exception {
        //The API key we use here is different then the Google maps API key.
        //This key is a browser key, and not an Android one. We are requesting a json response for the given location in latitude and longitude, via a http request
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAtOFnXPhDsyD_Tv3jlfONUm0HvUfuzEqA");
        //We are declaring an array results, and putting the information from the maker into a new LatlNg.
        GeocodingResult[] results = GeocodingApi.reverseGeocode(context, new com.google.maps.model.LatLng(marker.getPosition().latitude,marker.getPosition().longitude)).await();

        Intent emailIntent = new Intent(Intent.ACTION_VIEW);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_TEXT, results[0].formattedAddress);
        startActivity(emailIntent);
    }

    private void sendSms() throws Exception {
        //The API key we use here is different then the Google maps API key.
        //This key is a browser key, and not an Android one. We are requesting a json response for the given location in latitude and longitude, via a http request
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAtOFnXPhDsyD_Tv3jlfONUm0HvUfuzEqA");
        //We are declaring an array results, and putting the information from the maker into a new LatlNg.
        GeocodingResult[] results = GeocodingApi.reverseGeocode(context, new com.google.maps.model.LatLng(marker.getPosition().latitude,marker.getPosition().longitude)).await();


        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"));
        //With our Intent we are putting the index 0 of the result array as the sms body(Text in the sms we are sending)
        sendIntent.putExtra("sms_body",results[0].formattedAddress);
        startActivity(sendIntent);
    }

    private void mapTypeHybrid() {
        //Changes the map type to hybrid
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    private void mapTypeNormal(){
        //Changes the map type to normal
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void mapTypeTerrain(){
        //Changes the map type to terrain
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }


    //Callback interface for when the map is ready to be used
    @Override
    public void onMapReady(GoogleMap googleMap) {


    }
}
