package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showGT(View view){
        EditText name = findViewById(R.id.editText);
        String nameValue = name.getText().toString();

        TextView carText = findViewById(R.id.carMessage);
        carText.setText("Your favorite car is a " + nameValue);

        ImageView changeGT = findViewById(R.id.imageView3);
        changeGT.setImageResource(R.drawable.newgt);

        TextView oldNew = findViewById(R.id.textView2);
        oldNew.setText("New GT");
    }
}
