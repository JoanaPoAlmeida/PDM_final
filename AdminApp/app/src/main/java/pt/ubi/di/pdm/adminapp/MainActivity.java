package pt.ubi.di.pdm.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button bAdmin, bRegister, bLogin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //tira a barra superior
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        //if user is already logged in
        if(mAuth.getCurrentUser() != null){
            Intent myIntent = new Intent(getApplicationContext(), Initial_Page.class);
            startActivity(myIntent);
            finish();
        }

        setContentView(R.layout.activity_main);

        bAdmin = findViewById(R.id.btn_tomain);
        bAdmin.setOnClickListener(this::onClick);

        bRegister = findViewById(R.id.btnRegister);
        bRegister.setOnClickListener(this::onClick);

        bLogin = findViewById(R.id.btnLogin);
        bLogin.setOnClickListener(this::onClick);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_tomain:
                startActivity(new Intent(MainActivity.this,  Initial_Page.class));
                break;
            case R.id.btnRegister:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
            case R.id.btnLogin:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;

        }
    }
}