package pt.ubi.di.pmd.agrupame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EquipasActivity extends AppCompatActivity {

    private TextView tvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipas);

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