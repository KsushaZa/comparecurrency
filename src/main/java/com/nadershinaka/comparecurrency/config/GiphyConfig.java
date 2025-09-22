package com.nadershinaka.comparecurrency.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


public class GiphyConfig {
    @Value("${giphy.api-key}")
    private String giphyApiKey;

    @Value("${giphy.rating}")
    private String giphyRating;

    @Bean
    public RequestInterceptor giphyRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.query("api_key", giphyApiKey);
            requestTemplate.query("rating", giphyRating);
        };
    }
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

