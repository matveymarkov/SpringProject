package com.example.springproject.controllers;

import com.example.springproject.helpers.TimeHelper;
import com.example.springproject.models.AdvertModel;
import com.example.springproject.repos.AdvertRepository;
import com.example.springproject.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class MainController {
    final
    AdvertRepository advertRepository;
@Autowired
  private   FireBaseService fireBaseService;
    public MainController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String getMainPage(Model model) {


        List<AdvertModel> list= (List<AdvertModel>) advertRepository.findAll();
        list = list.stream().limit(5).collect(Collectors.toList());
        list = TimeHelper.getTime(list);
        list.stream().forEach(i -> i.setUrl(fireBaseService.getUrl(i.getUrl())));
        model.addAttribute("Adverts", list);
        return "index";
    }
}
