package com.loyalty.demo.model;

import com.github.javafaker.Faker;
import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    private String name;
    private String address;
    ShopCategory category;

    public Shop random(){
        Faker faker = new Faker();
        this.name = faker.company().name();
        this.address = faker.address().fullAddress();
        this.category = ShopCategory.randomCategory();
        return this;
    }
}
