package com.example.gameon;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpPage extends AppCompatActivity {
    private Button signup;
    private TextView login;

    EditText user_name, email_id, pass_word, cnf_pass;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpPage.this,LoginScreen.class);
                startActivity(i);
            }
        });



        //SIGN UP FEATURE

        user_name=findViewById(R.id.editTextTextPersonName);
        pass_word=findViewById(R.id.editTextPassword);
        cnf_pass=findViewById(R.id.editTextConfirmPassword);
        email_id=findViewById(R.id.editTextEmail);
        signup = findViewById(R.id.buttonSignUp);

        mAuth=FirebaseAuth.getInstance();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user_name.getText().toString().trim();
                String email = email_id.getText().toString().trim();
                String password= pass_word.getText().toString().trim();
                String cnfpassword= cnf_pass.getText().toString().trim();
                if(name.isEmpty())
                {
                    user_name.setError("Name is empty");
                    user_name.requestFocus();
                    return;
                }
                if(email.isEmpty())
                {
                    email_id.setError("Email is empty");
                    email_id.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    email_id.setError("Enter the valid email address");
                    email_id.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    pass_word.setError("Enter the password");
                    pass_word.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    pass_word.setError("Length of the password should be more than 6");
                    pass_word.requestFocus();
                    return;
                }
                if(!password.equals(cnfpassword))
                {
                    cnf_pass.setError("Password and Confirm Password Doesnt match");
                    cnf_pass.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUpPage.this,"You are successfully Registered! Please Login", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUpPage.this,LoginScreen.class);
                            startActivity(i);
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(name).build();

                            Log.i("DSJFh",name);
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {}
                                        }
                                    });
                        }
                        else
                        {
                            Toast.makeText(SignUpPage.this,"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }
}