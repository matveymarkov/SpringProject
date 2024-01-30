package com.example.springproject.controllers;

import com.example.springproject.repos.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/delete")
public class DeleteController {

        @Autowired
    AdvertRepository advertRepository;

        @GetMapping("/{id}")
        public RedirectView delete(@PathVariable long id){
            advertRepository.deleteById(id);
            return new RedirectView("/admin/edit");
        }
    }


