package com.bekerskyy.service;

import com.bekerskyy.domain.Packaging;
import com.bekerskyy.repository.PackagingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackagingService implements AbstractService<Packaging, Integer> {

    private final PackagingRepository packagingRepository;

    public PackagingService(PackagingRepository packagingRepository) {
        this.packagingRepository = packagingRepository;
    }

    @Override
    public List<Packaging> getAll() {
        return packagingRepository.findAll();
    }

    @Override
    public  Packaging getById(Integer id) {
        return packagingRepository.getOne(id);
    }

    @Override
    public Packaging create(Packaging packaging) {
        return packagingRepository.save(packaging);
    }

    @Override
    public Packaging update(Integer id, Packaging packaging) {
        if (packagingRepository.findById(id).isPresent()) {
            return packagingRepository.save(packaging);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (packagingRepository.findById(id).isPresent()) {
            packagingRepository.deleteById(id);
        }
    }
}

