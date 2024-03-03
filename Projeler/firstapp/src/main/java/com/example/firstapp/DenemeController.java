package com.example.firstapp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DenemeController {

    @GetMapping("/deneme")
    public String deneme() {
        return "deneme";
    }

}
