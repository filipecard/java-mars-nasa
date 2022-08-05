package com.example.MARS.controllers;

import com.example.MARS.services.MarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestControllercurl -s --request POST http://localhost:8080/rest/mars/MML
@RequestMapping("/rest")
public class MarsController {
    @Autowired
    private MarsService marsService;

    @PostMapping("/mars/{commands}")
    public ResponseEntity<?> executeCommands (
            @PathVariable("commands")
            String commands) {

        return ResponseEntity.status(HttpStatus.OK).body(marsService.executeCommands(commands));

    }
}
