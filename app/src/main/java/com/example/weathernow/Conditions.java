package com.example.weathernow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalTime;
import java.util.Calendar;

public class Conditions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);

        //display current date and time
        displayDateandTime();

    }

    public void displayDateandTime(){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat hourMinformat = new SimpleDateFormat("h:mm a");

        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        String currentTime = hourMinformat.format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.txtDate);
        TextView textViewTime = findViewById(R.id.txtCurrentTime);

        textViewDate.setText(currentDate);
        textViewTime.setText(currentTime);

    }

}