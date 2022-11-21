package mdev.project.gameon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private Button reset;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private EditText emailAddress ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        reset = findViewById(R.id.btnReset);

        emailAddress = findViewById(R.id.pwdReset);




        reset.setOnClickListener(v -> {
            String email = emailAddress.getText().toString().trim();
            auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("TAG", "Email sent.");
                                Toast.makeText(ForgotPassword.this,
                                        "Email Sent Successfully, Please Reset and Login",
                                        Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(ForgotPassword.this,LoginScreen.class);
                                startActivity(i);
                            }
                            else{
                                Log.d("TAG", "Email not sent.");
                                Toast.makeText(ForgotPassword.this,
                                        "Email was not sent, Please Check your Email ID",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        });

    }
}

