package com.example.witchallengevaldompinga.service;

import com.example.witchallengevaldompinga.dto.CalculatorDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class CalculatorServiceClient {

    private final WebClient webClient;

    public CalculatorServiceClient() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8081/calculator")
                .build();
    }

    public Mono<BigDecimal> add(CalculatorDTO request) {
        return webClient.post()
                .uri("/add")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(BigDecimal.class);
    }

    public Mono<BigDecimal> subtract(CalculatorDTO request) {
        return webClient.post()
                .uri("/subtract")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(BigDecimal.class);
    }

    public Mono<BigDecimal> multiply(CalculatorDTO request) {
        return webClient.post()
                .uri("/multiply")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(BigDecimal.class);
    }

    public Mono<BigDecimal> divide(CalculatorDTO request) {
        return webClient.post()
                .uri("/divide")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(BigDecimal.class);
    }
}