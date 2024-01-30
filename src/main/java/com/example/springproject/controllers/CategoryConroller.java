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

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryConroller {

    @Autowired
    AdvertRepository advertRepository;

    @Autowired
    FireBaseService fireBaseService;
    @GetMapping("/toys")
    public String getToys(Model model){
      List<AdvertModel> list = advertRepository.findAllByType("Игрушки");
        model.addAttribute("allAdverts", list);
        list.stream().forEach(i -> i.setUrl(fireBaseService.getUrl(i.getUrl())));
        list = TimeHelper.getTime(list);
        return "allAdverts";
    }
    @GetMapping("/forpc")
    public String getForPc(Model model){
        List<AdvertModel> list = (List<AdvertModel>) advertRepository.findAllByType("Для компьютера");
        model.addAttribute("allAdverts", list);
        list.stream().forEach(i -> i.setUrl(fireBaseService.getUrl(i.getUrl())));
        list = TimeHelper.getTime(list);
        return "allAdverts";

    }
    @GetMapping("/foryou")
    public String getForYou(Model model){
        List<AdvertModel> list = (List<AdvertModel>) advertRepository.findAllByType("Для себя");
        model.addAttribute("allAdverts", list);
        list.stream().forEach(i -> i.setUrl(fireBaseService.getUrl(i.getUrl())));
        list = TimeHelper.getTime(list);
        return "allAdverts";
    }
}
