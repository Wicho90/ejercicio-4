package com.lochoa.ejercicio4.controllers;

import com.lochoa.ejercicio4.models.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port + "/api/laptops");
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("200 ok en buscar todos")
    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> laptops = List.of(response.getBody());
        System.out.println(laptops.size());
    }

    @Test
    void findOneById() {

        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "marca": "Acer nitro",
                    "modelo": "Astrom",
                    "precio": 20531.98,
                    "disponible": false
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assert result != null;
        assertEquals(1, result.getId());

        assertEquals("Acer nitro", result.getMarca());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());


    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "id": 1,
                    "marca": "Hp",
                    "modelo": "Php",
                    "precio": 20531.98,
                    "disponible": false
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<String> response =
                testRestTemplate.exchange("/", HttpMethod.PUT, request, String.class);

        String result = response.getBody();


        System.out.println(result);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }


}