package com.charter.enterprise.motd;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class MotdController {

    static final String DEFAULT_MESSAGE = "Welcome to Charter.  All systems are nominal.";
    static final String SECURITY_KEY = "ofihuUD$5hfQRcLX&34";

    private String currentMessage = DEFAULT_MESSAGE;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity getMotd() {
        String returnMessage = currentMessage;
        HttpEntity response = ResponseEntity.ok(returnMessage);
        return response;
    }

    @RequestMapping(method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.TEXT_PLAIN_VALUE)
    public HttpEntity postMotd(@RequestBody MessageResource messageResource) {
        HttpEntity response;
        String securityKey = messageResource.getSecurityKey();
        String message = messageResource.getMessage();
        if (!SECURITY_KEY.equals(securityKey)) {
            response = ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid password");
        } else {
            currentMessage = message;
            response = ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Message changed successfully.");
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public HttpEntity deleteMethod() {
        HttpEntity response = ResponseEntity.status(HttpStatus.OK).body("Hello from delete.");
        return response;
    }

}
