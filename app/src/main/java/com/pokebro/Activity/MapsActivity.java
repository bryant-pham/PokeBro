package com.pokebro.Activity;

import android.hardware.SensorManager;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pokebro.Application.GlobalContext;
import com.pokebro.GameEngine.GameEngine;
import com.pokebro.R;
import com.pokebro.Input.StepSensor;

public class MapsActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private final String ACTIVITY_TAG = "MapActivity";
    private GoogleMap map;
    private GoogleApiClient googleApiClient;
    private Marker mapMarker;
    private Location lastLocation;
    private StepSensor stepSensor;

    private final float zoomLevel = 17;
    private final float tiltLevel = 67.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setUpMapIfNeeded();

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        GlobalContext globalContext = (GlobalContext) getApplicationContext();
        GameEngine gameEngine = globalContext.getGameEngine();
        stepSensor = new StepSensor(this, (SensorManager) getSystemService(SENSOR_SERVICE), gameEngine);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        stepSensor.startSensor();
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        googleApiClient.disconnect();
        stepSensor.stopSensor();
    }

    private void setUpMapIfNeeded() {
        if (map == null) {
            // Try to obtain the map from the SupportMapFragment.
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(LatLng latLng) {
                    LatLng currentLatLng = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, zoomLevel));
                }
            });
        }
    }

    private void addAvatarToMap(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        mapMarker = map.addMarker(new MarkerOptions()
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.hero))
                            .position(latLng)
        );
        CameraPosition cameraPosition = new CameraPosition.Builder()
                                            .target(latLng)
                                            .zoom(zoomLevel)
                                            .tilt(tiltLevel)
                                            .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void updateAvatarPosition(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        mapMarker.setPosition(latLng);

        // Centers camera on avatar if distance between current and last location is > ~0.25 miles - used for initial GPS inaccuracies
        if(lastLocation.distanceTo(location) > 400)
            map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(ACTIVITY_TAG, "GoogleApiClient Connected");
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(2000);
        locationRequest.setFastestInterval(2000);

        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(ACTIVITY_TAG, "GoogleApiClient Suspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(ACTIVITY_TAG, "GoogleApiClient Connection Failed");
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i(ACTIVITY_TAG, "Location received: " + location.toString());
        if(lastLocation == null)
            addAvatarToMap(location);
        else
            updateAvatarPosition(location);

        lastLocation = location;
    }
}
