package com.example.springproject.controllers;



import com.example.springproject.helpers.AdvertModelWithCurrency;
import com.example.springproject.models.AdvertModel;
import com.example.springproject.models.RequestModel;
import com.example.springproject.repos.AdvertRepository;
import com.example.springproject.repos.RequestRepository;
import com.example.springproject.services.CurrencyService;
import com.example.springproject.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Currency;

@Controller
@RequestMapping("/item")
public class DetailItemController {
    @Autowired
    AdvertRepository advertRepository;
    @Autowired
    CurrencyService currencyService;
   @Autowired
    RequestRepository requestRepository;
   @Autowired
    FireBaseService fireBaseService;
    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable long id,
                                Model model){
        AdvertModel advertModel = advertRepository.findById(id);
        AdvertModelWithCurrency advertModelWithCurrency = new AdvertModelWithCurrency(advertModel);
        advertModelWithCurrency.setEurPrice(currencyService.getEurPrice(advertModel.getPrice()));
        advertModelWithCurrency.setUsdPrice(currencyService.getUsdPrice(advertModel.getPrice()));
        advertModelWithCurrency.setUrl(fireBaseService.getUrl(advertModel.getUrl()));
        model.addAttribute("item", advertModelWithCurrency);
        return "datailadvert";
    }
   @PostMapping("/{id}")
    public RedirectView saveData(@PathVariable long id,@RequestParam String name,@RequestParam String phoneNumber){
       RequestModel requestModel = new RequestModel();
       requestModel.setName(name);
       requestModel.setPhoneNumber(phoneNumber);
       requestModel.setItemId(id);
       requestRepository.save(requestModel);
       return new RedirectView("/allAdverts");



   }
}