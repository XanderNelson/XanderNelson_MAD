package com.example.projecttwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        EditText textEmail = (EditText) findViewById(R.id.nameText);
        EditText textItem = (EditText) findViewById(R.id.wishItem);
        String email = textEmail.getText().toString();
        String item = textItem.getText().toString();


        Map<String, Object> wishList = new HashMap<>();
        wishList.put("NAME", email);
        wishList.put("ITEM", item);

// Add a new document with a generated ID
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
    }

}
