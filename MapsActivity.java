package com.example.pollutionappfinaltry;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import androidx.annotation.NonNull;

import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.android.PolyUtil;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import org.joda.time.DateTime;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final int overview = 0;

    private Button button;
    String data1 = "";
    String data2 = "";
    String data3 = "45";
    String data4 = "";
    String data5 = "";

    private GoogleMap mMap;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef1 = mRootRef.child("Indira Nagar");
    DatabaseReference mConditionRef2 = mRootRef.child("IIT M, Research Park");
    DatabaseReference mConditionRef3 = mRootRef.child("S2 Thyegaraja");
    DatabaseReference mConditionRef4 = mRootRef.child("Thiruvanmayur");
    DatabaseReference mConditionRef5 = mRootRef.child("Ascendas");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        mConditionRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    data1 = String.valueOf(dataSnapshot.getValue(Long.class));
                } catch (Exception exc) {
                    System.out.println("Something else bro");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mConditionRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    data2 = String.valueOf(dataSnapshot.getValue(Long.class));
                }
                catch (Exception exc) {
                    System.out.println("Something else bro");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mConditionRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    data4 = String.valueOf(dataSnapshot.getValue(Long.class));
                }
                catch (Exception exc) {
                    System.out.println("Something else bro");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mConditionRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    data5 = String.valueOf(dataSnapshot.getValue(Long.class));
                } catch (Exception exc) {
                    System.out.println("Something else bro");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void calculateShortestPath(View view){
          if(data3.compareTo(data5)<0){
              shortMessage("Take Path via S2 Thyegaraja");
          }
          else{
              shortMessage("Take Path via Ascendas");
          }
    }



    @Override
    protected void onStart(){
        super.onStart();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setupGoogleMapScreenSettings(googleMap);
        DirectionsResult results = getDirectionsDetails("Indira Nagar","IIT M, Research Park",TravelMode.DRIVING);
        if (results != null) {
            addPolyline(results, googleMap);
        }
        mConditionRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{

                    String text1 = String.valueOf(dataSnapshot.getValue(Long.class));
                    LatLng indnagar = new LatLng(12.9960496,80.2492729);
                    mMap.addMarker(new MarkerOptions().position(indnagar).title("Indira Nagar: "+data1));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(indnagar));
                }
                catch (Exception exc){
                    exc.printStackTrace();
                }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mConditionRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{

                    String text2 = String.valueOf(dataSnapshot.getValue(Long.class));
                    LatLng iitm = new LatLng(12.9901947,80.2396882);
                    mMap.addMarker(new MarkerOptions().position(iitm).title("IITM Research Park: " + data2));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(iitm));
                }
                catch (Exception exc){
                    exc.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mConditionRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{
                    LatLng s2t = new LatLng(12.9895177,80.2542498);
                    mMap.addMarker(new MarkerOptions().position(s2t).title("S2 Theyagaraja: "+data3));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(s2t));
                }
                catch (Exception exc){
                    exc.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mConditionRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{

                    String text4 = String.valueOf(dataSnapshot.getValue(Long.class));
                    LatLng thiruv = new LatLng(12.9831838,80.248253);
                    mMap.addMarker(new MarkerOptions().position(thiruv).title("Thiruvanmayur: "+data4));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(thiruv));
                }
                catch (Exception exc){
                    exc.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mConditionRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{

                    String text5 = String.valueOf(dataSnapshot.getValue(Long.class));
                    LatLng asc = new LatLng(12.9857656,80.2436763);
                    mMap.addMarker(new MarkerOptions().position(asc).title("Ascendas: "+data5));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(asc));
                }
                catch (Exception exc){
                    exc.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private GeoApiContext getGeoContext()
    {
        GeoApiContext geoApiContext = new GeoApiContext();
        return geoApiContext.setQueryRateLimit(3).setApiKey(getString(R.string.directionsApiKey)).setConnectTimeout(1, TimeUnit.SECONDS).setWriteTimeout(1, TimeUnit.SECONDS);
    }

    private DirectionsResult getDirectionsDetails(String origin, String destination, TravelMode mode) {
        DateTime now = new DateTime();
        try {
            return DirectionsApi.newRequest(getGeoContext())
                    .mode(mode)
                    .origin(origin)
                    .destination(destination)
                    .departureTime(now)
                    .await();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void setupGoogleMapScreenSettings(GoogleMap mMap) {
        mMap.setBuildingsEnabled(true);
        mMap.setIndoorEnabled(true);
        mMap.setTrafficEnabled(true);
        UiSettings mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);
        mUiSettings.setCompassEnabled(true);
        mUiSettings.setMyLocationButtonEnabled(true);
        mUiSettings.setScrollGesturesEnabled(true);
        mUiSettings.setZoomGesturesEnabled(true);
        mUiSettings.setTiltGesturesEnabled(true);
        mUiSettings.setRotateGesturesEnabled(true);
    }
    private void addPolyline(DirectionsResult results, GoogleMap mMap) {
        List<LatLng> decodedPath = PolyUtil.decode(results.routes[overview].overviewPolyline.getEncodedPath());
        mMap.addPolyline(new PolylineOptions().addAll(decodedPath));
    }
    private void shortMessage(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
