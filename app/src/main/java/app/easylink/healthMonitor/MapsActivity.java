package app.easylink.healthMonitor;

import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import androidx.fragment.app.FragmentActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private static final LatLng c3 = new LatLng(-31.8257, 117.2264);
    private static final LatLng china = new LatLng(35.8617, 104.1954);
    private static final LatLng korea = new LatLng(36, 128);
    private static final LatLng singapore = new LatLng(-27.47093, 153.0235);
    private static final LatLng c1 = new LatLng(34.0522, -118.2437);
    private static final LatLng c2 = new LatLng(-33.8688, 151.2093);
    private static final LatLng iran = new LatLng(32, 53);
    private static final LatLng italy = new LatLng(43, 12);
    private static final LatLng pakistan = new LatLng(30.3753, 69.3451);
    private static final LatLng india = new LatLng(20.5937, 78.9629);
    private static final LatLng turkey = new LatLng(38.9637, 35.2433);
    private static final LatLng germany = new LatLng( 51.1657, 10.4515);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));

        mMap.addMarker(new MarkerOptions().position(china).title("China").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(iran).title("Iran").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(italy).title("Italy").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(c1).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(c2).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(singapore).title("Singapore").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspictwo)));
        mMap.addMarker(new MarkerOptions().position(korea).title("Korea").title("Italy").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(c3).title("").title("Italy").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(turkey).title("Turkey").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspictwo)));
        mMap.addMarker(new MarkerOptions().position(pakistan).title("Pakistan").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(germany).title("Germany").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspic)));
        mMap.addMarker(new MarkerOptions().position(india).title("India").icon(BitmapDescriptorFactory.fromResource(R.drawable.viruspictwo)));
    }

    }
