package com.cfs.whether_app.controller;


import com.cfs.whether_app.dto.ForCast;
import com.cfs.whether_app.dto.Root;
import com.cfs.whether_app.dto.WeatherResponse;
import com.cfs.whether_app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin
public class Controller {

    @Autowired
    private  WeatherService service;

    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city){
        return service.test();
    }

    @GetMapping("/my/{city}")
    public WeatherResponse getWeather(@PathVariable String city){
        return service.getData(city);
    }

    @GetMapping("/forecast")
    public ForCast getForecast(@RequestParam String city, int days){

        return service.getForecast(city, days);
    }




}

