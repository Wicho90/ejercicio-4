package com.lochoa.ejercicio4.services;

import com.lochoa.ejercicio4.models.Laptop;
import com.lochoa.ejercicio4.repositories.LaptopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {

    private LaptopRepository repository;

    public LaptopServiceImpl(LaptopRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Laptop> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Laptop> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Laptop save(Laptop laptop) {
        return repository.save(laptop);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }


}
