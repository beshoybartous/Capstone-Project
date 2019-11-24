package com.example.myhealth.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myhealth.Constants;
import com.example.myhealth.model.ExerciseDB;
import com.example.myhealth.repository.ExerciseRepository;

import java.util.List;

public class ExerciseViewModel extends AndroidViewModel {
    private ExerciseRepository exerciseRepository;


    private LiveData<List<ExerciseDB>> listLiveData;

    public ExerciseViewModel(@NonNull Application application) {
        super(application);
        exerciseRepository=new ExerciseRepository(application);
        listLiveData=exerciseRepository.getExercises();
    }
    public LiveData<List<ExerciseDB>> getExercises(){
        return listLiveData;
    }

    public LiveData<List<ExerciseDB>> getByMuscle(String muscle){
        return exerciseRepository.getByMuscle(muscle);
    }
    }
