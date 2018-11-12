package com.greskapps.sboeditor;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

/**
 * Implementation of App Widget functionality.
 */
public class AppWidget extends AppWidgetProvider {

    private FirebaseJobDispatcher mJobDispatcher;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, BeerStatus beerStatus) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        CharSequence soldOutText = context.getString(R.string.out);
        if(!beerStatus.getAvail_Beer01()){
            views.setTextViewText(R.id.soldOut_Beer01, soldOutText);
        }
        if (!beerStatus.getAvail_Beer02()) {
            views.setTextViewText(R.id.soldOut_Beer02, soldOutText);
        }
        if (!beerStatus.getAvail_Beer03()) {
            views.setTextViewText(R.id.soldOut_Beer03, soldOutText);
        }
        if (!beerStatus.getAvail_Beer04()) {
            views.setTextViewText(R.id.soldOut_Beer04, soldOutText);
        }
        if (!beerStatus.getAvail_Beer05()) {
            views.setTextViewText(R.id.soldOut_Beer05, soldOutText);
        }
        if (!beerStatus.getAvail_Beer06()) {
            views.setTextViewText(R.id.soldOut_Beer06, soldOutText);
        }
        if (!beerStatus.getAvail_Beer07()) {
            views.setTextViewText(R.id.soldOut_Beer07, soldOutText);
        }
        if (!beerStatus.getAvail_Beer08()) {
            views.setTextViewText(R.id.soldOut_Beer08, soldOutText);
        }
        if (!beerStatus.getAvail_Beer09()) {
            views.setTextViewText(R.id.soldOut_Beer09, soldOutText);
        }
        if (!beerStatus.getAvail_Beer10()) {
            views.setTextViewText(R.id.soldOut_Beer10, soldOutText);
        }
        if (!beerStatus.getAvail_Beer11()) {
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
                .setTrigger(Trigger.NOW)
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

