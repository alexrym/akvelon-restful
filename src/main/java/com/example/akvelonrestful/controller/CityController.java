package com.example.akvelonrestful.controller;

import com.example.akvelonrestful.dao.CityRepository;
import com.example.akvelonrestful.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<City> getAllCities() {
        return cityRepository.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewCity(@RequestParam String name) {
        City city = new City(name);
        city.setName(name);
        cityRepository.save(city);
        return String.valueOf(ResponseEntity.ok("Completed"));
    }

}
