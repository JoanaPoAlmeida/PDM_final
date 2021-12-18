package pt.ubi.di.pmd.agrupame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private Button logout;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = (Button) findViewById(R.id.btnLogout);
        logout.setOnClickListener(this::onClick);

        mAuth = FirebaseAuth.getInstance();

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogout:
                mAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
                break;


        }
    }

}