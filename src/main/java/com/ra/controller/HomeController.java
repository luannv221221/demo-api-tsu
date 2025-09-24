package com.ra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HomeController {
    @GetMapping("")
    public ResponseEntity<String> home(){

        return ResponseEntity.ok("API QUAN LY BH");
    }
}
