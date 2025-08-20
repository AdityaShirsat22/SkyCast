package com.cfs.whether_app.dto;

import java.util.ArrayList;

public class Forecast{
    public ArrayList<Forecastdays> forecastday;

    public ArrayList<Forecastdays> getForecastday() {
        return forecastday;
    }

    public void setForecastday(ArrayList<Forecastdays> forecastday) {
        this.forecastday = forecastday;
    }
}
