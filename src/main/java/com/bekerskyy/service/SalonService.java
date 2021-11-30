package com.bekerskyy.service;

import com.bekerskyy.domain.Salon;
import com.bekerskyy.repository.SalonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService implements AbstractService<Salon, Integer> {

    private final SalonRepository salonRepository;

    public SalonService(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    @Override
    public List<Salon> getAll() {
        return salonRepository.findAll();
    }

    @Override
    public  Salon getById(Integer id) {
        return salonRepository.getOne(id);
    }

    @Override
    public Salon create(Salon salon) {
        return salonRepository.save(salon);
    }

    @Override
    public Salon update(Integer id, Salon salon) {
        if (salonRepository.findById(id).isPresent()) {
            return salonRepository.save(salon);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (salonRepository.findById(id).isPresent()) {
            salonRepository.deleteById(id);
        }
    }
}

