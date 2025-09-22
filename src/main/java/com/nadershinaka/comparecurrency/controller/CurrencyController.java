package com.nadershinaka.comparecurrency.controller;

import com.nadershinaka.comparecurrency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rate")
    public String getRate() {
        return currencyService.getGifToDifferenceExchangeRate("RUB");
    }
}
