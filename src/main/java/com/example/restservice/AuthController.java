package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/")  // Base path (optional)
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "Please use POST with credentials to authenticate.";
    }
    
    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint. Anyone can access it.";
    }

    @GetMapping("/user")
    public String userEndpoint(@AuthenticationPrincipal UserDetails userDetails) {
        return "Hello, " +userDetails.getUsername()  + "! You are authorized as USER.";
    }

    @GetMapping("/admin")
    public String adminEndpoint(@AuthenticationPrincipal UserDetails userDetails) {
        return "Hello, " + userDetails.getUsername() + "! You are authorized as ADMIN.";
    }
}

