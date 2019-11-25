package com.example.myhealth.repository;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.example.myhealth.model.ExerciseDB;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class WorkOutPlanRepository {

    private DatabaseReference mRefrenceExercise;
    private List<String> workoutPlan=new ArrayList<>();
    private List<ExerciseDB> exercises=new ArrayList<>();

    static WorkOutPlanRepository instance;
    static Context mContext;
    static DataLoadListener dataLoadListener;
    public static WorkOutPlanRepository getInstance(DataLoadListener context){
        if(instance==null){
            instance=new WorkOutPlanRepository();
        }
        dataLoadListener=context;
        return instance;
    }


    public MutableLiveData<List<String>> loadWorkoutPlans(){
        if(workoutPlan.size()==0) {
            loadPlans();
        }
        final MutableLiveData<List<String>> plans=new MutableLiveData<>();
        plans.setValue(workoutPlan);
        workoutPlan=new ArrayList<>();
        return plans;
    }

    private void loadPlans() {
        DatabaseReference  mRefrenceWorkout=FirebaseDatabase.getInstance().getReference();
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query= mRefrenceWorkout.child("workout");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    String value=snapshot.getValue().toString();
                    if(value.contains(currentuser)){
                        workoutPlan.add((String) snapshot.getKey());
                    }
                }
                dataLoadListener.onNameLoaded();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    boolean loaded=false;
    public MutableLiveData<List<ExerciseDB>> loadallExercises(String workoutName){
        if(exercises.size()==0&&!loaded) {
            loadExercise(workoutName);
            loaded=true;
        }
        final MutableLiveData<List<ExerciseDB>> exe=new MutableLiveData<>();
        exe.setValue(exercises);
        if(exercises.size()>0){
            loaded=false;
            exercises=new ArrayList<>();
        }
        return exe;
    }
    public void clearData(){
        loaded=false;
    }
    private void loadExercise(String workoutName) {
        DatabaseReference  mRefrenceWorkout=FirebaseDatabase.getInstance().getReference();
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query= mRefrenceWorkout.child(currentuser).child(workoutName);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    ExerciseDB exe=snapshot.getValue(ExerciseDB.class);
                    exercises.add(exe);
                }

                dataLoadListener.onExerciseLoad();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void addExercises(String workoutPlan,ExerciseDB exerciseDB) {
        DatabaseReference  mRefrenceWorkout=FirebaseDatabase.getInstance().getReference();
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query= mRefrenceWorkout.child(currentuser).child(workoutPlan);
        String key=String.valueOf(exerciseDB.getId());
        ((DatabaseReference) query).child(key).setValue(exerciseDB).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        });
    }

    public void addWorkOutPlan(String workoutPlanName){
        DatabaseReference  mRefrenceWorkout=FirebaseDatabase.getInstance().getReference();
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query= mRefrenceWorkout.child("workout").child(workoutPlanName);
        String key=currentuser;
        ((DatabaseReference) query).child(key).setValue(currentuser).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        });
    }
    public void deleteWorkoutPlan(String workoutPlanName ){
        DatabaseReference  mRefrenceWorkout=FirebaseDatabase.getInstance().getReference();
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query= mRefrenceWorkout.child("workout").child(workoutPlanName).child(currentuser);
        ((DatabaseReference) query).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        });
        query= mRefrenceWorkout.child(currentuser).child(workoutPlanName);
        ((DatabaseReference) query).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        });

    }

    public void removeExercises(List<Integer> removedExe,String planName) {
        DatabaseReference  mRefrenceWorkout=FirebaseDatabase.getInstance().getReference();
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        for (Integer i:removedExe) {

            Query query= mRefrenceWorkout.child(currentuser).child(planName).child(String.valueOf(i));
            ((DatabaseReference) query).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {

                }
            });

        }
    }
}
