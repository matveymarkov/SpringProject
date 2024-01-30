package com.example.springproject.controllers;

import com.example.springproject.models.AdvertModel;
import com.example.springproject.repos.AdvertRepository;
import com.example.springproject.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AddAdvertController {
  @Autowired
    FireBaseService fireBaseService;
    final
    AdvertRepository advertRepository;
    public AddAdvertController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;

    }
@PostMapping("/addAdvert")
public RedirectView postData(@RequestParam String name,
                             @RequestParam Double price,
                             @RequestParam MultipartFile file,
                             @RequestParam String disc,
                             @RequestParam String type) throws Exception {
    AdvertModel advertModel = new AdvertModel();
    advertModel.setName(name);
    advertModel.setPrice(price);
    advertModel.setUrl(fireBaseService.save(file));
    advertModel.setDisc(disc);
    advertModel.setTime(System.currentTimeMillis());
    advertModel.setType(type);
    advertRepository.save(advertModel);
   return new  RedirectView("/");

}
    @GetMapping("/addAdvert")
    public String addAdvert(){
        return "addAdvert";
    }

}
