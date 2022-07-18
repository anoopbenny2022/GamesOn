package com.example.gameon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BookingScreen extends AppCompatActivity implements View.OnClickListener{

    public CardView card1;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_screen);

        back = findViewById(R.id.imageView11);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookingScreen.this,HomeScreen.class);
                startActivity(i);
            }
        });

        card1 = (CardView) findViewById(R.id.c1);

        card1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){

            case R.id.c1:
                i = new Intent(this,CourtDetails.class);
                startActivity(i);
                break;
        }
    }
}