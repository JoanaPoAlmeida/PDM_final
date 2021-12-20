package pt.ubi.di.pmd.agrupame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button logout, bCandidatar, bCandidaturas, bEquipas;


    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        mAuth = FirebaseAuth.getInstance();

        logout = (Button) findViewById(R.id.btnLogout);
        logout.setOnClickListener(this::onClick);

        bCandidatar = (Button) findViewById(R.id.btnCandidatura);
        bCandidatar.setOnClickListener(this::onClick);

        bCandidaturas = (Button) findViewById(R.id.btnVerCandidatura);
        bCandidaturas.setOnClickListener(this::onClick);

        bEquipas = (Button) findViewById(R.id.btnVerEquipas);
        bEquipas.setOnClickListener(this::onClick);


        final TextView greetingTextView = (TextView) findViewById(R.id.welcome);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);
                if(userprofile != null){
                    String fullname = userprofile.fullname;
                    greetingTextView.setText("Welcome, "+ fullname + "!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Metodo OnClick para dirigir o utilizador para as varias atividades

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogout:
                mAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
                break;
            case R.id.btnCandidatura:
                startActivity(new Intent(MainActivity.this, CandidatarActivity.class));
                break;
            case R.id.btnVerCandidatura:
                startActivity(new Intent(MainActivity.this, CandidaturasActivity.class));
                break;
            case R.id.btnVerEquipas:
                startActivity(new Intent(MainActivity.this, EquipasActivity.class));
                break;
        }
    }

}