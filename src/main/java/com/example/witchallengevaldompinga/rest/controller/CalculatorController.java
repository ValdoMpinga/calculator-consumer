package com.example.witchallengevaldompinga.rest.controller;

import com.example.witchallengevaldompinga.calculator.service.CalculatorService;
import com.example.witchallengevaldompinga.dto.CalculatorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public ResponseEntity<BigDecimal> add(@RequestBody CalculatorDTO request) {
        return ResponseEntity.ok(calculatorService.add(request.getA(), request.getB()));
    }

    @PostMapping("/subtract")
    public ResponseEntity<BigDecimal> subtract(@RequestBody CalculatorDTO request) {
        return ResponseEntity.ok(calculatorService.subtract(request.getA(), request.getB()));
    }

    @PostMapping("/multiply")
    public ResponseEntity<BigDecimal> multiply(@RequestBody CalculatorDTO request) {
        return ResponseEntity.ok(calculatorService.multiply(request.getA(), request.getB()));
    }

    @PostMapping("/divide")
    public ResponseEntity<BigDecimal> divide(@RequestBody CalculatorDTO request) {
        try {
            return ResponseEntity.ok(calculatorService.divide(request.getA(), request.getB()));
        } catch (ArithmeticException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
