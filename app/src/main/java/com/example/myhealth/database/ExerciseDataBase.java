package com.example.myhealth.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myhealth.Constants;
import com.example.myhealth.model.ExerciseDB;
import com.example.myhealth.model.ExerciseModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities={ExerciseDB.class},version=1,exportSchema = false)
public abstract class ExerciseDataBase extends RoomDatabase {
    private static ExerciseDataBase moviesDataBaseInstance;
    public abstract ExerciseDao moviesDao();

    public static synchronized ExerciseDataBase getInstance(Context context){
        if(moviesDataBaseInstance==null){
            moviesDataBaseInstance= Room.databaseBuilder(context.getApplicationContext(),ExerciseDataBase.class
                    , Constants.DB_TABLE).addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            String Json= (String) loadJSONFromAsset(context);
                            Gson gson = new Gson();
                            ExerciseModel exer = gson.fromJson(Json, new TypeToken<ExerciseModel>(){}.getType());
                            for (int i=0;i<exer.getExercises().size();i++){
                                String muscle=exer.getExercises().get(i).getMuscles().getTarget();
                                String name=exer.getExercises().get(i).getName();
                                String comments=exer.getExercises().get(i).getComments();
                                String gifUrl=exer.getExercises().get(i).getGif();
                                String Preparation=exer.getExercises().get(i).getInstructions().getPreparation();
                                String Execution=exer.getExercises().get(i).getInstructions().getExecution();
                                ExerciseDB ex=new ExerciseDB(muscle,name,comments,Preparation,Execution,gifUrl);
                                getInstance(context).moviesDao().Insert(ex);
                            }
                        }
                    });
                }
            }).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return moviesDataBaseInstance;
    }
    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(Constants.DB_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
