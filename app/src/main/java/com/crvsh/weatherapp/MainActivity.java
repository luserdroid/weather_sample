package com.crvsh.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.crvsh.weatherrestapi.weatherapi.WeatherApiService;
import com.crvsh.weatherrestapi.weatherapi.WeatherRestApi;
import com.crvsh.weatherrestapi.weatherapi.models.Details;
import com.crvsh.weatherrestapi.weatherapi.models.Weather;
import com.crvsh.weatherrestapi.weatherapi.models.WeatherData;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button startSearch;
    private EditText inputCityName;
    private TextView weatherDetailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputCityName = (EditText) findViewById(R.id.city_name);
        weatherDetailText = (TextView) findViewById(R.id.weather_data);

        startSearch = (Button) findViewById(R.id.start_search);
        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerWeatherSearch();
            }
        });
    }

    private void triggerWeatherSearch() {

        if(TextUtils.isEmpty(inputCityName.getText().toString())){
            inputCityName.setError("No city");
            return;
        }

        WeatherRestApi api = new WeatherRestApi();

        Map<String, String> params = new HashMap<>();
        params.put("q", inputCityName.getText().toString() + ",de");
        params.put("lang", "de");
        params.put("cnt", "1");
        params.put("units", "metric");
        params.put("appid", "12e39368b355566defe13e75d397890c");

        WeatherApiService service = api.getWeatherService();
        service.getCityWeather(params).enqueue(new retrofit2.Callback<WeatherData>() {

            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if(response.body() == null){
                    inputCityName.setError("Keine Ergebnisse");
                    return;
                }

                WeatherData weatherData = response.body();

                if(weatherData == null){
                    inputCityName.setError("Keine Wetterdaten");
                    return;
                }

                if(weatherData.getDetails() == null ||  weatherData.getDetails().size() == 0){
                    inputCityName.setError("Keine Wetterdaten");
                    return;
                }

                Details details = weatherData.getDetails().get(0);

                if(details == null){
                    inputCityName.setError("Keine Wetterdaten");
                    return;
                }

                Weather weather = details.getWeather().get(0);

                weatherDetailText.setText(
                        "" + weather.getDescription()+
                        "\n"+details.getMain().getTemp()+ " Grad"+
                        "\n"+details.getMain().getHumidity()+ "% Luftfeuchtigkeit"
                );
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                inputCityName.setError("Etwas lief schief bei der Anfrage!");

            }
        });
    }
}
