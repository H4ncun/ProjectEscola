package com.gft.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping
    public String home() {
        return "Bem-vindos à API Escola :)";
    }

}
