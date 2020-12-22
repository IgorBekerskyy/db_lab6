package com.bekerskyy.service;

import com.bekerskyy.domain.City;
import com.bekerskyy.repository.CityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements AbstractService<City, Integer> {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getById(Integer id) {
        return cityRepository.getOne(id);
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City update(Integer id, City city) {
        if (cityRepository.findById(id).isPresent()) {
            return cityRepository.save(city);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (cityRepository.findById(id).isPresent()) {
            cityRepository.deleteById(id);
        }
    }
}