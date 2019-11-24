package com.example.myhealth.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealth.R;
import com.example.myhealth.databinding.HomeItemsBinding;

import java.util.Arrays;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context mContext;
    List<String> CategoryName=null;
    TypedArray CategoryImage=null;
    final private ListItemClickListiner listItemClickListiner;

    public HomeAdapter(@NonNull Context context,ListItemClickListiner listItemClickListiner) {
        mContext=context;
        this.listItemClickListiner=listItemClickListiner;
        CategoryName= Arrays.asList(mContext.getResources().getStringArray(R.array.category_name));
        CategoryImage=  (mContext.getResources().obtainTypedArray(R.array.category_image));
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        HomeItemsBinding homeItemsBinding = DataBindingUtil.inflate(inflater, R.layout.home_items,parent,false);
        return new HomeViewHolder( homeItemsBinding );
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
      holder.homeItemsBinding.imageView.setImageResource(CategoryImage.getResourceId(position,-1));
        holder.homeItemsBinding.textView.setText(CategoryName.get(position));
    }

    @Override
    public int getItemCount() {
        return CategoryName.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        HomeItemsBinding homeItemsBinding;
        public HomeViewHolder(@NonNull HomeItemsBinding homeItemsBinding) {
            super(homeItemsBinding.getRoot());
            this.homeItemsBinding=homeItemsBinding;
            homeItemsBinding.getRoot().setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            listItemClickListiner.onListItemClick( position,CategoryName.get(position) );
        }
    }

    public interface ListItemClickListiner{
        void onListItemClick(int clickedItemIndex,String CategoryName);
    }
}
