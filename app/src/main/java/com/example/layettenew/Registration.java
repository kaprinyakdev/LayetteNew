package com.example.layettenew;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText register_email, register_pwd;
    Button registration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        register_email = findViewById(R.id.register_email);
        register_pwd = findViewById(R.id.register_pwd);
        registration = findViewById(R.id.registration);

        mAuth = FirebaseAuth.getInstance();

        registration.setOnClickListener(v -> {
            registerUser();
        });

    }

    private void registerUser(){
        String email = register_email.getText().toString();
        String pwd = register_pwd.getText().toString();
        mAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                User user = new User(email, pwd);

                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Registration.this,"OK",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Registration.this,"NOT OK",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }
}
