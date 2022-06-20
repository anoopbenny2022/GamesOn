package com.example.gameon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BookingScreen extends AppCompatActivity implements View.OnClickListener{

    public CardView card1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_screen);

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