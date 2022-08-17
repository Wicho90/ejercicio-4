package com.lochoa.ejercicio4.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("")
    @GetMapping("hello")
    public ResponseEntity<String> saludo() {
        return ResponseEntity.ok("Hola");
    }

}
