package com.bekerskyy.service;

import com.bekerskyy.domain.BonusAccount;
import com.bekerskyy.repository.BonusAccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusAccountService implements AbstractService <BonusAccount, Integer> {

    private final BonusAccountRepository bonusAccountRepository;

    public BonusAccountService(BonusAccountRepository bonusAccountRepository) {
        this.bonusAccountRepository = bonusAccountRepository;
    }

    @Override
    public List<BonusAccount> getAll() {
        return bonusAccountRepository.findAll();
    }

    @Override
    public BonusAccount getById(Integer id) {
        return bonusAccountRepository.getOne(id);
    }

    @Override
    public BonusAccount create(BonusAccount bonusAccount) {
        return bonusAccountRepository.save(bonusAccount);
    }

    @Override
    public BonusAccount update(Integer id, BonusAccount bonusAccount) {
        if (bonusAccountRepository.findById(id).isPresent()) {
            return bonusAccountRepository.save(bonusAccount);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (bonusAccountRepository.findById(id).isPresent()) {
            bonusAccountRepository.deleteById(id);
        }
    }
}
