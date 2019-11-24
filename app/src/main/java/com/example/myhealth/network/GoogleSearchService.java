package com.example.myhealth.network;

import com.example.myhealth.model.GymPlaceDetailModel;
import com.example.myhealth.model.GymPlacesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GoogleSearchService {

    @GET
    Call<GymPlacesModel> getNearByPlaces(@Url String url);
    @GET
    Call<GymPlaceDetailModel> getDetailPlace(@Url String url);
}


