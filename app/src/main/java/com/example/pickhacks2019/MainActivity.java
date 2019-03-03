package com.example.pickhacks2019;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import clarifai2.api.*;
import clarifai2.api.request.model.PredictRequest;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.ConceptModel;
import clarifai2.dto.model.Model;
import clarifai2.dto.model.ModelVersion;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;
import clarifai2.dto.prediction.Prediction;

public class MainActivity extends AppCompatActivity {
    public static final ClarifaiClient CLIENT = new ClarifaiBuilder("862144c5a9bc478c96d0d7bbf53547d7").buildSync();
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    protected void onClick1(View view){
        changeText(1);
    }

    protected void onClick2(View view){
        changeText(2);
    }

    protected void changeText(int val){
        Intent intent = new Intent(this, changeText.class);
        String link="";
        if(val == 1){
            link = "https://cdn.apartmenttherapy.info/image/fetch/f_auto,q_auto,w_600,h_750,c_fit,fl_strip_profile/https://s3.amazonaws.com/pixtruder/original_images/e3ce4eb1741bd76cc083424453c0e3f39d147f9b";
        }
        if(val == 2){
            link = "https://www.gretchensbakery.com/wp-content/uploads/2013/03/butter-3.jpg";
        }
        ConceptModel generalModel = CLIENT.getDefaultModels().generalModel();
        ModelVersion modelVersion = generalModel.getVersionByID("aa7f35c01e0642fda5cf400f543e7c40").executeSync().get();
        ClarifaiResponse<List<ClarifaiOutput<Prediction>>> response = CLIENT.predict(generalModel.id())
                .withInputs(ClarifaiInput.forImage(link))
                .withVersion(modelVersion).executeSync();
        String message = response.get().toString();
        String data = message.substring(message.indexOf("Concept{id="));
        ArrayList<String> arrStr = new ArrayList<String>();
        for(int i = 0; i < 5; i++){
            data = data.substring(data.indexOf("name"));
            arrStr.add(data.substring(data.indexOf("=") + 1, data.indexOf(',')));
            data = data.substring(data.indexOf(','));
        }
        intent.putExtra(EXTRA_MESSAGE, arrStr);
        startActivity(intent);
    }
}
