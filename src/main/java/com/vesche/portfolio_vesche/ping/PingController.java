package com.vesche.portfolio_vesche.ping;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Operation(summary = "Application ping endpoint.")
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
