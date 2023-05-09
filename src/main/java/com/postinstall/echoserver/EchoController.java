package com.postinstall.echoserver;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@RestController
public class EchoController {
    @RequestMapping(path = "/", produces = "application/json")
    public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(headers);
            return new ResponseEntity<String>(jsonString, HttpStatus.OK);
        } catch(IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Somethings wrong :(",HttpStatus.OK);
        }
    }
}
