package com.zte.sunquan.demo.serialize;

import java.util.List;

/**
 * Created by 10184538 on 2017/2/21.
 */
public class Results {
    private String currentCity;
    private List<Weather> weather_data;

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public List<Weather> getWeather_data() {
        return weather_data;
    }

    public void setWeather_data(List<Weather> weather_data) {
        this.weather_data = weather_data;
    }

    @Override
    public String toString() {
        return "Results [currentCity=" + currentCity + ", weather_data="
                + weather_data + "]";
    }
}