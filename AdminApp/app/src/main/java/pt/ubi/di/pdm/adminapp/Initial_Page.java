package pt.ubi.di.pdm.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class Initial_Page extends AppCompatActivity {

    private Button cEvent, sTeams, sEvent, cTeams, logout;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tira a barra superior
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_initial_page);


        mAuth = FirebaseAuth.getInstance();

        logout = (Button) findViewById(R.id.btnLogout);
        logout.setOnClickListener(this::onClick);


        cEvent = findViewById(R.id.btn_new_event);
        cEvent.setOnClickListener(this::onClick);

        cTeams = findViewById(R.id.btn_create_team);
        cTeams.setOnClickListener(this::onClick);

        sTeams = findViewById(R.id.btn_show_teams);
        sTeams.setOnClickListener(this::onClick);

        sEvent = findViewById(R.id.btn_show_events);
        sEvent.setOnClickListener(this::onClick);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogout:
                mAuth.getInstance().signOut();
                startActivity(new Intent(Initial_Page.this,MainActivity.class));
                break;
            case R.id.btn_new_event:
                startActivity(new Intent(Initial_Page.this,  CreateEvent.class));
                break;
            case R.id.btn_show_teams:
                startActivity(new Intent(Initial_Page.this,  ShowTeams.class));
                break;
            case R.id.btn_show_events:
                startActivity(new Intent(Initial_Page.this,  ShowEvents.class));
                break;
            case R.id.btn_create_team:
                startActivity(new Intent(Initial_Page.this,  CreateTeams.class));
        }
    }

}