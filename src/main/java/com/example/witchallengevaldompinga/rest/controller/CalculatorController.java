package com.example.witchallengevaldompinga.rest.controller;


import com.example.witchallengevaldompinga.dto.CalculatorDTO;
import com.example.witchallengevaldompinga.service.CalculatorServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorServiceClient serviceClient;

    public CalculatorController(CalculatorServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @PostMapping("/add")
    public ResponseEntity<Mono<BigDecimal>> add(@RequestBody CalculatorDTO request) {
        return ResponseEntity.ok(serviceClient.add(request));
    }

    @PostMapping("/subtract")
    public ResponseEntity<Mono<BigDecimal>> subtract(@RequestBody CalculatorDTO request) {
        return ResponseEntity.ok(serviceClient.subtract(request));
    }

    @PostMapping("/multiply")
    public ResponseEntity<Mono<BigDecimal>> multiply(@RequestBody CalculatorDTO request) {
        return ResponseEntity.ok(serviceClient.multiply(request));
    }

    @PostMapping("/divide")
    public ResponseEntity<Mono<BigDecimal>> divide(@RequestBody CalculatorDTO request) {
        return ResponseEntity.ok(serviceClient.divide(request));
    }
}