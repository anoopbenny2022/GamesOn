package com.example.gameon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {
    private Button login;
    private TextView signup;
    private TextView frgtpass;

    private EditText email_id, pass_word;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        login = findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginScreen.this,HomeScreen.class);
                startActivity(i);
            }
        });

        signup = findViewById(R.id.textView2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginScreen.this,SignUpPage.class);
                startActivity(i);
            }
        });


        frgtpass = findViewById(R.id.textView9);
        frgtpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginScreen.this,ForgotPassword.class);
                startActivity(i);
            }
        });

        //LOGIN FUNCTIONALITY
        email_id=findViewById(R.id.editTextTextEmailAddress);
        pass_word=findViewById(R.id.editTextTextPassword);
        mAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(v -> {
            String email= email_id.getText().toString().trim();
            String password=pass_word.getText().toString().trim();
            if(email.isEmpty())
            {
                email_id.setError("Email is empty");
                email_id.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                email_id.setError("Enter the valid email");
                email_id.requestFocus();
                return;
            }
            if(password.isEmpty())
            {
                pass_word.setError("Password is empty");
                pass_word.requestFocus();
                return;
            }
            if(password.length()<6)
            {
                pass_word.setError("Length of password is more than 6");
                pass_word.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Intent i = new Intent(LoginScreen.this,HomeScreen.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(LoginScreen.this,
                            "Please Check Your login Credentials",
                            Toast.LENGTH_SHORT).show();
                }

            });
        });


    }
}