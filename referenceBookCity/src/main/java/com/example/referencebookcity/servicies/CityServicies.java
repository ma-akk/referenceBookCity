package com.example.referencebookcity.servicies;

import com.example.referencebookcity.data.InputData;
import com.example.referencebookcity.entity.City;
import com.example.referencebookcity.repository.CityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServicies {
    private final CityRepository cityRepository;
    private final InputData inputData;

    public CityServicies(CityRepository cityRepository, InputData inputData) {
        this.cityRepository = cityRepository;
        this.inputData = inputData;
    }

    private void saveData() {
        try {
            cityRepository.saveAll(inputData.inputCities());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitApp(ApplicationContext applicationContext) {
        SpringApplication.exit(applicationContext, ()->0);
    }

    public List<City> getCities() {
        saveData();
        return (cityRepository.findAll());
    }

    public List<City> sortByName() {
        saveData();
        return (cityRepository.findAll(Sort.by(Sort.Order.asc("name").ignoreCase())));
    }
}
