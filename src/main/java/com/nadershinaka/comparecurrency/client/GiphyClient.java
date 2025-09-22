package com.nadershinaka.comparecurrency.client;


import com.nadershinaka.comparecurrency.config.GiphyConfig;
import com.nadershinaka.comparecurrency.dto.GiphyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "giphy", url = "https://api.giphy.com", configuration = GiphyConfig.class)
public interface GiphyClient {
    @GetMapping("/v1/gifs/{id}")
    GiphyResponse getGiphy(@PathVariable("id") String gifId);
}
