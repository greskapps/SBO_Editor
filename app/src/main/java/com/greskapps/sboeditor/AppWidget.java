package com.greskapps.sboeditor;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

/**
 * Implementation of App Widget functionality.
 */
public class AppWidget extends AppWidgetProvider {

    private FirebaseJobDispatcher mJobDispatcher;

/*
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBeerReference;
    private DatabaseReference avail_Beer01;
    private DatabaseReference avail_Beer02;
    private DatabaseReference avail_Beer03;
    private DatabaseReference avail_Beer04;
    private DatabaseReference avail_Beer05;
    private DatabaseReference avail_Beer06;
    private DatabaseReference avail_Beer07;
    private DatabaseReference avail_Beer08;
    private DatabaseReference avail_Beer09;
    private DatabaseReference avail_Beer10;
    private DatabaseReference avail_Beer11;

    TextView soldOut_Beer01;
    TextView soldOut_Beer02;
    TextView soldOut_Beer03;
    TextView soldOut_Beer04;
    TextView soldOut_Beer05;
    TextView soldOut_Beer06;
    TextView soldOut_Beer07;
    TextView soldOut_Beer08;
    TextView soldOut_Beer09;
    TextView soldOut_Beer10;
    TextView soldOut_Beer11;
*/


    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, BeerStatus beerStatus) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        CharSequence soldOutText = context.getString(R.string.out);
        if(!beerStatus.getAvail_Beer01()){
            views.setTextViewText(R.id.soldOut_Beer01, soldOutText);
        } else if (!beerStatus.getAvail_Beer02()) {
            views.setTextViewText(R.id.soldOut_Beer02, soldOutText);
        } else if (!beerStatus.getAvail_Beer03()) {
            views.setTextViewText(R.id.soldOut_Beer03, soldOutText);
        } else if (!beerStatus.getAvail_Beer04()) {
            views.setTextViewText(R.id.soldOut_Beer04, soldOutText);
        } else if (!beerStatus.getAvail_Beer05()) {
            views.setTextViewText(R.id.soldOut_Beer05, soldOutText);
        } else if (!beerStatus.getAvail_Beer06()) {
            views.setTextViewText(R.id.soldOut_Beer06, soldOutText);
        } else if (!beerStatus.getAvail_Beer07()) {
            views.setTextViewText(R.id.soldOut_Beer07, soldOutText);
        } else if (!beerStatus.getAvail_Beer08()) {
            views.setTextViewText(R.id.soldOut_Beer08, soldOutText);
        } else if (!beerStatus.getAvail_Beer09()) {
            views.setTextViewText(R.id.soldOut_Beer09, soldOutText);
        } else if (!beerStatus.getAvail_Beer10()) {
            views.setTextViewText(R.id.soldOut_Beer10, soldOutText);
        } else if (!beerStatus.getAvail_Beer11()) {
            views.setTextViewText(R.id.soldOut_Beer11, soldOutText);
        }
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    public static void updateAllWidgets(Context context, AppWidgetManager appWidgetManager,
                                        int[] appWidgetIds, BeerStatus beerStatus) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, beerStatus);
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        mJobDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));
        Job job = mJobDispatcher.newJobBuilder()
                .setService(AppWidgetJobService.class)
                .setTag(AppWidgetJobService.class.getSimpleName())
                .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
                .setRecurring(false)
                .setRetryStrategy(RetryStrategy.DEFAULT_LINEAR)
                .setReplaceCurrent(true)
                .setTrigger(Trigger.executionWindow(0, 900))
                .build();
        mJobDispatcher.mustSchedule(job);
        }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

