package com.greskapps.sboeditor;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AppWidgetJobService extends JobService {

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        FirebaseDatabase mFirebaseDatabase = FBRealtimeDatabaseUtils.getDatabase();
        DatabaseReference mBeerStatusReference = mFirebaseDatabase.getReference().child("availability");
        DatabaseReference mBeerReference = mBeerStatusReference.child("beer");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    setupBeer(dataSnapshot.getValue(BeerStatus.class));
                }
                jobFinished(jobParameters, false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                jobFinished(jobParameters, false);
            }
        };
        mBeerReference.addListenerForSingleValueEvent(listener);
        return true;
    }

    private void setupBeer(BeerStatus beerStatus) {
        if(beerStatus == null) return;
        ComponentName widget = new ComponentName(this, AppWidget.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = manager.getAppWidgetIds(widget);
        AppWidget.updateAllWidgets(this, manager, appWidgetIds);
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}