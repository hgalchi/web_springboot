package com.example.WebSpringboot.part04.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.*;

@Controller
class controllerTest {

    @GetMapping("/uploadEX")
    public void uploadEx() {

    }
}