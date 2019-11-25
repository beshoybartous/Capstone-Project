package com.example.myhealth.ui.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.myhealth.Constants;
import com.example.myhealth.R;
import com.example.myhealth.adapter.GymAdapter;
import com.example.myhealth.databinding.FragmentMapsBinding;
import com.example.myhealth.model.GymPlacesModel;
import com.example.myhealth.viewmodel.GymViewModel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener ,GymAdapter.ListItemClickListiner{

    private static final int MY_PERMISSION_CODE = 1000;
    private GoogleMap mMap = null;

    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    FragmentMapsBinding mapsBinding;
    GymViewModel gymViewModel;
    GoogleApiClient mGoogleApiClient;
    ArrayList<MarkerOptions> mapMarker = new ArrayList<>();
    GymPlacesModel gymPlacesModelResults = new GymPlacesModel();
    GymAdapter gymAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mapsBinding = DataBindingUtil.
                inflate(inflater, R.layout.fragment_maps, container, false);

        gymAdapter=new GymAdapter(getContext(),  MapsFragment.this);
        @SuppressLint("WrongConstant") RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getContext(),LinearLayoutManager.VERTICAL,false );
        mapsBinding.rvMaps.setLayoutManager( layoutManager );

        gymViewModel = ViewModelProviders.of(getActivity()).get(GymViewModel.class);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            checkLocationPermissions();
        }
        final View rootView = mapsBinding.getRoot();
        return rootView;
    }

    private void nearByPlace(Location location){

        String Url=getUrl(location.getLatitude(),location.getLongitude());
        gymViewModel.getNearByPlaces(Url).observe(this, new Observer<List<GymPlacesModel.ResultsBean>>() {
            @Override
            public void onChanged(List<GymPlacesModel.ResultsBean> resultsBeans) {
                if(resultsBeans!=null&&resultsBeans.size()>0) {
                    gymPlacesModelResults.setResults(resultsBeans);
                    gymAdapter.setPlaces(resultsBeans);
                    gymAdapter.notifyDataSetChanged();
                    mapsBinding.rvMaps.setAdapter(gymAdapter);
                }
                for(int i=0;i<resultsBeans.size();i++){
                    MarkerOptions markerOptions=new MarkerOptions();
                    GymPlacesModel.ResultsBean googlePlace=resultsBeans.get(i);
                    double lat= googlePlace.getGeometry().getLocation().getLat();
                    double lng= googlePlace.getGeometry().getLocation().getLng();
                    String placeName=googlePlace.getName();
                    LatLng latLng=new LatLng(lat,lng);
                    markerOptions.position(latLng);
                    markerOptions.title(placeName);
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                    markerOptions.snippet(String.valueOf(i));
                    mapMarker.add(markerOptions);
                    mMap.addMarker(markerOptions);
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                }
                if(mLastLocation!=null) {
                    LatLng coordinate = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
                    CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 14);
                    mMap.animateCamera(yourLocation);
                }
            }
        });

    }

    private String getUrl(double latat, double longt) {
        StringBuilder googlePlaceUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlaceUrl.append("&radius=" + 1000);
        googlePlaceUrl.append("&location="+latat+","+longt);
        googlePlaceUrl.append("&type=gym");
        googlePlaceUrl.append("&sensor=true");
        googlePlaceUrl.append("&key=" + Constants.GOOGLE_API_KEY);
        return googlePlaceUrl.toString();
    }

    protected synchronized void buildGoogleApiClient(){
        mGoogleApiClient=new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation=location;
        if(location==null){
            Toast.makeText(getContext(),"location not found",Toast.LENGTH_SHORT).show();
        }
        else {
            LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());
            mMap.animateCamera(CameraUpdateFactory.zoomBy(14));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            nearByPlace(mLastLocation);
            if(mGoogleApiClient!=null){
                LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,this);
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest().create();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ActivityCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                ) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }


    private boolean checkLocationPermissions() {
        if(ContextCompat.checkSelfPermission(getContext(), ACCESS_FINE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), ACCESS_FINE_LOCATION)){
                requestPermissions(new String[]{

                        ACCESS_FINE_LOCATION
                },MY_PERMISSION_CODE);

            }
            else{
                requestPermissions(new String[]{

                        ACCESS_FINE_LOCATION
                },MY_PERMISSION_CODE);

            }
            return false;
        }
        else
            return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode)
        {
            case MY_PERMISSION_CODE:
            {
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(getContext(), ACCESS_FINE_LOCATION)
                            ==PackageManager.PERMISSION_GRANTED){
                        buildGoogleApiClient();
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else{
                    Toast.makeText(getContext(),"Permission deinied",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onListItemClick(GymPlacesModel.ResultsBean place) {

        double latitude = place.getGeometry().getLocation().getLat();
        double longitude =place.getGeometry().getLocation().getLng();
        String uriBegin = "https://www.google.com/maps/search/?api=1&query=" + latitude + "," + longitude;
        uriBegin+="&query_place_id="+place.getPlace_id();
        Uri uri = Uri.parse(uriBegin);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState( outState );
        outState.putParcelableArrayList("mapMarker",mapMarker);

    }
}
