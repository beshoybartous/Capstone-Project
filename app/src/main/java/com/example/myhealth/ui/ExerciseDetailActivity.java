package com.example.myhealth.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myhealth.Constants;
import com.example.myhealth.R;
import com.example.myhealth.databinding.ActivityExerciseDetailBinding;
import com.example.myhealth.model.ExerciseDB;
import com.example.myhealth.repository.DataLoadListener;
import com.example.myhealth.viewmodel.WorkOutPlanViewModel;
import com.example.myhealth.widget.ExerciseWidgetProvider;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDetailActivity extends AppCompatActivity implements DataLoadListener {
    ActivityExerciseDetailBinding itemBinding;
    AlertDialog myDialog;
    WorkOutPlanViewModel viewmodel;
    List<String> listItems = new ArrayList<>();
    ExerciseDB exercise;
    boolean fromWorkout=false;
    boolean fromWidget=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemBinding= DataBindingUtil.setContentView(this,R.layout.activity_exercise_detail);
        Toolbar toolbar = (Toolbar) itemBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewmodel= ViewModelProviders.of(ExerciseDetailActivity.this).get(WorkOutPlanViewModel.class);
        if(savedInstanceState==null) {
            listItems = viewmodel.getWorkOutPlans(this).getValue();
            itemBinding.addExercise.hide();
            exercise = getIntent().getExtras().getParcelable(Constants.SEND_EXERCISE);
            fromWorkout = getIntent().getBooleanExtra(Constants.OPEN_FROM_WORKOUT, false);
            fromWidget = getIntent().getBooleanExtra(Constants.OPEN_FROM_WDIGET, false);
        }
        else{
            listItems =savedInstanceState.getStringArrayList(Constants.WORKOUT_PLAN_NAME);
            exercise = savedInstanceState.getParcelable(Constants.SEND_EXERCISE);
            fromWorkout = savedInstanceState.getBoolean(Constants.OPEN_FROM_WORKOUT, false);
            fromWidget = savedInstanceState.getBoolean(Constants.OPEN_FROM_WDIGET, false);
            if(fromWorkout){
                itemBinding.addExercise.hide();
            }
        }
         if(exercise!=null) {
             Glide.with(this).asGif().load(Uri.parse(exercise.getGifUrl())).
                     fitCenter().into(itemBinding.imageView);
             itemBinding.textView.setText(exercise.getName());
             itemBinding.textView2.setText("1) " + exercise.getInstructionPreparation() + "\n" +
                     "2) " + exercise.getInstructionExecution());
             itemBinding.textView3.setText(exercise.getComment());
         }
         getSupportActionBar().setTitle(exercise.getName());
         Intent widgetIntent = new Intent(this,
                ExerciseWidgetProvider.class);
        widgetIntent.setAction( AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] ids = AppWidgetManager.getInstance(this).getAppWidgetIds(new ComponentName(this, ExerciseWidgetProvider.class));
        widgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        widgetIntent.putExtra(  Constants.SEND_EXERCISE, exercise);
        this.sendBroadcast(widgetIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(fromWidget){
            Intent exerciseActivity=new Intent(ExerciseDetailActivity.this,ExerciseActivity.class);
            exerciseActivity.putExtra(Constants.MUSCLE_NAME,exercise.getMuscle());
            startActivity(exerciseActivity);
            finish();
            onDestroy();
        }
    }

    public void showAlertDialog(List<String>items){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);

        final CharSequence[] charSequenceItems = items.toArray(new CharSequence[items.size()]);
        alertDialog.setTitle("Add Exercise To Workout").setItems(charSequenceItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ExerciseDetailActivity.this,charSequenceItems[which].toString(),Toast.LENGTH_SHORT).show();
                viewmodel.addExercise(charSequenceItems[which].toString(),exercise,ExerciseDetailActivity.this);
            }
        });

        myDialog=alertDialog.create();
        myDialog.show();
    }
    boolean firsttime=false;
    @Override
    public void onNameLoaded() {
        viewmodel.getWorkOutPlans(ExerciseDetailActivity.this).observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> workoutPlanModels) {
                itemBinding.addExercise.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showAlertDialog(workoutPlanModels);
                    }
                });
            }
        });
        if(!firsttime&&!fromWorkout){
            itemBinding.addExercise.show();
            firsttime=true;
        }
    }
    @Override
    public void onExerciseLoad() {

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        ArrayList<String>arrayList= (ArrayList<String>) listItems;
        outState.putStringArrayList(Constants.WORKOUT_PLAN_NAME,arrayList);
        outState.putParcelable(Constants.SEND_EXERCISE,exercise);
        outState.putBoolean(Constants.OPEN_FROM_WORKOUT,fromWorkout);
        outState.putBoolean(Constants.OPEN_FROM_WDIGET,fromWidget);
        super.onSaveInstanceState( outState );
    }
}
