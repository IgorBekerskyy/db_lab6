package com.bekerskyy.controller;
import com.bekerskyy.domain.Good;
import com.bekerskyy.dto.GoodDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bekerskyy.service.GoodService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Good")
@RestController
public class GoodController {
    private final GoodService goodService;

    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<GoodDto>> getAll() {
        List<Good> goods = goodService.getAll();
        List<GoodDto> goodDtos = new ArrayList<>();
        for (Good good : goods) {
            GoodDto goodDto = new GoodDto(
                    good.getId(),
                    good.getName(),
                    good.getFirm(),
                    good.getDescription(),
                    good.getGuarantee_in_months(),
                    good.getResponse(),
                    good.getIn_Stock()
            );
            goodDtos.add(goodDto);
        }
        return new ResponseEntity<>(goodDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<GoodDto> getById(@PathVariable Integer id) {
        Good good = goodService.getById(id);
        if (good != null) {
            GoodDto goodDto = new GoodDto(
                    good.getId(),
                    good.getName(),
                    good.getFirm(),
                    good.getDescription(),
                    good.getGuarantee_in_months(),
                    good.getResponse(),
                    good.getIn_Stock()
            );
            return new ResponseEntity<>(goodDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Good newGood) {
        goodService.create(newGood);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<GoodDto> update(@PathVariable Integer id,
                                            @RequestBody Good good) {
        Good good1 = goodService.getById(id);
        if (good1 != null) {
            goodService.update(id, good);
            GoodDto goodDto = new GoodDto(
                    good.getId(),
                    good.getName(),
                    good.getFirm(),
                    good.getDescription(),
                    good.getGuarantee_in_months(),
                    good.getResponse(),
                    good.getIn_Stock()
            );
            return new ResponseEntity<>(goodDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (goodService.getById(id) != null) {
            goodService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
