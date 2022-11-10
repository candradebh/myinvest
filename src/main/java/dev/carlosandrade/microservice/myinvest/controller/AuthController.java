package dev.carlosandrade.microservice.myinvest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @PostMapping("/login")
    public String ola() {
        Map<String, String> response = new HashMap<String, String>();
        String string = null;
        if (string != null) {

        }
        return "login";
    }
}
