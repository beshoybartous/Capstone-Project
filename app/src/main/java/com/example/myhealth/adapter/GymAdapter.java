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
import com.example.myhealth.databinding.FragmentPlaceDetailBinding;
import com.example.myhealth.databinding.HomeItemsBinding;
import com.example.myhealth.model.GymPlaceDetailModel;
import com.example.myhealth.model.GymPlacesModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GymAdapter  extends RecyclerView.Adapter<GymAdapter.GymViewHolder>{
    final private ListItemClickListiner listItemClickListiner;
    private Context mContext;
    List<GymPlacesModel.ResultsBean> places;
    public GymAdapter(@NonNull Context context, ListItemClickListiner listItemClickListiner) {
        mContext=context;
        this.listItemClickListiner=listItemClickListiner;
        places=new ArrayList<>();
    }
    public void setPlaces(List<GymPlacesModel.ResultsBean> place){
        places=place;
    }
    @NonNull
    @Override
    public GymViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        FragmentPlaceDetailBinding placeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_place_detail,parent,false);
        return new GymAdapter.GymViewHolder( placeBinding );
    }

    @Override
    public void onBindViewHolder(@NonNull GymViewHolder holder, int position) {
        if (places.size() > 0) {


            holder.placeBinding.gymName.setText("Gym Name : " + places.get(position).getName());
            holder.placeBinding.gymAddress.setText("Address : " + places.get(position).getVicinity());

            if (places.get(position).getOpening_hours()!=null) {
                if(places.get(position).getOpening_hours().isOpen_now())
                holder.placeBinding.openhour.setText("Open Now");
                else {
                    holder.placeBinding.openhour.setText("Closed");
                }
            } else {
                holder.placeBinding.openhour.setText("Closed");
            }
            if (places.get(position).getRating() != null) {
                holder.placeBinding.rate.setText(String.valueOf(places.get(position).getRating()) + "/5");
            } else {
                holder.placeBinding.rate.setText("~/5");
            }
        }
    }

    @Override
    public int getItemCount() {
        if(places.size()>0)
            return places.size();
        else
            return 1;
    }

    public class GymViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        FragmentPlaceDetailBinding placeBinding;

        public GymViewHolder(@NonNull FragmentPlaceDetailBinding placeBinding) {
            super(placeBinding.getRoot());
            this.placeBinding=placeBinding;
            placeBinding.getRoot().setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            listItemClickListiner.onListItemClick(places.get(position));
        }
    }
    public interface ListItemClickListiner{
        void onListItemClick(GymPlacesModel.ResultsBean place);
    }
}
