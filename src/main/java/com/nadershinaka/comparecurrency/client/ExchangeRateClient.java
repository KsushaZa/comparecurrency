package com.nadershinaka.comparecurrency.client;

import com.nadershinaka.comparecurrency.config.ExchangeConfig;
import com.nadershinaka.comparecurrency.dto.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeRate", url = "https://api.exchangerate.host", configuration = ExchangeConfig.class)
public interface ExchangeRateClient {

    @GetMapping(path = "/historical")
    CurrencyResponse getCurrency(@RequestParam("date") String date);

}
