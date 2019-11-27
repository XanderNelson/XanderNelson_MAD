package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner carSpinner;
    private VehicleSelect myVehicle = new VehicleSelect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carSpinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);

        View.OnClickListener onClick  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findCar(v);
            }
        };
        button.setOnClickListener(onClick);
    }

    private void findCar(View view){
        Integer type = carSpinner.getSelectedItemPosition();
        myVehicle.setVehicle(type);
        String suggestVehicle = myVehicle.getVehicle();
        String suggestVehicleURL = myVehicle.getVehicleURL();
        Log.i("Car:", suggestVehicle);
        Log.i("URL:", suggestVehicleURL);

        Intent intent = new Intent(this, VehicleActivity.class);
        intent.putExtra("vehicleName", suggestVehicle);
        intent.putExtra("vehicleURL", suggestVehicleURL);

    }
}
