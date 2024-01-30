package com.example.springproject.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "advert_model_shop")
@Data
public class AdvertModel {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "disc")
    String disc;

    @Column(name = "url")
    private  String url;

    @Column(name ="add_time")
    Long time;

    @Column(name="type")
    private String type;

   private String timeFormat;
}