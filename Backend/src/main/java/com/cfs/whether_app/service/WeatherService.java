package com.cfs.whether_app.service;

import com.cfs.whether_app.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apikey;

    @Value("${weather.api.url}")
    private String apiUrl;


    @Value("${weather.api.Forecast.url}")
    private String apiForecasturl;

    private final RestTemplate template = new RestTemplate();

    public String test() {
        return "good";
    }

    public WeatherResponse getData(String city) {
        String url = apiUrl + "?key=" + apikey + "&q=" + city;
        Root response = template.getForObject(url, Root.class);
        WeatherResponse weatherResponse = new WeatherResponse();
//        String c=response.getLocation().name;
//        String region=response.getLocation().region;
//        String country=response.getLocation().country;

        assert response != null;
        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().region);
        weatherResponse.setCountry(response.getLocation().country);
        String condition = response.getCurrent().getCondition().getText();
        weatherResponse.setCondition(condition);
        weatherResponse.setTemperature(String.valueOf(response.getCurrent().getTemp_c()));


        return weatherResponse;
    }

    public ForCast getForecast(String city, int days) {
        ForCast forCast = new ForCast();
        WeatherResponse weatherResponse = getData(city);
        ForCast response = new ForCast();
        response.setWeatherResponse(weatherResponse);


        List<DayTemp> dayList = new ArrayList<>();
        String url = apiForecasturl + "?key=" + apikey + "&q=" + city + "&days=" + days;
        Root Apiresponse = template.getForObject(url, Root.class);
        Forecast forecast = Apiresponse.getForecast();
        ArrayList<Forecastdays> forecastdays = forecast.getForecastday();
        for (Forecastdays rs : forecastdays)
        {
            DayTemp d = new DayTemp();
            d.setDate(rs.getDate());
            d.setMinTemp(rs.getDay().mintemp_c);
            d.setAvgTemp(rs.getDay().avgtemp_c);
            d.setMaxTemp(rs.getDay().maxtemp_c);
            dayList.add(d);

        }
        response.setDayTemp(dayList);
        return response;

    }
}
