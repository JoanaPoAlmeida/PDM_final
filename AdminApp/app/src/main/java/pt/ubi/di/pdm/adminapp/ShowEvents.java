package pt.ubi.di.pdm.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ShowEvents extends AppCompatActivity {

    private TextView tvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_show_events);


        tvBack = (TextView) findViewById(R.id.tvBack);
        tvBack.setOnClickListener(this::OnClick);
    }

    public void OnClick(View v){
        switch(v.getId()){
            case R.id.tvBack:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
        }

    
    }
}