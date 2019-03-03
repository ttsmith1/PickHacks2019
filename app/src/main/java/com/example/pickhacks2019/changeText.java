package com.example.pickhacks2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class changeText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_text);

        Intent intent = getIntent();
        ArrayList<String> input = intent.getStringArrayListExtra(MainActivity.EXTRA_MESSAGE);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setText(input.get(0));
        button2.setText(input.get(1));
        button3.setText(input.get(2));
        button4.setText(input.get(3));
        button5.setText(input.get(4));
    }
}
