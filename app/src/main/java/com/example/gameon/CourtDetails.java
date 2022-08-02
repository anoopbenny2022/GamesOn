package com.example.gameon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CourtDetails extends AppCompatActivity {
    private ImageView back;
    private Button startbooking;
    String name;
    String state;
    String about;
    TextView text1;
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_details);
        name = getIntent().getStringExtra("Name");
        state = getIntent().getStringExtra("State");
        about = getIntent().getStringExtra("About");
        text1= findViewById(R.id.textView);
        text2= findViewById(R.id.textView8);
        text1.setText(name + ", " + state);
        text2.setText(about);
        back = findViewById(R.id.imageView4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourtDetails.this,BookingScreen.class);
                startActivity(i);
            }
        });

        startbooking = findViewById(R.id.button);

        startbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CourtDetails.this,BookingCourt.class);
                i.putExtra("Name",name);
                i.putExtra("About", about);
                i.putExtra("State", state);
                startActivity(i);
            }
        });

    }
}