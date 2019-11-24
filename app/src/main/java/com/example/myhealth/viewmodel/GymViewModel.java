package com.example.myhealth.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myhealth.model.GymPlaceDetailModel;
import com.example.myhealth.model.GymPlacesModel;
import com.example.myhealth.repository.GymRepository;

import java.util.List;

public class GymViewModel extends AndroidViewModel {
    GymRepository gymRepository;
    public GymViewModel(@NonNull Application application) {
        super(application);
        gymRepository=new GymRepository(application);
    }
    public LiveData<List<GymPlacesModel.ResultsBean>> getNearByPlaces(String url){
        return gymRepository.getNearByPlaces(url);
    }
    public LiveData<GymPlaceDetailModel.ResultBean> getGymPlaceDetail(String url){
        return gymRepository.getGymPlaceDetail(url);

    }
}
