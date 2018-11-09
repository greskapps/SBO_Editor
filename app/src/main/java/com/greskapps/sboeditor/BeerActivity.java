package com.greskapps.sboeditor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BeerActivity extends AppCompatActivity {

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

    CheckBox checkBox_Beer01;
    CheckBox checkBox_Beer02;
    CheckBox checkBox_Beer03;
    CheckBox checkBox_Beer04;
    CheckBox checkBox_Beer05;
    CheckBox checkBox_Beer06;
    CheckBox checkBox_Beer07;
    CheckBox checkBox_Beer08;
    CheckBox checkBox_Beer09;
    CheckBox checkBox_Beer10;
    CheckBox checkBox_Beer11;

    TextView textView_Beer01;
    TextView textView_Beer02;
    TextView textView_Beer03;
    TextView textView_Beer04;
    TextView textView_Beer05;
    TextView textView_Beer06;
    TextView textView_Beer07;
    TextView textView_Beer08;
    TextView textView_Beer09;
    TextView textView_Beer10;
    TextView textView_Beer11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBeerReference = mFirebaseDatabase.getReference().child("availability").child("beer");
        avail_Beer01 = mBeerReference.child("avail_Beer01");
        avail_Beer02 = mBeerReference.child("avail_Beer02");
        avail_Beer03 = mBeerReference.child("avail_Beer03");
        avail_Beer04 = mBeerReference.child("avail_Beer04");
        avail_Beer05 = mBeerReference.child("avail_Beer05");
        avail_Beer06 = mBeerReference.child("avail_Beer06");
        avail_Beer07 = mBeerReference.child("avail_Beer07");
        avail_Beer08 = mBeerReference.child("avail_Beer08");
        avail_Beer09 = mBeerReference.child("avail_Beer09");
        avail_Beer10 = mBeerReference.child("avail_Beer10");
        avail_Beer11 = mBeerReference.child("avail_Beer11");

        checkBox_Beer01 = findViewById(R.id.checkBox_Beer01);
        checkBox_Beer02 = findViewById(R.id.checkBox_Beer02);
        checkBox_Beer03 = findViewById(R.id.checkBox_Beer03);
        checkBox_Beer04 = findViewById(R.id.checkBox_Beer04);
        checkBox_Beer05 = findViewById(R.id.checkBox_Beer05);
        checkBox_Beer06 = findViewById(R.id.checkBox_Beer06);
        checkBox_Beer07 = findViewById(R.id.checkBox_Beer07);
        checkBox_Beer08 = findViewById(R.id.checkBox_Beer08);
        checkBox_Beer09 = findViewById(R.id.checkBox_Beer09);
        checkBox_Beer10 = findViewById(R.id.checkBox_Beer10);
        checkBox_Beer11 = findViewById(R.id.checkBox_Beer11);

        textView_Beer01 = findViewById(R.id.soldOut_Beer01);
        textView_Beer02 = findViewById(R.id.soldOut_Beer02);
        textView_Beer03 = findViewById(R.id.soldOut_Beer03);
        textView_Beer04 = findViewById(R.id.soldOut_Beer04);
        textView_Beer05 = findViewById(R.id.soldOut_Beer05);
        textView_Beer06 = findViewById(R.id.soldOut_Beer06);
        textView_Beer07 = findViewById(R.id.soldOut_Beer07);
        textView_Beer08 = findViewById(R.id.soldOut_Beer08);
        textView_Beer09 = findViewById(R.id.soldOut_Beer09);
        textView_Beer10 = findViewById(R.id.soldOut_Beer10);
        textView_Beer11 = findViewById(R.id.soldOut_Beer11);

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
//  need to hook this up via AsyncTask for Capstone Project
//  URL for image = https://drive.google.com/file/d/1qVPuPTLxCSXhr7ui1PS5PWIU9dXvyAnB/view
        eventMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://drive.google.com/file/d/1qVPuPTLxCSXhr7ui1PS5PWIU9dXvyAnB/view"));
                startActivity(intent);
            }});
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
                if (!b) {
                    textView_Beer01.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer01.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer02.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer02.setChecked(b);
                if (!b) {
                    textView_Beer02.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer02.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer03.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer03.setChecked(b);
                if (!b) {
                    textView_Beer03.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer03.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer04.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer04.setChecked(b);
                if (!b) {
                    textView_Beer04.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer04.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer05.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer05.setChecked(b);
                if (!b) {
                    textView_Beer05.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer05.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer06.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer06.setChecked(b);
                if (!b) {
                    textView_Beer06.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer06.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer07.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer07.setChecked(b);
                if (!b) {
                    textView_Beer07.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer07.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer08.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer08.setChecked(b);
                if (!b) {
                    textView_Beer08.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer08.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer09.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer09.setChecked(b);
                if (!b) {
                    textView_Beer09.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer09.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer10.setChecked(b);
                if (!b) {
                    textView_Beer10.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer10.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        avail_Beer11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean b = dataSnapshot.getValue(Boolean.class);
                checkBox_Beer11.setChecked(b);
                if (!b) {
                    textView_Beer11.setVisibility(View.VISIBLE);
                } else {
                    textView_Beer11.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



        checkBox_Beer01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer01.isChecked()) {
                    avail_Beer01.setValue(true);
                } else {
                    avail_Beer01.setValue(false);
                }
            }
        });

        checkBox_Beer02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer02.isChecked()) {
                    avail_Beer02.setValue(true);
                } else {
                    avail_Beer02.setValue(false);
                }
            }
        });

        checkBox_Beer03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer03.isChecked()) {
                    avail_Beer03.setValue(true);
                } else {
                    avail_Beer03.setValue(false);
                }
            }
        });

        checkBox_Beer04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer04.isChecked()) {
                    avail_Beer04.setValue(true);
                } else {
                    avail_Beer04.setValue(false);
                }
            }
        });

        checkBox_Beer05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer05.isChecked()) {
                    avail_Beer05.setValue(true);
                } else {
                    avail_Beer05.setValue(false);
                }
            }
        });

        checkBox_Beer06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer06.isChecked()) {
                    avail_Beer06.setValue(true);
                } else {
                    avail_Beer06.setValue(false);
                }
            }
        });

        checkBox_Beer07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer07.isChecked()) {
                    avail_Beer07.setValue(true);
                } else {
                    avail_Beer07.setValue(false);
                }
            }
        });

        checkBox_Beer08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer08.isChecked()) {
                    avail_Beer08.setValue(true);
                } else {
                    avail_Beer08.setValue(false);
                }
            }
        });

        checkBox_Beer09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer09.isChecked()) {
                    avail_Beer09.setValue(true);
                } else {
                    avail_Beer09.setValue(false);
                }
            }
        });

        checkBox_Beer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer10.isChecked()) {
                    avail_Beer10.setValue(true);
                } else {
                    avail_Beer10.setValue(false);
                }
            }
        });

        checkBox_Beer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_Beer11.isChecked()) {
                    avail_Beer11.setValue(true);
                } else {
                    avail_Beer11.setValue(false);
                }
            }
        });


    }

}
