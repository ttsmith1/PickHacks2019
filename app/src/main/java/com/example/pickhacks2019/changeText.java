package com.example.pickhacks2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.CompactRecipe;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Recipe;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import com.fatsecret.platform.services.android.Request;
import com.fatsecret.platform.services.android.ResponseListener;

import java.util.ArrayList;
import java.util.List;

public class changeText extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

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

        button1.setOnClickListener(this::onClick1);
        button2.setOnClickListener(this::onClick2);
        button3.setOnClickListener(this::onClick3);
        button4.setOnClickListener(this::onClick4);
        button5.setOnClickListener(this::onClick5);
    }

    protected void onClick1(View view){
        Button button1 = findViewById(R.id.button1);
        showNutrients((String)button1.getText());
    }
    protected void onClick2(View view){
        Button button1 = findViewById(R.id.button2);
        showNutrients((String)button1.getText());
    }
    protected void onClick3(View view){
        Button button1 = findViewById(R.id.button3);
        showNutrients((String)button1.getText());
    }
    protected void onClick4(View view){
        Button button1 = findViewById(R.id.button4);
        showNutrients((String)button1.getText());
    }
    protected void onClick5(View view){
        Button button1 = findViewById(R.id.button5);
        showNutrients((String)button1.getText());
    }

    protected void showNutrients(String str){
        Intent intent = new Intent(this, nutrientInfo.class);
        intent.putExtra(EXTRA_MESSAGE, str);
        startActivity(intent);
    }

}
