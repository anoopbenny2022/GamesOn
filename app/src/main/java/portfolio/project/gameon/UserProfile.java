package portfolio.project.gameon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserProfile extends AppCompatActivity {
    private ImageView back;
    //private Button update;
    private Button feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        back = findViewById(R.id.imageView3);

        EditText email  = findViewById(R.id.editTextEmail);
        feedback = findViewById(R.id.buttonFeedback);
        EditText name  = findViewById(R.id.editTextTextPersonName);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserProfile.this,HomeScreen.class);
                startActivity(i);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserProfile.this,FeedbackForm.class);
                startActivity(i);
            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            email.setText(user.getEmail());
            name.setText(user.getDisplayName());
        } else {

        }

    }
}