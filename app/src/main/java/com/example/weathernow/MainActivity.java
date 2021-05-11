package com.example.weathernow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String currentCity;
    EditText searchCity;
    Spinner searchState;
    RadioButton rdCurrent;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdCurrent = findViewById(R.id.rdCurrent);
        searchCity = findViewById(R.id.txtCitySearch);
        searchState = findViewById(R.id.spnStates);
        btnSearch = findViewById(R.id.btnSearch);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Conditions.class);
                startActivity(intent);
            }
        });

        
    }



}