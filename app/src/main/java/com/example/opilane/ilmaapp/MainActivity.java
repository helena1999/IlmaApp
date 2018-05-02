package com.example.opilane.ilmaapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView cityField, detailsField, currentTemperatureField, humadity_field, weatherIcon, updateField, pressureField;
    Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");
        cityField = findViewById(R.id.city_field);
        updateField = findViewById(R.id.updated_field);
        detailsField = findViewById(R.id.details_field);
        currentTemperatureField = findViewById(R.id.current_temperature_field);
        humadity_field = findViewById(R.id.humidity_field);
        pressureField = findViewById(R.id.pressure_field);
        weatherIcon = findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);
    }
    Function.placeIdTask asyncTask = new Function.placeIdTask(new Function.AsyncResponse() {
        @Override
        public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humadity, String weather_pressure, String weather_updateOn, String weather_iconText, String sun_rise) {

            cityField.setText(weather_city);
            updateField.setText(weather_updateOn);
            detailsField.setText(weather_description);
            currentTemperatureField.setText(weather_temperature);
            humadity_field.setText("Humadity: " + weather_humadity);
            pressureField.setText("Pressure: " + weather_pressure);
            weatherIcon.setText(Html.fromHtml(weather_iconText));

        }
    });
    asyncTask.execute("59.4370", "24.7536");
}
