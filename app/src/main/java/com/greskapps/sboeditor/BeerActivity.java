package com.greskapps.sboeditor;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BeerActivity extends AppCompatActivity {

    CheckBox checkBox_Beer01;
    TextView textView_Beer01;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBeerReference;
    private DatabaseReference avail_Beer01;
    private ChildEventListener cel_Beer01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBeerReference = mFirebaseDatabase.getReference().child("availability").child("beer");
        avail_Beer01 = mBeerReference.child("avail_Beer01");
        checkBox_Beer01 = findViewById(R.id.checkBox_Beer01);
        textView_Beer01 = findViewById(R.id.soldOut_Beer01);


        TextView eventMap = findViewById(R.id.tv_map);
        eventMap.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the View is clicked on.
            @Override
            public void onClick(View view) {
                Intent eventScheduleIntent = new Intent(BeerActivity.this, EventMapActivity.class);
                startActivity(eventScheduleIntent);
            }
        });
/*
        eventMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://drive.google.com/file/d/1qVPuPTLxCSXhr7ui1PS5PWIU9dXvyAnB/view"));
                startActivity(intent);
            }});
*/

/*

        checkBox_Beer01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBeerReference.push().setValue(checkBox_Beer01);
                if (!true) {
                    textView_Beer01.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer01.setVisibility(View.INVISIBLE);
                }
            }
        });
*/

    }

    @Override
    protected void onStart() {
        super.onStart();

        avail_Beer01.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer01.setChecked(b);
                if (b == false) {
                    textView_Beer01.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer01.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        checkBox_Beer01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (true) {
                    avail_Beer01.setValue(false);
                    textView_Beer01.setVisibility(View.VISIBLE);
                } else {
                    avail_Beer01.setValue(true);
                    textView_Beer01.setVisibility(View.INVISIBLE);
                }
            }
        });
        cel_Beer01 = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                dataSnapshot.getValue();
                if (true) {
                    checkBox_Beer01.setChecked(true);
                    textView_Beer01.setVisibility(View.INVISIBLE);
                } else {
                    checkBox_Beer01.setChecked(false);
                    textView_Beer01.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };
        avail_Beer01.addChildEventListener(cel_Beer01);

    }





}
