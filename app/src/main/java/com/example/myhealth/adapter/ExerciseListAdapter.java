package com.example.myhealth.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myhealth.R;
import com.example.myhealth.databinding.ExerciseListItemBinding;
import com.example.myhealth.model.ExerciseDB;

import java.util.ArrayList;
import java.util.List;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseListViewHolder>{
    Context mContext;
    List<ExerciseDB> exercises;
    boolean workout=false;
    final private ListItemClickListiner listItemClickListiner;

    public ExerciseListAdapter(Context context,ListItemClickListiner listItemClickListiner) {
        mContext=context;
        exercises=new ArrayList<>();
        this.listItemClickListiner=listItemClickListiner;
    }

    public void setExercises(List<ExerciseDB> exercises){
        this.exercises=exercises;
    }

    public List<ExerciseDB> getExercises(){
        return exercises;
    }
    public void setWorkout(boolean workout){
        this.workout=workout;
    }
    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ExerciseListItemBinding exerciseListItemBinding =
                DataBindingUtil.inflate(inflater, R.layout.exercise_list_item,parent,false);
        return new ExerciseListAdapter.ExerciseListViewHolder( exerciseListItemBinding );

    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListViewHolder holder, int position) {

        holder.exerciseListItemBinding.name.setText(exercises.get(position).getName());
        holder.exerciseListItemBinding.muscle.setText(exercises.get(position).getMuscle());

        Glide.with(mContext).asGif().load(Uri.parse(exercises.get(position).getGifUrl()) ).
        apply(RequestOptions.circleCropTransform())
                .override(300, 300).fitCenter().circleCrop().into(holder.exerciseListItemBinding.imageView2);
        holder.exerciseListItemBinding.imageView2.setContentDescription(exercises.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ExerciseListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ExerciseListItemBinding exerciseListItemBinding;
        public ExerciseListViewHolder(@NonNull ExerciseListItemBinding itemView) {
            super(itemView.getRoot());
            exerciseListItemBinding=itemView;
            itemView.getRoot().setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            listItemClickListiner.onListItemClick( exercises.get(position) );
        }
    }

    public interface ListItemClickListiner{
        void onListItemClick(ExerciseDB exercise);
    }
}
