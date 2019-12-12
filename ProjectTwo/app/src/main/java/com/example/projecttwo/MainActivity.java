package com.example.projecttwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


//sources
//        help from https://firebase.google.com/docs/firestore/manage-data/add-data and all of the firebase documentation in general


public class MainActivity extends AppCompatActivity {


//    public static final String NAME = "name";
//    public static final String WISH = "wish";
//    public static final String TAG1 = "listItem";
//    private DocumentReference myDoc = FirebaseFirestore.getInstance().document("wishList/test");
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "MainActivity";
//    EditText textFirst = findViewById(R.id.firstNameText);
//    EditText textLast = findViewById(R.id.lastNameText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState != null){
//            firstNam = savedInstanceState.getString("FirstName");
//            lastNam = savedInstanceState.getString("LastName");
//            textFirst.setText(firstNam);
//            textLast.setText(lastNam);
//        }
    }

//    psuedo
//        add more user imputs that clarify more what the wish is
//        use these imputs to write to firebase
//        do it the same way that the current imputs are
//        declare new objects and send them into firebase
//
//
//           **** web psuedo
//                    pull in database
//                    pull user imput with submit
//                    cycle through database to find user input name
//
//                    if database name == input name (find this with JSON data)
//                        display that users list
//
    public void addWish(View view){
//        Toast.makeText(this, "Called", Toast.LENGTH_LONG).show();

        EditText textFirst = findViewById(R.id.firstNameText);
        EditText textLast = findViewById(R.id.lastNameText);
        EditText textItem = findViewById(R.id.wishItem);
        EditText textLink = findViewById(R.id.textLink);
        Spinner priceSpin = findViewById(R.id.spinner);
        RadioGroup desGroup = findViewById(R.id.radioGroup);
        int selectedDesireNum = desGroup.getCheckedRadioButtonId();

        String firstName = textFirst.getText().toString();
        String lastName = textLast.getText().toString();
        String item = textItem.getText().toString();
        String link = textLink.getText().toString();
        String price = priceSpin.getSelectedItem().toString();
        RadioButton selectedRadioButton = (RadioButton) findViewById(selectedDesireNum);
        String selectedDesire = selectedRadioButton.getText().toString();


        Map<String, Object> wishList = new HashMap<>();
        wishList.put("FIRSTNAME", firstName);
        wishList.put("LASTNAME", lastName);
        wishList.put("ITEM", item);
        wishList.put("LINK", link);
        wishList.put("PRICE", price);
        wishList.put("DESIRE", selectedDesire);

        db.collection("wishList")
                .add(wishList)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
        textItem.setText("");
        textLink.setText("");
    }
//    String firstNam = textFirst.getText().toString();
//    String lastNam = textLast.getText().toString();
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("FirstName", firstNam);
//        outState.putString("LastName", lastNam);
//    }
}
