package com.duru.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/api/health")
    public HealthResponse health() {
        return new HealthResponse("UP", "duru 백엔드가 정상 실행 중이에요.");
    }

    public record HealthResponse(String status, String message) {}
}
