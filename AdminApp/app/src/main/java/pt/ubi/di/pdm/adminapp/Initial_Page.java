package pt.ubi.di.pdm.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class Initial_Page extends AppCompatActivity {

    private Button cEvent;
    private Button sTeams;
    private Button sEvent;
    private Button cTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tira a barra superior
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_initial_page);
        cEvent = findViewById(R.id.btn_new_event);
        cTeams = findViewById(R.id.btn_create_team);
        sTeams = findViewById(R.id.btn_show_teams);
        sEvent = findViewById(R.id.btn_show_events);

        cEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Initial_Page.this,  CreateEvent.class));
            }
        });
        sTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Initial_Page.this,  ShowTeams.class));
            }
        });
        sEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Initial_Page.this,  ShowEvents.class));
            }
        });
        cTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Initial_Page.this,  CreateTeams.class));
            }
        });
    }
}