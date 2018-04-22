package com.example.jennifersiegel.termproject;

import android.support.v4.app.FragmentActivity;
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

public class FindABin extends FragmentActivity implements OnMapReadyCallback{

    // initialize google map, latitude and longitude coordinates of bins, and zoom
    private GoogleMap mMap;
    private static final LatLng CENTER_POINT = new LatLng(42.3870139,-71.2217289);
    private static final LatLng BIN_1 = new LatLng(42.386029,-71.2232306); // Student Center
    private static final LatLng BIN_2 = new LatLng(42.387241,-71.2197609);  // Adamian Academic Center
    private static final LatLng BIN_3 = new LatLng(42.3878667,-71.2199288); // Morison Hall
    private static final LatLng BIN_4 = new LatLng(42.3870139,-71.2217289); // User Experience Center
    private static final LatLng BIN_5 = new LatLng(42.386406,-71.222070);   // Boylston B
    private static final LatLng BIN_6 = new LatLng(42.386348,-71.222384);  // Rhodes
    private static final LatLng BIN_7 = new LatLng(42.387177,-71.221449); // Green Space
    private static final LatLng BIN_8 = new LatLng(42.386889,-71.221299); // Green Space
    private static final LatLng BIN_9 = new LatLng(42.387028,-71.222288); // Collins
    private static final LatLng BIN_10 = new LatLng(42.3872,-71.221832);  // Green Space
    private static final LatLng BIN_11 = new LatLng(42.386831,-71.222038); // Bookstore
    private static final LatLng BIN_12 = new LatLng(42.386562,-71.220901); // Trees Bus Stop
    private static final LatLng BIN_13 = new LatLng(42.386457,-71.220342); // Trees (Alder)
    private static final LatLng BIN_14 = new LatLng(42.386106,-71.219339);  // Trees (Elm)
    private static final LatLng BIN_15 = new LatLng(42.386952,-71.219567); // Lyndsay
    private static final LatLng BIN_16 = new LatLng(42.386832,-71.219131); // Adamian
    private static final LatLng BIN_17 = new LatLng(42.387655,-71.218591); // Morison
    private static final LatLng BIN_18 = new LatLng(42.387852,-71.219628); // Library
    private static final LatLng BIN_19 = new LatLng(42.387849,-71.220178); // Einstein's
    private static final LatLng BIN_20 = new LatLng(42.387537,-71.220368);  // Smith
    private static final LatLng BIN_21 = new LatLng(42.387748,-71.221021); // Jennison
    private static final LatLng BIN_22 = new LatLng(42.388032,-71.221362); // Jennison
    private static final LatLng BIN_23 = new LatLng(42.388166,-71.220543); // Jennison
    private static final LatLng BIN_24 = new LatLng(42.388651,-71.220217);  // LaCava
    private static final LatLng BIN_25 = new LatLng(42.388677,-71.219792); // LaCava
    private static final LatLng BIN_26 = new LatLng(42.388297,-71.221222); // Rauch
    private static final LatLng BIN_27 = new LatLng(42.387919,-71.221524); // Falcone North
    private static final LatLng BIN_28 = new LatLng(42.387801,-71.223067); // Miller
    private static final LatLng BIN_29 = new LatLng(42.387545,-71.223259); // Miller
    private static final LatLng BIN_30 = new LatLng(42.386486,-71.222924);  // Rhodes
    private static final LatLng BIN_31 = new LatLng(42.386430,-71.223730); // Kresge
    private static final LatLng BIN_32 = new LatLng(42.3868,-71.223920); // Forest
    private static final LatLng BIN_33 = new LatLng(42.38555,-71.223726); // Bridge
    private static final LatLng BIN_34 = new LatLng(42.385201,-71.224060);  // Orno
    private static final LatLng BIN_35 = new LatLng(42.38458,-71.224344); // Orso
    private static final LatLng BIN_36 = new LatLng(42.384266,-71.223220); // Fenway
    private static final LatLng BIN_37 = new LatLng(42.384876,-71.223227); // Cono
    private static final LatLng BIN_38 = new LatLng(42.384048,-71.22297); // Fenway
    private static final LatLng BIN_39 = new LatLng(42.383159,-71.223476); // Athletic Fields
    private static final LatLng BIN_40 = new LatLng(42.383157,-71.224346);  // Dana Center
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

        // move camera to the center on bentley
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTER_POINT, zoom));

        // set markers for all bins
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
                .title("Morrison Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_4)
                .title("User Experience Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_5)
                .title("Boylston B")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_6)
                .title("Rhodes")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_7)
                .title("Greenspace")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_8)
                .title("Greenspace")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_9)
                .title("Collins")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_10)
                .title("Greenspace")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_11)
                .title("University Bookstore")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_12)
                .title("Trees Bus Stop")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_13)
                .title("Trees (Alder)")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_14)
                .title("Trees (Elm)")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_15)
                .title("Lyndsay Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_16)
                .title("Adamian Academic Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_17)
                .title("Morrison Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_18)
                .title("University Library")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_19)
                .title("Einstein Bros Bagels")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_20)
                .title("Smith Technology Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_21)
                .title("Jennison Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_22)
                .title("Jennison Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_23)
                .title("Jennison Hall")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_24)
                .title("LaCava")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_25)
                .title("LaCava")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_26)
                .title("Rauch")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_27)
                .title("Falcone North")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_28)
                .title("Miller")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_29)
                .title("Miller")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_30)
                .title("Rhodes")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_31)
                .title("Kresge")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_32)
                .title("Forest")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_33)
                .title("University Bridge")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_34)
                .title("Orchard North")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_35)
                .title("Orchard South")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_36)
                .title("Fenway")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_37)
                .title("Copley North")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_38)
                .title("Fenway")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_39)
                .title("Athletic Fields")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(BIN_40)
                .title("Dana Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin)));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(42.387983,-71.219838))
                .title("Library Ground Floor (Next to Client Services)")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.electronics_marker)));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(42.387787,-71.218821))
                .title("Morrison First Floor")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.electronics_marker)));

        // set onclick listener for markers to display approximate location (building)
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
