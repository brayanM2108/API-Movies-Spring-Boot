package com.melo_play;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final AIPlayService aiPlayService;
    public HelloController(AIPlayService aiPlayService) {
        this.aiPlayService = aiPlayService;
    }

    @GetMapping("/")
    public String hello() {
        return aiPlayService.generateGreeting();
    }
}
