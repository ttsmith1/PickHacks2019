package com.example.pickhacks2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;

import java.util.List;

public class nutrientInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient_info);

        Intent intent = getIntent();
        String key = "34bf3bf5ff99445fbeec1f989f00e590";
        String secret = "5306f58f2a4b4a5db15a3e68d55cfeb2";
        FatsecretService service = new FatsecretService(key, secret);

        String query = intent.getStringExtra(changeText.EXTRA_MESSAGE); //Your query string
        Response<CompactFood> response = service.searchFoods(query);
        //This response contains the list of food items at zeroth page for your query

        List<CompactFood> results = response.getResults();
        //This list contains summary information about the food items

        TextView myTextView = findViewById(R.id.textView);
        myTextView.setText(results.get(0).getName() + "\n"+ results.get(0).getDescription());
    }
}
