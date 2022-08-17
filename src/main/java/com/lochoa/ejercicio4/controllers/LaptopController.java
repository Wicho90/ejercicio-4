package com.lochoa.ejercicio4.controllers;

import com.lochoa.ejercicio4.models.Laptop;
import com.lochoa.ejercicio4.services.LaptopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/laptops")
public class LaptopController {

    private LaptopService service;


    public LaptopController(LaptopService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Laptop>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findOneById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = service.findById(id);
        if (laptopOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe laptop con id " + id);
        }
        return ResponseEntity.ok(laptopOpt.get());

    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Laptop laptop) {

        if (laptop.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El método crear no debe tener id");
        }

        try {
          return ResponseEntity.status(HttpStatus.CREATED).body(service.save(laptop));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }

    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null || laptop.getId() < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El método editar debe tener un id valido mayor a 0");
        }

        if (!service.existsById(laptop.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id: " + laptop.getId() + " no se encuentra en la base de datos");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(laptop));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id: " + id + " no se encuentra en la base de datos");
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAll() {
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }




}
