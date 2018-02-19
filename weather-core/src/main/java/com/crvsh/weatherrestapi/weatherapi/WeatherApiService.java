package com.crvsh.weatherrestapi.weatherapi;

import com.crvsh.weatherrestapi.weatherapi.models.WeatherData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by resulkocyigit on 18/02/18.
 */
public interface WeatherApiService {

    @GET("/data/2.5/forecast?")
    Call<WeatherData> getCityWeather(@QueryMap Map<String, String> params);
}
