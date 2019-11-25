package com.example.myhealth.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myhealth.Constants;
import com.example.myhealth.R;
import com.example.myhealth.adapter.WorkoutPlanAdapter;
import com.example.myhealth.databinding.FragmentWorkoutBinding;
import com.example.myhealth.model.ExerciseDB;
import com.example.myhealth.repository.DataLoadListener;
import com.example.myhealth.ui.ExerciseActivity;
import com.example.myhealth.ui.ExerciseDetailActivity;
import com.example.myhealth.ui.MainActivity;
import com.example.myhealth.viewmodel.WorkOutPlanViewModel;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class WorkoutFragment extends Fragment implements WorkoutPlanAdapter.ListItemClickListiner,DataLoadListener {
    FragmentWorkoutBinding workoutBinding;
    WorkOutPlanViewModel viewmodel;
    List<String> listItems = new ArrayList<>();
    WorkoutPlanAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        workoutBinding= DataBindingUtil
                .inflate(inflater,R.layout.fragment_workout,container,false);
        viewmodel= ViewModelProviders.of(WorkoutFragment.this).get(WorkOutPlanViewModel.class);
        listItems=viewmodel.getWorkOutPlans(this).getValue();
        myAdapter=new WorkoutPlanAdapter(getContext(),WorkoutFragment.this);
        @SuppressLint("WrongConstant") RecyclerView.LayoutManager layoutManager=
                new LinearLayoutManager( getContext(),LinearLayoutManager.VERTICAL,false );
        workoutBinding.rvHome.setLayoutManager( layoutManager );
        workoutBinding.addWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                final EditText edittext = new EditText(getContext());
                alert.setTitle(R.string.dialog_title);
                alert.setMessage(R.string.dialog_message);
                alert.setView(edittext);
                alert.setNegativeButton(R.string.dialog_button1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String YouEditTextValue = edittext.getText().toString();
                        onNameLoaded();
                        Toast.makeText(getContext(),YouEditTextValue,Toast.LENGTH_SHORT).show();
                        viewmodel.addWorkOutPlan(YouEditTextValue,WorkoutFragment.this);
                    }
                });
                alert.setPositiveButton(R.string.dialog_button2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

                alert.show();
            }
        });
        ItemTouchHelper itemTouchHelper=
                new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                List <String> plans =myAdapter.getWorkoutPlans();
                int pos=viewHolder.getAdapterPosition();
                String planName=plans.get(pos);
                viewmodel.deleteWorkoutPlan(planName,WorkoutFragment.this);
                plans.remove(pos);
                myAdapter.setWorkoutPlans(plans);
                myAdapter.notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(workoutBinding.rvHome);
        final View rootView = workoutBinding.getRoot();
        return rootView;    }
    String exeName="";
    @Override
    public void onListItemClick(String workoutPlan) {
        viewmodel.clearData(this);
        exeName=workoutPlan;
        onExerciseLoad();
    }

    @Override
    public void onNameLoaded() {

        viewmodel.getWorkOutPlans(this).observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> workoutPlanModels) {
                myAdapter.setWorkoutPlans(workoutPlanModels);
                myAdapter.notifyDataSetChanged();
                workoutBinding.rvHome.setAdapter(myAdapter);
            }
        });
    }
    @Override
    public void onExerciseLoad() {
        if(exeName!=""){
            viewmodel.getExercises(this,exeName).observe(this, new Observer<List<ExerciseDB>>() {
                @Override
                public void onChanged(List<ExerciseDB> exerciseDBS) {
                    if(exerciseDBS.size()>0){
                        Intent exerciseActivity=new Intent(getActivity(), ExerciseActivity.class);
                        exerciseActivity.putExtra(Constants.OPEN_FROM_WORKOUT,true);
                        exerciseActivity.putExtra(Constants.WORKOUT_PLAN_NAME,exeName);
                        exerciseActivity.putParcelableArrayListExtra(Constants.SEND_EXERCISE_LIST, (ArrayList<? extends Parcelable>) exerciseDBS);
                        startActivityForResult(exerciseActivity,1);
                    }
                }
            });
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 &&resultCode==RESULT_OK) {
            List<Integer> removedExe=data.getIntegerArrayListExtra(Constants.REMOVED_EXERCISE);
            String planName=data.getStringExtra(Constants.WORKOUT_PLAN_NAME);
            viewmodel.removeExercises(removedExe,planName,WorkoutFragment.this);
        }
        }
}
