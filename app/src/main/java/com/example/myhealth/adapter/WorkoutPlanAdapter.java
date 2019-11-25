package com.example.myhealth.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealth.R;
import com.example.myhealth.databinding.HomeItemsBinding;
import com.example.myhealth.databinding.WorkoutPlanLlistItemBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutPlanAdapter extends RecyclerView.Adapter<WorkoutPlanAdapter.WorkoutPlanViewHolder>{
    private Context mContext;
    List<String> workoutPlans;
    final private WorkoutPlanAdapter.ListItemClickListiner listItemClickListiner;

    public WorkoutPlanAdapter(@NonNull Context context, WorkoutPlanAdapter.ListItemClickListiner listItemClickListiner) {
        mContext=context;
        this.listItemClickListiner=listItemClickListiner;
        workoutPlans=new ArrayList<>();
    }

    public void setWorkoutPlans(List<String> workoutPlans){
        this.workoutPlans=workoutPlans;
    }
    public List<String> getWorkoutPlans(){
        return workoutPlans;
    }
    @NonNull
    @Override
    public WorkoutPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        WorkoutPlanLlistItemBinding itemBinding = DataBindingUtil.
                inflate(inflater, R.layout.workout_plan_llist_item,parent,false);
        return new WorkoutPlanAdapter.WorkoutPlanViewHolder( itemBinding );

    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutPlanViewHolder holder, int position) {
        holder.itemBinding.textView.setText(workoutPlans.get(position));
    }

    @Override
    public int getItemCount() {
        return workoutPlans.size();
    }

    public class WorkoutPlanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        WorkoutPlanLlistItemBinding itemBinding;
        public WorkoutPlanViewHolder(WorkoutPlanLlistItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding=itemBinding;
            itemBinding.getRoot().setOnClickListener( this );        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            listItemClickListiner.onListItemClick( workoutPlans.get(position) );
        }
    }
    public interface ListItemClickListiner{
        void onListItemClick(String workoutPlan);
    }
}
