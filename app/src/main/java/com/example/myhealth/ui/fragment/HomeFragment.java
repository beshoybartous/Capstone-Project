package com.example.myhealth.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.myhealth.Constants;
import com.example.myhealth.R;
import com.example.myhealth.adapter.HomeAdapter;
import com.example.myhealth.databinding.FragmnetHomeBinding;
import com.example.myhealth.ui.ExerciseActivity;

public class HomeFragment extends Fragment implements HomeAdapter.ListItemClickListiner{
    FragmnetHomeBinding fragmnetHomeBinding;
    HomeAdapter homeAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmnetHomeBinding = DataBindingUtil.
                inflate( inflater, R.layout.fragmnet_home, container, false );
        homeAdapter=new HomeAdapter(getContext(), HomeFragment.this);
        int columnNumber= calculateNoOfColumns( getContext() );
        fragmnetHomeBinding.rvHome.setLayoutManager( new GridLayoutManager( getContext(),3 ) );
        fragmnetHomeBinding.rvHome.getLayoutManager().scrollToPosition(0);
        fragmnetHomeBinding.rvHome.setAdapter( homeAdapter );
        final View rootView =fragmnetHomeBinding.getRoot();
        return rootView;

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

    @Override
    public void onListItemClick(int clickedItemIndex,String CategoryName) {
        Intent newIntent =new Intent(getActivity(), ExerciseActivity.class);
        newIntent.putExtra(Constants.MUSCLE_NAME,CategoryName);
        startActivity(newIntent);
    }
}
