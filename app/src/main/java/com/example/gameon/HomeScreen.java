package com.example.gameon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeScreen extends AppCompatActivity {
    private  Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ImageView back;
    private ImageView editprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        button1 = findViewById(R.id.badmintonBtn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this,BookingScreen.class);
                startActivity(i);
            }
        });
        button2 = findViewById(R.id.basketballBtn);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this,BookingScreen.class);
                startActivity(i);
            }
        });
        button3 = findViewById(R.id.cricketBtn);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this,BookingScreen.class);
                startActivity(i);
            }
        });
        button4 = findViewById(R.id.footballBtn);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this,BookingScreen.class);
                startActivity(i);
            }
        });
        back = findViewById(R.id.imageView16);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this,LoginScreen.class);
                startActivity(i);
            }
        });
        editprofile = findViewById(R.id.imageView13);

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this,UserProfile.class);
                startActivity(i);
            }
        });

    }
}