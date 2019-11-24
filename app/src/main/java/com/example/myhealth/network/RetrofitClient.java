package com.example.myhealth.network;
import com.example.myhealth.model.GymPlacesModel;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit getRetrofit(String BASE_URL) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    /**
     * Get API Service
     *
     * @return API Service
     */

    public static GymPlacesModel.ResultsBean gymPlacesModelResults;

    public static GoogleSearchService getGoogleApiService(String BASE_URL){
        return getRetrofit(BASE_URL).create(GoogleSearchService.class);
    }

}
