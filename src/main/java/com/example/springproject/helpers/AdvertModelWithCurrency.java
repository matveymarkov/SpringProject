package com.example.springproject.helpers;

import com.example.springproject.models.AdvertModel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class AdvertModelWithCurrency {

    long id;

    String name;


    double price;


    String disc;


    private String url;


    Long time;


    private String type;

    private String timeFormat;
    private double usdPrice;
    private double eurPrice;

    public AdvertModelWithCurrency() {

    }

    public AdvertModelWithCurrency(AdvertModel advertModel) {
        this.id = advertModel.getId();
        this.name = advertModel.getName();
        this.price = advertModel.getPrice();
        this.disc = advertModel.getDisc();
        this.url = advertModel.getUrl();
        this.time = advertModel.getTime();
        this.type = advertModel.getType();
        this.timeFormat = advertModel.getTimeFormat();

    }
}

