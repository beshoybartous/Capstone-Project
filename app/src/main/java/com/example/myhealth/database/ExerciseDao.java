package com.example.myhealth.database;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myhealth.model.ExerciseDB;

import java.util.List;

@Dao

public interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(ExerciseDB exercise);


    @Query( "Select * from exersice_table" )
    LiveData<List<ExerciseDB>> getAllExercises();

    @Query( "Select * from exersice_table where muscle= :muscle" )
    LiveData<List<ExerciseDB>> getByMuscle(String muscle);


}
