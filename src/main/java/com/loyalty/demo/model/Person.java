package com.loyalty.demo.model;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    String name;
    String surname;

    public Person random(){
        Faker faker = new Faker();
        this.name = faker.options().option("Andrea","Maria","Chiara");
        this.surname = faker.options().option("Rossi","Verdi");
        return this;
    }
}
