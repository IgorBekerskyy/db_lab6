package com.bekerskyy.controller;
import com.bekerskyy.domain.City;
import com.bekerskyy.dto.CityDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bekerskyy.service.CityService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/City")
@RestController
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CityDto>> getAll() {
        List<City> cities  = cityService.getAll();
        List<CityDto> cityDtos = new ArrayList<>();
        for (City city : cities) {
            CityDto cityDto = new CityDto(
                    city.getId(),
                    city.getName(),
                    city.getRegion_name()
            );
            cityDtos.add(cityDto);
        }
        return new ResponseEntity<>(cityDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable Integer id) {
        City city = cityService.getById(id);
        if (city != null) {
            CityDto cityDto = new CityDto(
                    city.getId(),
                    city.getName(),
                    city.getRegion_name()
            );
            return new ResponseEntity<>(cityDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody City newCity) {
        cityService.create(newCity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CityDto> update(@PathVariable Integer id,
                                                  @RequestBody City city) {
        City city1 = cityService.getById(id);
        if (city1 != null) {
            cityService.update(id, city);
            CityDto cityDto = new CityDto(
                    city.getId(),
                    city.getName(),
                    city.getRegion_name()
            );
            return new ResponseEntity<>(cityDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (cityService.getById(id) != null) {
            cityService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
