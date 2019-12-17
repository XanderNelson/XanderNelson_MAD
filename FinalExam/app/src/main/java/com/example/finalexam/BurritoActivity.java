package com.example.finalexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class BurritoActivity extends AppCompatActivity {
    private String burrito;
    private String burritoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burrito);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebsite(view);
            }
        });
        Intent intent = getIntent();
        burrito = intent.getStringExtra("burritoName");
        burritoURL = intent.getStringExtra("burritoURL");
        TextView messageView = findViewById(R.id.textView3);
        messageView.setText("You should check out " + burrito);
    }

    private void loadWebsite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(burritoURL));
        startActivity(intent);
    }

}
