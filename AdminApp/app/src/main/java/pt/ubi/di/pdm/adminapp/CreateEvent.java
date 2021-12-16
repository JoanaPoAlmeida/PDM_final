package pt.ubi.di.pdm.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class CreateEvent extends AppCompatActivity {
    String nameEvent = "";
    String numberParticipants="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Button createEvent;
        EditText eveName;
        EditText numPartic;
        TextView m;

        super.onCreate(savedInstanceState);
        //tira a barra superior
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        eveName = findViewById(R.id.et_eventName);
        numPartic = findViewById(R.id.btn_numParticipantes);


        setContentView(R.layout.activity_create_event);
        //button to create event
        createEvent = findViewById(R.id.btnCreateEvent);
        mostrar = findViewById(R.id.textView2);

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEvent = eveName.getText().toString();
                numberParticipants = numPartic.getText().toString();
                mostrar.setText("ola");
            }
        });

    }
}