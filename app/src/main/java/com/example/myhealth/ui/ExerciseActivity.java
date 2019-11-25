package com.example.myhealth.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.example.myhealth.Constants;
import com.example.myhealth.R;
import com.example.myhealth.adapter.ExerciseListAdapter;
import com.example.myhealth.databinding.ActivityExerciseBinding;
import com.example.myhealth.model.ExerciseDB;
import com.example.myhealth.viewmodel.ExerciseViewModel;
import java.util.ArrayList;
import java.util.List;

public class ExerciseActivity extends AppCompatActivity implements ExerciseListAdapter.ListItemClickListiner{
    ActivityExerciseBinding activityExerciseBinding;
    String category;

    private ExerciseViewModel exerciseViewModel;
    private ExerciseListAdapter exerciseListAdapter;
    boolean fromWorkout=false;
    List<Integer> removedExe=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityExerciseBinding= DataBindingUtil.setContentView(this,R.layout.activity_exercise);
        Toolbar toolbar = (Toolbar) activityExerciseBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        exerciseViewModel= ViewModelProviders.of( ExerciseActivity.this ).get( ExerciseViewModel.class );
        category=getIntent().getStringExtra(Constants.MUSCLE_NAME);
        exerciseListAdapter=new ExerciseListAdapter(this,ExerciseActivity.this);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            @SuppressLint("WrongConstant") RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false );
            activityExerciseBinding.rvExercise.setLayoutManager( layoutManager );
        }
        else{
            int columnNumber= calculateNoOfColumns( this );

            activityExerciseBinding.rvExercise.setLayoutManager( new GridLayoutManager( ExerciseActivity.this,columnNumber ) );
        }

        fromWorkout=getIntent().getBooleanExtra(Constants.OPEN_FROM_WORKOUT,false);
        if(fromWorkout){
            activityExerciseBinding.note.setVisibility(View.VISIBLE);
            String planName=getIntent().getStringExtra(Constants.WORKOUT_PLAN_NAME);
            getSupportActionBar().setTitle(planName);
            List<ExerciseDB> exerciseDBS=getIntent().getParcelableArrayListExtra(Constants.SEND_EXERCISE_LIST);
            exerciseListAdapter.setExercises(exerciseDBS);
            exerciseListAdapter.setWorkout(true);
            exerciseListAdapter.notifyDataSetChanged();
            activityExerciseBinding.rvExercise.setAdapter(exerciseListAdapter);
            ItemTouchHelper itemTouchHelper=
                    new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
                        @Override
                        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                            return false;
                        }
                        @Override
                        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                            List <ExerciseDB> exercise =exerciseListAdapter.getExercises();
                            int pos=viewHolder.getAdapterPosition();
                            int exeID=exercise.get(pos).getId();
                            removedExe.add(exeID);
                            exercise.remove(pos);
                            exerciseListAdapter.setExercises(exercise);
                            exerciseListAdapter.notifyDataSetChanged();
                        }
                    });
            itemTouchHelper.attachToRecyclerView(activityExerciseBinding.rvExercise);
        }
        else {
            if (category.equals(Constants.ALL)) {
                exerciseViewModel.getExercises().observe(this, new Observer<List<ExerciseDB>>() {
                    @Override
                    public void onChanged(List<ExerciseDB> exerciseDBS) {
                        exerciseListAdapter.setExercises(exerciseDBS);
                        exerciseListAdapter.notifyDataSetChanged();
                        activityExerciseBinding.rvExercise.setAdapter(exerciseListAdapter);
                    }
                });
            } else {
                exerciseViewModel.getByMuscle(category).observe(this, new Observer<List<ExerciseDB>>() {
                    @Override
                    public void onChanged(List<ExerciseDB> exerciseDBS) {
                        exerciseListAdapter.setExercises(exerciseDBS);
                        exerciseListAdapter.notifyDataSetChanged();
                        activityExerciseBinding.rvExercise.setAdapter(exerciseListAdapter);
                    }

                });
                getSupportActionBar().setTitle(category);

            }
        }
    }
    private Intent removedExercises(String planName){
        Intent intent= new Intent();
        intent.putIntegerArrayListExtra(Constants.REMOVED_EXERCISE, (ArrayList<Integer>) removedExe);
        intent.putExtra(Constants.WORKOUT_PLAN_NAME, planName);
        return intent;
    }


    @Override
    public void onBackPressed() {
        if(fromWorkout&& removedExe.size()>0){
            String planName=getIntent().getStringExtra(Constants.WORKOUT_PLAN_NAME);
            setResult(RESULT_OK,removedExercises(planName));
        }
        super.onBackPressed();

    }
    @Override
    public void onListItemClick(ExerciseDB exercise) {
        Intent exerciseDetail=new Intent(this,ExerciseDetailActivity.class);
        exerciseDetail.putExtra(Constants.SEND_EXERCISE,exercise);
        if(fromWorkout){
            exerciseDetail.putExtra(Constants.OPEN_FROM_WORKOUT,true);
        }
        startActivity(exerciseDetail);
    }

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int scalingFactor = 200;
        int noOfColumns = (int) (dpWidth / scalingFactor);
        if(noOfColumns < 2)
            noOfColumns = 2;
        return noOfColumns;
    }

}
