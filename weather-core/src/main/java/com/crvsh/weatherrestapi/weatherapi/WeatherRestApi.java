package com.crvsh.weatherrestapi.weatherapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by resulkocyigit on 18/02/18.
 */
public class WeatherRestApi {

    private WeatherApiService weatherService;

    public WeatherRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherService = retrofit.create(WeatherApiService.class);
    }

    public WeatherApiService getWeatherService(){
        return weatherService;
    }

}
