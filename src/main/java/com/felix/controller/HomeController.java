package com.felix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String HomecontrollerHandler(){
        return "category service for micrososervice salon booking system";
    }
}
