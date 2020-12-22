package com.bekerskyy.controller;
import com.bekerskyy.domain.Salon;
import com.bekerskyy.dto.SalonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bekerskyy.service.SalonService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Salon")
@RestController
public class SalonController {
    private final SalonService salonService;

    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SalonDto>> getAll() {
        List<Salon> salons = salonService.getAll();
        List<SalonDto> salonDtos = new ArrayList<>();
        for (Salon salon : salons) {
            SalonDto salonDto = new SalonDto(
                    salon.getId(),
                    salon.getName(),
                    salon.getPhone(),
                    salon.getSalon_head(),
                    salon.getCity_id(),
                    salon.getStreet_adress()
            );
            salonDtos.add(salonDto);
        }
        return new ResponseEntity<>(salonDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<SalonDto> getById(@PathVariable Integer id) {
        Salon salon = salonService.getById(id);
        if (salon != null) {
            SalonDto salonDto = new SalonDto(
                    salon.getId(),
                    salon.getName(),
                    salon.getPhone(),
                    salon.getSalon_head(),
                    salon.getCity_id(),
                    salon.getStreet_adress()
            );
            return new ResponseEntity<>(salonDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Salon newSalon) {
        salonService.create(newSalon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SalonDto> update(@PathVariable Integer id,
                                            @RequestBody Salon salon) {
        Salon salon1 = salonService.getById(id);
        if (salon1 != null) {
            salonService.update(id, salon);
            SalonDto salonDto = new SalonDto(
                    salon.getId(),
                    salon.getName(),
                    salon.getPhone(),
                    salon.getSalon_head(),
                    salon.getCity_id(),
                    salon.getStreet_adress()
            );
            return new ResponseEntity<>(salonDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (salonService.getById(id) != null) {
            salonService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

