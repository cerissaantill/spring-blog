package com.codeup.blog.models;

import javax.persistence.*;




@Entity
public class Property {



    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    private String description;

    @Column(name="asking_price")
    private int askingPrice;

    @Column
    private int bedrooms;

    @Column
    private double bathrooms;

    @Column(name="square_footage")
    private int sqareFootage;


}
