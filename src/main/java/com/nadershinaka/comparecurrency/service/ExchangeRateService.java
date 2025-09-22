package com.nadershinaka.comparecurrency.service;

import com.nadershinaka.comparecurrency.client.ExchangeRateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ExchangeRateService {
    @Value("${exchangeRate.basecurrency}")
    private String exchangeBaseCurrency;

    @Autowired
    private ExchangeRateClient exchangeRateClient;

    //Получаем курс валюты, используем кэширование по дате
    @Cacheable(cacheNames = "exchangeRate", key ="#daysToSubtract")
    public Double getExchangeRate(String quotedCurrency, Long daysToSubtract) {
        String currency = exchangeBaseCurrency + quotedCurrency;
        LocalDate date = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Double exchangeRate = exchangeRateClient.getCurrency(date.minusDays(daysToSubtract).format(formatter)).getQuotes().get(currency);
        return exchangeRate;
    }
}
