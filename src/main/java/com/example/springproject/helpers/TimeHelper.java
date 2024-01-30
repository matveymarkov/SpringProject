package com.example.springproject.helpers;

import com.example.springproject.models.AdvertModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeHelper {
    public static List<AdvertModel> getTime(List<AdvertModel> list){
        for (AdvertModel i : list){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd.MM");
            i.setTimeFormat(simpleDateFormat.format(new Date(i.getTime())));
        }
        return list;
    }
}
