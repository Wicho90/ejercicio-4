package com.lochoa.ejercicio4.repositories;

import com.lochoa.ejercicio4.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
