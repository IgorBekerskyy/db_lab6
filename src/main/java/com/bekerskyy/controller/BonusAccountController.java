package com.bekerskyy.controller;
import com.bekerskyy.domain.BonusAccount;
import com.bekerskyy.dto.BonusAccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bekerskyy.service.BonusAccountService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/BonusAccount")
@RestController
public class BonusAccountController {
    private final BonusAccountService bonusAccountService;

    public BonusAccountController(BonusAccountService bonusAccountService) {
        this.bonusAccountService = bonusAccountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BonusAccountDto>> getAll() {
        List<BonusAccount> bonusAccounts  = bonusAccountService.getAll();
        List<BonusAccountDto> bonusAccountDtos = new ArrayList<>();
        for (BonusAccount bonusAccount : bonusAccounts) {
            BonusAccountDto bonusAccountDto = new BonusAccountDto(
                    bonusAccount.getId(),
                    bonusAccount.getType(),
                    bonusAccount.getPromocode()
            );
            bonusAccountDtos.add(bonusAccountDto);
        }
        return new ResponseEntity<>(bonusAccountDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<BonusAccountDto> getById(@PathVariable Integer id) {
        BonusAccount bonusAccount = bonusAccountService.getById(id);
        if (bonusAccount != null) {
            BonusAccountDto bonusAccountDto = new BonusAccountDto(
                    bonusAccount.getId(),
                    bonusAccount.getType(),
                    bonusAccount.getPromocode()
            );
            return new ResponseEntity<>(bonusAccountDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody BonusAccount newBonusAccount) {
        bonusAccountService.create(newBonusAccount);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BonusAccountDto> update(@PathVariable Integer id,
                                              @RequestBody BonusAccount bonusAccount) {
        BonusAccount bonusAccount1 = bonusAccountService.getById(id);
        if (bonusAccount1 != null) {
            bonusAccountService.update(id, bonusAccount);
            BonusAccountDto bonusAccountDto = new BonusAccountDto(
                    bonusAccount.getId(),
                    bonusAccount.getType(),
                    bonusAccount.getPromocode()
            );
            return new ResponseEntity<>(bonusAccountDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (bonusAccountService.getById(id) != null) {
            bonusAccountService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
