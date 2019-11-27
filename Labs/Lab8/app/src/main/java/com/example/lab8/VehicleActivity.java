package com.example.lab8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class VehicleActivity extends AppCompatActivity {

    private String vehicle;
    private String vehicleURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadWebSite(view);

            }
        });

        Intent intent = getIntent();
        vehicle = intent.getStringExtra("vehicleName");
        vehicleURL = intent.getStringExtra("vehicleURL");

        TextView messageView = findViewById(R.id.textView3);
        messageView.setText("You should drive " + vehicle);
    }
    private void loadWebSite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(vehicleURL));
        startActivity(intent);
    }

}
