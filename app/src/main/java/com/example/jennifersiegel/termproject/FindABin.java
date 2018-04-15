package com.example.jennifersiegel.termproject;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

// Google Maps imports
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class FindABin extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng CENTER_POINT = new LatLng(42.3870139,-71.2217289);
    private static final LatLng BIN_1 = new LatLng(42.386029,-71.2232306); // Student Center
    private static final LatLng BIN_2 = new LatLng(42.387241,-71.2197609);  // Adamian Academic Center
    private static final LatLng BIN_3 = new LatLng(42.3878667,-71.2199288); // Morison Hall
    private static final LatLng BIN_4 = new LatLng(42.3870139,-71.2217289); // User Experience Center
    private static final float zoom = 15.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_a_bin);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTER_POINT, zoom));

        // set markers for 4 NYC colleges
        mMap.addMarker(new MarkerOptions()
                .position(BIN_1)
                .title("Student Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_2)
                .title("Adamian Academic Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_3)
                .title("Morison Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_4)
                .title("User Experience Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));

        mMap.setOnMarkerClickListener(
                new GoogleMap.OnMarkerClickListener() {
                    public boolean onMarkerClick(Marker m) {
                        String title = m.getTitle();
                        Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );

        mMap.setOnMapLongClickListener(
                new GoogleMap.OnMapLongClickListener() {
                    public void onMapLongClick(LatLng point) {

                    }
                }
        );

    }

    // create back options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.backmenu, menu);
        return true;
    }

    // add functionality to menu buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.homeMenu:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
