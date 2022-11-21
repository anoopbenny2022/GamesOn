package mdev.project.gameon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FeedbackForm extends AppCompatActivity {
    public Button submit;

    private EditText emailAddress ;
    private EditText name ;
    private EditText feedback ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        submit = findViewById(R.id.btnSubmit);
        emailAddress = findViewById(R.id.emailId);
        name = findViewById(R.id.nameField);
        feedback = findViewById(R.id.feedback);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> feedbackData = new HashMap<>();
                feedbackData.put("email", emailAddress.getText().toString());
                feedbackData.put("name", name.getText().toString());
                feedbackData.put("feedback", feedback.getText().toString());

                db.collection("feedbacks").add(feedbackData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // after the data addition is successful
                        // we are displaying a success toast message.
                        Toast.makeText(FeedbackForm.this, "Your Feedback has been added !", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // this method is called when the data addition process is failed.
                        // displaying a toast message when data addition is failed.
                        Toast.makeText(FeedbackForm.this, "Fail to add feedback \n" + e, Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });




    }
}