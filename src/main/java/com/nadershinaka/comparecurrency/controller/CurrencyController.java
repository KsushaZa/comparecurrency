package com.nadershinaka.comparecurrency.controller;

import com.nadershinaka.comparecurrency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping(value = "/rate", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> getRate() {
        byte[] gifData = currencyService.getGifToDifferenceExchangeRate("RUB");
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_GIF)
                .body(gifData);
    }
}
