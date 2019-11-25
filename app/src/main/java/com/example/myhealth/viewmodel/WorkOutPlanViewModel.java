package com.example.myhealth.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myhealth.model.ExerciseDB;
import com.example.myhealth.model.WorkoutPlanModel;
import com.example.myhealth.repository.DataLoadListener;
import com.example.myhealth.repository.WorkOutPlanRepository;
import com.example.myhealth.ui.fragment.WorkoutFragment;

import java.util.List;

public class WorkOutPlanViewModel extends ViewModel {

    MutableLiveData<List<String>> plans;
    MutableLiveData<List<ExerciseDB>> exersices;



    public LiveData<List<String>> getWorkOutPlans(DataLoadListener context){
            plans = WorkOutPlanRepository.getInstance(context).loadWorkoutPlans();

        return plans;
    }
    public LiveData<List<ExerciseDB>> getExercises(DataLoadListener context,String workoutName){
        exersices= WorkOutPlanRepository.getInstance(context).loadallExercises(workoutName);
        return exersices;
    }
    public void clearData(DataLoadListener context){
        WorkOutPlanRepository.getInstance(context).clearData();
    }
    public void addExercise(String WorkoutPlan,ExerciseDB exerciseDB,DataLoadListener context){
        WorkOutPlanRepository.getInstance(context).addExercises(WorkoutPlan,exerciseDB);
    }
    public void addWorkOutPlan(String workoutPlanName,DataLoadListener context){
        WorkOutPlanRepository.getInstance(context).addWorkOutPlan(workoutPlanName);
        plans = WorkOutPlanRepository.getInstance(context).loadWorkoutPlans();
    }
    public void deleteWorkoutPlan(String workoutPlanName,DataLoadListener context){
        WorkOutPlanRepository.getInstance(context).deleteWorkoutPlan(workoutPlanName);

    }

    public void removeExercises(List<Integer> removedExe,String planName, WorkoutFragment workoutFragment) {
        WorkOutPlanRepository.getInstance(workoutFragment).removeExercises(removedExe,planName);

    }
}
