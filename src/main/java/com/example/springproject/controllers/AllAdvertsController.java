package com.example.springproject.controllers;

import com.example.springproject.helpers.TimeHelper;
import com.example.springproject.models.AdvertModel;
import com.example.springproject.repos.AdvertRepository;
import com.example.springproject.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AllAdvertsController {
 @Autowired
    FireBaseService fireBaseService;

  final
  AdvertRepository advertRepository;

    public AllAdvertsController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping("/allAdverts")
    public String getAdverts(Model model){
       List<AdvertModel> list = new ArrayList<>();
       list =(List<AdvertModel>) advertRepository.findAll();
        list = TimeHelper.getTime(list);
       model.addAttribute("allAdverts",list);
       list.stream().forEach(i -> i.setUrl(fireBaseService.getUrl(i.getUrl())));
          return "allAdverts";
}
}
