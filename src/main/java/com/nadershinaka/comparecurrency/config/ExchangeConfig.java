package com.nadershinaka.comparecurrency.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


public class ExchangeConfig {
    @Value("${exchangeRate.api-key}")
    private String exchangeRateApiKey;

    @Value("${exchangeRate.basecurrency}")
    private String exchangeBaseCurrency;

    @Bean
    public RequestInterceptor exchangeRateRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.query("source", exchangeBaseCurrency);
            requestTemplate.query("access_key", exchangeRateApiKey);
        };
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
