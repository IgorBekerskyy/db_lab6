package com.bekerskyy.controller;
import com.bekerskyy.domain.Packaging;
import com.bekerskyy.dto.PackagingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bekerskyy.service.PackagingService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Packaging")
@RestController
public class PackagingController {
    private final PackagingService packagingService;

    public PackagingController(PackagingService packagingService) {
        this.packagingService = packagingService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PackagingDto>> getAll() {
        List<Packaging> packagings  = packagingService.getAll();
        List<PackagingDto> packagingDtos = new ArrayList<>();
        for (Packaging packaging : packagings) {
            PackagingDto packagingDto = new PackagingDto(
                    packaging.getId(),
                    packaging.getName(),
                    packaging.getFor_a_gift()
            );
            packagingDtos.add(packagingDto);
        }
        return new ResponseEntity<>(packagingDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<PackagingDto> getById(@PathVariable Integer id) {
        Packaging packaging = packagingService.getById(id);
        if (packaging != null) {
            PackagingDto packagingDto = new PackagingDto(
                    packaging.getId(),
                    packaging.getName(),
                    packaging.getFor_a_gift()
            );
            return new ResponseEntity<>(packagingDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Packaging newPackaging) {
        packagingService.create(newPackaging);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PackagingDto> update(@PathVariable Integer id,
                                          @RequestBody Packaging packaging) {
        Packaging packaging1 = packagingService.getById(id);
        if (packaging1 != null) {
            packagingService.update(id, packaging);
            PackagingDto packagingDto = new PackagingDto(
                    packaging.getId(),
                    packaging.getName(),
                    packaging.getFor_a_gift()
            );
            return new ResponseEntity<>(packagingDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (packagingService.getById(id) != null) {
            packagingService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

