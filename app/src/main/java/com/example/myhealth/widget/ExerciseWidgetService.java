package com.example.myhealth.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.myhealth.Constants;
import com.example.myhealth.R;
import com.example.myhealth.model.ExerciseDB;


public class ExerciseWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RecipeWidgetItemFactory(getApplicationContext(),intent);
    }

    class RecipeWidgetItemFactory implements RemoteViewsFactory{
        private Context context;
        ExerciseDB exercises;
        Intent intent;
        int AppWidgetId;
        RecipeWidgetItemFactory(Context context,Intent intent){
            this.context=context;
            this.intent=intent;
            AppWidgetId  = Integer.valueOf(intent.getData().getSchemeSpecificPart());
            Bundle b=intent.getBundleExtra( "Bundle1" );
            this.exercises=b.getParcelable(Constants.SEND_EXERCISE);
        }
        @Override
        public void onCreate() {
        }

        @Override
        public void onDataSetChanged() {
        }

        @Override
        public void onDestroy() {
        }

        @Override
        public int getCount() {
                return 1;
        }
        //like bindviewholder
        @Override
        public RemoteViews getViewAt(int i) {
            RemoteViews views=new RemoteViews( context.getPackageName(), R.layout.exercise_widget_items);
            if(exercises!=null) {
                views.setTextViewText( R.id.tv_exercise_data,
                        "Target Muscle : "+exercises.getMuscle()+"\n\n"+"Steps : "+exercises.getInstructionExecution()+"\n"+exercises.getInstructionPreparation()
                        +"\n\n"+"Notes : "+exercises.getComment()
                                );
                Glide.with(getApplicationContext()).asBitmap().load(Uri.parse(exercises.getGifUrl())).apply(RequestOptions.circleCropTransform())
                        .override(300, 300).fitCenter().into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        views.setImageViewBitmap(R.id.iv_exercise_image,resource);
                    }
                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }
                });
                Intent fillIntent=new Intent(  );
                fillIntent.putExtra(Constants.EXTRA_ITEM_POSITION,i);
                views.setOnClickFillInIntent( R.id.tv_exercise_data,fillIntent );
            }
            return views;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
