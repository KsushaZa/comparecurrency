package com.nadershinaka.comparecurrency.service;

import com.nadershinaka.comparecurrency.client.GiphyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.nadershinaka.comparecurrency.model.GifType.*;

@Service
public class CurrencyService {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private GiphyClient giphyClient;

    private LocalDate lastDelayDate = null;

    //Получаем гифку в зависимости от того как изменился курс
    public String getGifToDifferenceExchangeRate(String quotedCurrency) {
        //Получаем разницу между курсом заданной валюты за вчерашний и текущий день
        Double todayRate = exchangeRateService.getExchangeRate(quotedCurrency, 0L);

        //Задержка вызова при первом запуске приложения за день, чтобы избежать ошибки 429
        if (!LocalDate.now().equals(lastDelayDate)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Восстанавливаем флаг прерывания
            }
            lastDelayDate = LocalDate.now();
        }

        Double yesterdayRate = exchangeRateService.getExchangeRate(quotedCurrency, 1L);
        Double difference = todayRate - yesterdayRate;

        //Получаем url гифки в зависимости от изменения курса
        String gifType = getGifId(difference);
        return giphyClient.getGiphy(gifType).getData().get("url").toString();
    }

    //Получаем id гифки в зависимости от разницы курса
    public String getGifId(Double difference) {
        String gifId;

        if (difference > 0) {
            return RICH.getGifId();
        } else if (difference == 0) {
            return NEUTRAL.getGifId();
        } else {
            return POOR.getGifId();
        }
    }
}
