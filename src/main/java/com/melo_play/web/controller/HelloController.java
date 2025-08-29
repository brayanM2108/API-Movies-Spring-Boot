package com.melo_play.web.controller;

import com.melo_play.domain.services.AIPlayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final AIPlayService aiPlayService;
    public HelloController(AIPlayService aiPlayService) {
        this.aiPlayService = aiPlayService;
    }

    @GetMapping("/hello")
    public String hello() {
        return aiPlayService.generateGreeting();
    }
}
