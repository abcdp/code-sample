package com.charter.enterprise.motd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MotdController {

    static final String DEFAULT_MESSAGE = "Welcome to Charter.  All systems are nominal.";

    private String currentMessage = DEFAULT_MESSAGE;

    @GetMapping
    public String getMotd() {
        return currentMessage;
    }

    @PostMapping
    public void setMotd(String message) {
        currentMessage = message;
    }

}
