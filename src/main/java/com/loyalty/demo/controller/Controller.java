package com.loyalty.demo.controller;

import com.loyalty.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("events")
public class Controller {

    @Autowired
    private EventService eventService;

    @GetMapping("/produce")
    public ResponseEntity<Void> produceEvent(@PathParam("number") Integer number) {
       eventService.produce(number);
       return ResponseEntity.ok().build();

    }

}