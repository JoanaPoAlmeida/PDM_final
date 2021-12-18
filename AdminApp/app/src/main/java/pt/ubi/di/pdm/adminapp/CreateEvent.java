package pt.ubi.di.pdm.adminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class CreateEvent extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    int maxid=0;
    Event event;





    DatePickerDialog picker;
    DatePickerDialog picker1;

    EditText nameEveEditText;
    EditText particEditText;
    EditText endDate;
    EditText startDate;
    Button addEve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tira a barra superior
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_create_event);


        nameEveEditText=(EditText) findViewById(R.id.et_nameEve);
        particEditText= (EditText) findViewById(R.id.et_numPartic);
        startDate=(EditText) findViewById(R.id.et_startDate);
        startDate.setInputType(InputType.TYPE_NULL);
        endDate=(EditText) findViewById(R.id.et_endDate);
        endDate.setInputType(InputType.TYPE_NULL);
        addEve=(Button) findViewById(R.id.btn_addEve);

        event = new Event();
        ref = database.getInstance().getReference().child("Event");
/*
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //if(DataSnapshot.exists()){
                    //if(DataSnapshot.exists()){
                    //maxid = (int) DataSnapshot.getChildrenCount();
                }else{

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

*/
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(CreateEvent.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                endDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker1 = new DatePickerDialog(CreateEvent.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                startDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker1.show();
            }
        });
        addEve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.setName(nameEveEditText.getText().toString());
                event.setNumParticipantes(particEditText.getText().toString());
                event.setDataInicio(startDate.getText().toString());
                event.setDataFim(endDate.getText().toString());

                ref.child(String.valueOf(maxid+1)).setValue(event);
            }
        });
    }

}







