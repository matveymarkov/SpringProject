package com.example.springproject.controllers;

import com.example.springproject.helpers.TimeHelper;
import com.example.springproject.models.AdvertModel;
import com.example.springproject.models.RequestModel;
import com.example.springproject.repos.AdvertRepository;
import com.example.springproject.repos.RequestRepository;
import com.example.springproject.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    RequestRepository requestRepository;
    @Autowired
    AdvertRepository advertRepository;
   @Autowired
    FireBaseService fireBaseService;



    @GetMapping
    public String getAdmin(){
        return "admin";
    }

    @GetMapping("/edit")
    public String getAll(Model model){
        List<AdvertModel> list = new ArrayList<>();
        list =(List<AdvertModel>) advertRepository.findAll();
        list = TimeHelper.getTime(list);
        list.stream().forEach(i -> i.setUrl(fireBaseService.getUrl(i.getUrl())));
        model.addAttribute("allAdverts",list);
        return "editAdverts";
    }

    @GetMapping("/req")
    public String getPage(Model model){
        List<RequestModel> list = requestRepository.findAll();
        model.addAttribute("req",list);
        return "requests";
    }

}
