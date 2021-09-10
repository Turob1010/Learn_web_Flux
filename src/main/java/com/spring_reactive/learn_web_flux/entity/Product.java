package com.spring_reactive.learn_web_flux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Products10")
public class Product {
    @Id
    private String id;
    private String name;
    private int qty;
    private double price;

}
