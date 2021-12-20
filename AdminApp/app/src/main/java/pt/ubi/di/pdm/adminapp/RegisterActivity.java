package pt.ubi.di.pdm.adminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private ImageView imgVBanner;

    private EditText etFullName, etpassword, etConfirmPassword, etEmail;
    private Button ButtonRegister;

    private Register_pwd passwd;
    private String secure_password;
    private byte[] salt;

    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //tira a barra superior
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        etFullName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etpassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);



        //Banner to firstActivity
        imgVBanner = (ImageView) findViewById(R.id.banner);
        imgVBanner.setOnClickListener(this::onClick);


        //Register Button
        ButtonRegister = (Button) findViewById(R.id.btnRegister);
        ButtonRegister.setOnClickListener(this::onClick);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnRegister:
                registerUser();
                break;

        }
    }


    private void registerUser( ) {
        String FullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etpassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if(FullName.isEmpty()){
            etFullName.setError("Full Name is required");
            etFullName.requestFocus();
            return;
        }
        if(email.isEmpty()){
            etEmail.setError("email is required");
            etEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Please provide a valid email");
            etEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            etpassword.setError("Password is required");
            etpassword.requestFocus();
            return;
        }
        if(confirmPassword.isEmpty()){
            etConfirmPassword.setError("Password is required");
            etConfirmPassword.requestFocus();
            return;
        }
        if(!confirmPassword.equals(password)){
            etConfirmPassword.setError("Passwords do not match");
            etConfirmPassword.requestFocus();
            return;
        }
        if(password.length() < 6){
            etpassword.setError("Password should be 6 or more characters long");
            etpassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){


                            try {
                                passwd = new Register_pwd(email, password);
                                secure_password = passwd.getSecure_password();
                                salt = passwd.getSalt();
                            } catch (NoSuchProviderException e) {
                                e.printStackTrace();
                            } catch (NoSuchAlgorithmException e) {
                                e.printStackTrace();
                            }

                            User user = new User(FullName, email);

                            //Se autenticação for feita com sucesso adicionar dados do user a tabela users

                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if(task.isSuccessful()){

                                                //Connect to database and safe the email, salt and secure_password
                                                String last_email = passwd.getEmail();
                                                DatabaseReference mRef =  FirebaseDatabase.getInstance().getReference().child("PSecure_Password").child(last_email);
                                                mRef.child("email").setValue(email);
                                                mRef.child("salt").setValue(salt);
                                                mRef.child("secure_password").setValue(secure_password);


                                                Toast.makeText(RegisterActivity.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                                //Redirect to Login layout
                                                Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                                                startActivity(myIntent);
                                            }else{
                                                Toast.makeText(RegisterActivity.this, "Failed to register! Try Again!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(RegisterActivity.this, "Failed to register! Try Again!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


}