package com.bekerskyy.service;

import com.bekerskyy.domain.Good;
import com.bekerskyy.repository.GoodRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService implements AbstractService<Good, Integer> {

    private final GoodRepository goodRepository;

    public GoodService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @Override
    public List<Good> getAll() {
        return goodRepository.findAll();
    }

    @Override
    public  Good getById(Integer id) {
        return goodRepository.getOne(id);
    }

    @Override
    public Good create(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public Good update(Integer id, Good good) {
        if (goodRepository.findById(id).isPresent()) {
            return goodRepository.save(good);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (goodRepository.findById(id).isPresent()) {
            goodRepository.deleteById(id);
        }
    }
}
