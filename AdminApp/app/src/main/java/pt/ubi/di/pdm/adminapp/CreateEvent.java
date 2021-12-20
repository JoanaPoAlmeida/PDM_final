package pt.ubi.di.pdm.adminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateEvent extends AppCompatActivity {

    // creating variables for
    // EditText and buttons.
    private EditText eventNameEdt, eventDateEdt, eventAddressEdt, eventParticEdt;
    private Button sendDatabtn;
    private TextView goBack;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    Event event1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tira a barra superior
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_create_event);
        //back button
        goBack = findViewById(R.id.tvBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateEvent.this,Initial_Page.class));
            }
        });
        // initializing our edittext and button
        eventNameEdt = findViewById(R.id.idEventName);
        eventDateEdt = findViewById(R.id.idEdtStartDate);
        eventAddressEdt = findViewById(R.id.idEdtEndDate);
        eventParticEdt = findViewById(R.id.idEdtNumParticip);

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("EventInfo");

        // initializing our object
        // class variable.
        event1 = new Event();

        sendDatabtn = findViewById(R.id.idBtnSendData);

        // adding on click listener for our button.
        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = eventNameEdt.getText().toString();
                String phone = eventDateEdt.getText().toString();
                String address = eventAddressEdt.getText().toString();
                String partic = eventParticEdt.getText().toString();

                // below line is for checking weather the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(address)&& TextUtils.isEmpty(partic)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(CreateEvent.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(name, phone, address, partic);
                }
            }
        });
    }

    private void addDatatoFirebase(String name, String phone, String address, String partic) {
        // below 3 lines of code is used to set
        // data in our object class.
        event1.setEventName(name);
        event1.setEventStartDate(phone);
        event1.setEventEndDate(address);
        event1.setEventPartic(partic);


        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(event1);

                // after adding this data we are showing toast message.
                Toast.makeText(CreateEvent.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(CreateEvent.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
