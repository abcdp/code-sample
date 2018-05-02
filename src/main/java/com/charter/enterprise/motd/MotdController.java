package com.charter.enterprise.motd;

import org.springframework.web.bind.annotation.*;

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
    public void setMotd(@RequestParam String message) {
        currentMessage = message;
    }

}
