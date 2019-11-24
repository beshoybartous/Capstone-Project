package com.example.myhealth.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myhealth.Constants;
import com.example.myhealth.model.GymPlaceDetailModel;
import com.example.myhealth.model.GymPlacesModel;
import com.example.myhealth.network.GoogleSearchService;
import com.example.myhealth.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GymRepository {

    public GymRepository(Application application) {

    }

    public LiveData<List<GymPlacesModel.ResultsBean>> getNearByPlaces(String url){
        final MutableLiveData<List<GymPlacesModel.ResultsBean>> gymPlacesModel=new MutableLiveData<>();

        GoogleSearchService api= RetrofitClient.getGoogleApiService(Constants.GOOGLE_API_URL);
        Call<GymPlacesModel> call=api.getNearByPlaces(url);
        call.enqueue(new Callback<GymPlacesModel>() {
            @Override
            public void onResponse(Call<GymPlacesModel> call, Response<GymPlacesModel> response) {
                if(response.isSuccessful()){
                    GymPlacesModel gymPlacemod= response.body();
                    gymPlacesModel.setValue(gymPlacemod.getResults());
                }
            }

            @Override
            public void onFailure(Call<GymPlacesModel> call, Throwable t) {

            }
        });
        return gymPlacesModel;
    }
    public LiveData<GymPlaceDetailModel.ResultBean> getGymPlaceDetail(String url){
        final MutableLiveData<GymPlaceDetailModel.ResultBean> gymPlaceDetailModel=new MutableLiveData<>();

        GoogleSearchService api= RetrofitClient.getGoogleApiService(Constants.GOOGLE_API_URL);
        Call<GymPlaceDetailModel> call=api.getDetailPlace(url);
        call.enqueue(new Callback<GymPlaceDetailModel>() {
            @Override
            public void onResponse(Call<GymPlaceDetailModel> call, Response<GymPlaceDetailModel> response) {
                if(response.isSuccessful()){
                    GymPlaceDetailModel gymPlaceDetail= response.body();
                    gymPlaceDetailModel.setValue(gymPlaceDetail.getResult());
                }
            }

            @Override
            public void onFailure(Call<GymPlaceDetailModel> call, Throwable t) {

            }
        });
        return gymPlaceDetailModel;
    }


}
