package com.example.weathernow;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.FormattedNumberRange;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;


public class Conditions extends AppCompatActivity {
    String degreeSymbol = "°",
        apiKey = "4970dc8241ecfecae0efeeaaf46d7772",
        degrees = "imperial",
        city,
        state;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);
        getAPI();

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

    public void getAPI(){
        requestQueue = Volley.newRequestQueue(this);
        city = getIntent().getStringExtra("city");
        state = getIntent().getStringExtra("state");

       // String url = "api.openweathermap.org/data/2.5/weather?q="+searchedCity+"&"+searchedSate+"&units="+ degrees +"&appid="+apiKey
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&"+state+"&units="+degrees+"&appid="+apiKey;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    DecimalFormat decimalFormat = new DecimalFormat("##");

                    JSONObject object = response.getJSONObject("main");
                    int currentTemp = object.getInt("temp");
                    int currentHumidity = object.getInt("humidity");
                    int currentLowTemp = object.getInt("temp_min");
                    int currentHighTemp = object.getInt("temp_max");


                    TextView txtCurrentTemp = findViewById(R.id.txtCurrentTemp);
                    txtCurrentTemp.setText(decimalFormat.format(currentTemp)+degreeSymbol);

                    TextView txtCurrentHumidity = findViewById(R.id.txtCurrentHumidity);
                    txtCurrentHumidity.setText(decimalFormat.format(currentHumidity));

                    TextView txtCurrentLowTemp = findViewById(R.id.txtCurrentLowTemp);
                    txtCurrentLowTemp.setText(decimalFormat.format(currentLowTemp)+degreeSymbol);

                    TextView txtCurrentHighTemp = findViewById(R.id.txtCurrentHighTemp);
                    txtCurrentHighTemp.setText(decimalFormat.format(currentHighTemp)+degreeSymbol);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);


    }

}