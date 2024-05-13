package com.inkhyang.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlcoController {
    @GetMapping("/alcos")
    public String[] getAlcos() {
        return new String[] { "Alco 1", "Alco 2", "Alco 3" };
    }
}
