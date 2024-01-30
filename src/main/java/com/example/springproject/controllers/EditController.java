package com.example.springproject.controllers;


import com.example.springproject.models.AdvertModel;
import com.example.springproject.repos.AdvertRepository;
import com.example.springproject.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/edit")
public class EditController {
@Autowired
    FireBaseService fireBaseService;
    @Autowired
    AdvertRepository advertRepository;

    @GetMapping("/{id}")
    public String edit(Model model, @PathVariable long id){
       AdvertModel advertModel = advertRepository.findById(id);
         advertModel.setUrl(fireBaseService.getUrl(advertModel.getUrl()));
        model.addAttribute("item", advertModel);
        return "edit";
    }
    @PostMapping("/{id}")
    public RedirectView setChanges(@PathVariable long id,
                                   @RequestParam String name,
                                   @RequestParam double price,
                                   @RequestParam String disc,
                                   @RequestParam String url) {
        AdvertModel advertModel = advertRepository.findById(id);
        advertModel.setName(name);
        advertModel.setDisc(disc);
        advertModel.setPrice(price);
        advertModel.setUrl(url);
       advertRepository.save(advertModel);
        return new RedirectView("/");
    }
}


