package com.lochoa.ejercicio4.services;

import com.lochoa.ejercicio4.models.Laptop;

import java.util.List;
import java.util.Optional;

public interface LaptopService {

    List<Laptop> findAll();

    Optional<Laptop> findById(Long id);

    Laptop save(Laptop laptop);

    void delete(Long id);

    void deleteAll();

    boolean existsById(Long id);
}
