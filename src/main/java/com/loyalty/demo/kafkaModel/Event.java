package com.loyalty.demo.kafkaModel;

import com.github.javafaker.Faker;
import com.loyalty.demo.model.Person;
import com.loyalty.demo.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Event {


    private Person person;
    private LocalDateTime date;
    private Double amount;
    private Shop shop;

    public Event random(){

        Faker faker = new Faker(new Locale("it"));
        this.person = new Person().random();
        this.date = faker.date().between(Date.valueOf(LocalDate.now().minusDays(90)), Date.valueOf(LocalDate.now())).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        this.amount = faker.number().randomDouble(2,1,500);
        this.shop = new Shop().random();
        return this;
    }

}
