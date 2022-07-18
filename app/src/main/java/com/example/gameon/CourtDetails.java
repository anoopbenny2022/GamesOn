package com.example.gameon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CourtDetails extends AppCompatActivity {
    private ImageView back;
    private Button startbooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_details);

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
                startActivity(i);
            }
        });

    }
}