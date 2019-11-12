package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    Switch photoSwitch = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageView gtImage = (ImageView) findViewById(R.id.imageView);
        final TextView textView = (TextView) findViewById(R.id.textView2);
        final Switch photoSwitch = (Switch) findViewById(R.id.switch1);
        Spinner fontSpin = (Spinner) findViewById(R.id.spinner);
        fontSpin.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.font_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSpin.setAdapter(adapter);


        if (photoSwitch != null) {
            photoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
//                help with this from https://tutorialwing.com/android-switch-tutorial-with-example/
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        gtImage.setImageResource(R.drawable.oldgt);
                        textView.setText("old gt");
                    }
                    else{
                        gtImage.setImageResource(R.drawable.newgt);
                        textView.setText("new gt");

                    }
                }
            });
        }

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setAllCaps(true);
                } else {
                    textView.setAllCaps(false);
                }
            }
        });

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final TextView textView = (TextView) findViewById(R.id.textView2);

        if(position == 0){
            textView.setTextSize(18);
        }
        else if(position == 1){
            textView.setTextSize(24);
        }
        else if(position == 2){
            textView.setTextSize(30);
        }
        else{
            textView.setTextSize(18);
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
//        final TextView textView = (TextView) findViewById(R.id.textView2);
//        textView.setTextSize(26);
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
//        RadioButton radioYes = (RadioButton) findViewById(R.id.radioButton);
//        RadioButton radioNo = (RadioButton) findViewById(R.id.radioButton);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    // Pirates are the best
                    Toast.makeText(getApplicationContext(),
                            "Great!",
                            Toast.LENGTH_SHORT).show();

                break;
            case R.id.radioButton2:
                if (checked)
                    Toast.makeText(getApplicationContext(),
                            "Bummer!",
                            Toast.LENGTH_SHORT).show();

                    break;
        }
    }


}




