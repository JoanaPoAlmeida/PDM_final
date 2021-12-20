package pt.ubi.di.pmd.agrupame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CandidatarActivity extends AppCompatActivity {

    private TextView tvBack;


    DatabaseReference databaseReference;
    ListView lvEvents;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //tira a barra superior
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_candidatar);

        tvBack = (TextView) findViewById(R.id.tvBack);
        tvBack.setOnClickListener(this::OnClick);


        databaseReference = FirebaseDatabase.getInstance().getReference("Event");
        lvEvents = (ListView) findViewById(R.id.listViewEventos);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lvEvents.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value = snapshot.getValue().toString();
                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //Adicionar UID, Id_Evento a tabela "Candidatos" ----> Admin adicionará o id do grupo na tabela

    //Apresentar nome dos eventos numa listview clicavel (??? is that possible??)

    //Guardar seleçao do utilizador e adicionar a tabela Candidatos juntamente com o UID , pedir grupo ao admin

    public void OnClick(View v){
        switch(v.getId()){
            case R.id.tvBack:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
        }

    }

}