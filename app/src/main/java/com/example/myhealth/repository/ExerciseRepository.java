package com.example.myhealth.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myhealth.database.ExerciseDao;
import com.example.myhealth.database.ExerciseDataBase;
import com.example.myhealth.model.ExerciseDB;

import java.util.List;

public class ExerciseRepository {
    private ExerciseDao exerciseDao;
    private LiveData<List<ExerciseDB>> listLiveData;
    public ExerciseRepository(Application application) {
        ExerciseDataBase exerciseDataBase=ExerciseDataBase.getInstance( application );
        exerciseDao=exerciseDataBase.moviesDao();
        listLiveData=exerciseDao.getAllExercises();
    }

    public LiveData<List<ExerciseDB>> getExercises(){
        return listLiveData;
    }
    public LiveData<List<ExerciseDB>> getByMuscle(String muscle){
        return exerciseDao.getByMuscle(muscle);
    }




}
