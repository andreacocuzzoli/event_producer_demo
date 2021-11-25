package com.loyalty.demo.service;

import com.loyalty.demo.kafkaModel.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class EventService {

    @Autowired
    KafkaTemplate<String, Event> eventTemplate;
    Logger logger = LoggerFactory.getLogger(EventService.class);

    public boolean produce(Integer number) {
        try {
            for (int i = 0; i < number; i++) {
                Event event = new Event().random();
                eventTemplate.send("event", event);
                logger.info("Generated Event: {}", event.toString());
            }

        } catch (Exception e) {
            logger.error("Error generating event: {}", e.getMessage());
            return false;
        }

        return true;


    }
}
