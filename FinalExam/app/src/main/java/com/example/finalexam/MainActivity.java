package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button build;
    private Button buttonFind;
    private EditText name;
    private TextView textBuild;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private ImageView image;
    private ToggleButton toggle;
    private Burrito myBurrito = new Burrito();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editText);
        spinner = findViewById(R.id.spinner);
        build = findViewById(R.id.button);
        textBuild = findViewById(R.id.textView2);
        radioGroup = findViewById(R.id.radioGroup);
        image = findViewById(R.id.imageView);
        toggle = findViewById(R.id.toggleButton);
        radioButton2 = findViewById(R.id.radioButton2);
        buttonFind = findViewById(R.id.button2);
        View.OnClickListener onClick = new View.OnClickListener(){
            public void onClick(View view){
                buildBurrito(view);
            }
        };
        View.OnClickListener onClick2 = new View.OnClickListener(){
            public void onClick(View view){
                findBurrito(view);
            }
        };
        build.setOnClickListener(onClick);
        buttonFind.setOnClickListener(onClick2);
    }

    private void findBurrito(View view){
        Integer burr = spinner.getSelectedItemPosition();
        myBurrito.setBurrito(burr);
        String suggestPlace = myBurrito.getBurrito();
        String suggestURL = myBurrito.getBurritoURL();
        Intent intent = new Intent(this, BurritoActivity.class);
        intent.putExtra("burritoName", suggestPlace);
        intent.putExtra("burritoURL", suggestURL);
        startActivity(intent);

    }

    private void buildBurrito(View view){
        String kind;

        if (radioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(MainActivity.this,
                    "Place choose between Taco or Burrito", Toast.LENGTH_LONG).show();
        }
        else
        {
            if(toggle.isChecked())
            {
                kind = "veggie";
            }
            else {

                kind = "meat";
            }
            String place = spinner.getSelectedItem().toString();





            int selected = radioGroup.getCheckedRadioButtonId();
            radioButton1 = findViewById(selected);
            String type = radioButton1.getText().toString();


            String name2 = name.getText().toString();
            if(radioButton2.isChecked()){
                image.setImageResource(R.drawable.burrito);
            }
            else{
                image.setImageResource(R.drawable.taco);
            }
            textBuild.setText(name2 + " wants a " + kind + " " + type +". You should eat on " + place);
        }

    }
}
