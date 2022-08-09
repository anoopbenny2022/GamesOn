package com.example.gameon;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {
    private Button login;
    private TextView signup;

    private EditText email_id, pass_word;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        login = findViewById(R.id.button2);
        EditText inputEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText password_view= findViewById(R.id.editTextTextPassword);
        TextView forgot_password_view =findViewById(R.id.textView9) ;
        mAuth=FirebaseAuth.getInstance();
        forgot_password_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                /*FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                   // Log.d(LoginScreen.this, "Email sent.");
                                    Toast.makeText(LoginScreen.this, "Email sent successfully", Toast.LENGTH_SHORT).show();
                                }
                            }


                        });*/
                 if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }
                //progressBar.setVisibility(View.VISIBLE);

                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginScreen.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginScreen.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }
                    }});
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginScreen.this,HomeScreen.class);
                startActivity(i);
            }
        });
        Switch swi = findViewById(R.id.switch2);
        swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){

                    // show password
                    password_view.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    Log.i("checker", "true");
                }

                else{
                    Log.i("checker", "false");

                    // hide password
                    password_view.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

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
                            "Please check your login credentials",
                            Toast.LENGTH_SHORT).show();
                }

            });
        });


    }
}