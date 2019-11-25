package com.example.myhealth.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
import com.example.myhealth.Constants;
import com.example.myhealth.R;
import com.example.myhealth.model.ExerciseDB;
import com.example.myhealth.ui.ExerciseDetailActivity;
import com.example.myhealth.ui.MainActivity;

public class ExerciseWidgetProvider extends AppWidgetProvider {

    static ExerciseDB exercises;
    static RemoteViews views;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        int randomNumber=(int)(Math.random()*1000);
        // Construct the RemoteViews object
        views = new RemoteViews( context.getPackageName(), R.layout.exercise_widget_provider);
        Intent serviceIntent=new Intent( context,ExerciseWidgetService.class );

        Bundle data=new Bundle(  );
        //to create new RecipeWidgetItemFactory every time list updated
        data.putInt( AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetId+randomNumber );
        //click on list items
        Intent clickIntent=new Intent( context,ExerciseWidgetProvider.class );
        clickIntent.setAction( Constants.ACTION_TOAST );
        PendingIntent clickPendingIntent=PendingIntent.getBroadcast( context,0,clickIntent,0 );

        if(exercises!=null) {
            data.putParcelable( Constants.SEND_EXERCISE, exercises  );
            serviceIntent.setData(Uri.fromParts(Constants.WIDGET_CONTENT, String.valueOf(appWidgetId+randomNumber), null));
            serviceIntent.putExtra(Constants.WIDGET_BUNDLE,data);
            serviceIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            context.sendBroadcast(serviceIntent);
            views.setRemoteAdapter( R.id.ingredient_widget_list, serviceIntent );
            views.setTextViewText( R.id.tv_exercise_name,exercises.getName() );
            views.setViewVisibility(  R.id.ingredient_widget_list, View.VISIBLE );
            views.setPendingIntentTemplate(  R.id.ingredient_widget_list,clickPendingIntent );
        }
        else{
            views.setViewVisibility( R.id.ingredient_widget_list, View.GONE );
        }
        Intent intent = new Intent( context, ExerciseDetailActivity.class );
        PendingIntent pendingIntent=PendingIntent.getActivity( context,0,intent,0 );
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            Bundle appWidgetOptions=appWidgetManager.getAppWidgetOptions( appWidgetId );
            resizeWidget( appWidgetOptions,views );
        }
        appWidgetManager.updateAppWidget( appWidgetId, views );

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget( context, appWidgetManager, appWidgetId );

        }
    }

    private static void resizeWidget(Bundle opetions, RemoteViews views){
        int minWdith=opetions.getInt( AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH );
        int minHeight=opetions.getInt( AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT );
        int maxWidth=opetions.getInt( AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH );
        int maxHeight=opetions.getInt( AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT );

        if(maxHeight>100 && minWdith>100){
            views.setViewVisibility( R.id.ingredient_widget_list, View.VISIBLE );
        }
        else{
            views.setViewVisibility( R.id.ingredient_widget_list,View.GONE );
        }

    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        RemoteViews views = new RemoteViews( context.getPackageName(), R.layout.exercise_widget_provider);
        resizeWidget( newOptions,views );
        appWidgetManager.updateAppWidget( appWidgetId,views );
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) { }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive( context, intent );
        if(intent.getAction().equals( AppWidgetManager.ACTION_APPWIDGET_UPDATE )) {
            exercises = intent.getParcelableExtra( Constants.SEND_EXERCISE );

            if(exercises!=null) {
                int ids[] = intent.getIntArrayExtra( AppWidgetManager.EXTRA_APPWIDGET_IDS );
                onUpdate( context, AppWidgetManager.getInstance( context ), ids );
            }
        }
        else if(intent.getAction().equals( Constants.ACTION_TOAST )){
            Intent launchActivity = new Intent(context, MainActivity.class);
            launchActivity.putExtra( Constants.SEND_EXERCISE,exercises );
            launchActivity.putExtra(Constants.OPEN_FROM_WDIGET,true);
            launchActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity( launchActivity );

        }
    }
}
