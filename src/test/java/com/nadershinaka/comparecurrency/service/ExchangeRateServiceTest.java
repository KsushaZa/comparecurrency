package com.nadershinaka.comparecurrency.service;

import com.nadershinaka.comparecurrency.client.ExchangeRateClient;
import com.nadershinaka.comparecurrency.dto.CurrencyResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import java.util.Map;

import static org.mockito.Mockito.*;

@SpringBootTest
@EnableCaching
@ExtendWith(MockitoExtension.class)
public class ExchangeRateServiceTest {

//    @Mock
//    private ExchangeRateService exchangeRateService;
//
//
//    private CacheManager cacheManager = new ConcurrentMapCacheManager("exchangeRate");
//
//
//    @Test
//    void shouldCacheExchangeRateData() {
//        // Arrange
////        CurrencyResponse mockResponse = mock(CurrencyResponse.class);
////        when(mockResponse.getQuotes()).thenReturn(Map.of("USDRUB", 75.5));
////        when(exchangeRateClient.getCurrency("2025-09-20")).thenReturn(80.21);
//
//        when(exchangeRateService.getExchangeRate("RUB", 0L)).thenReturn(33.0);
//        // Act
//        exchangeRateService.getExchangeRate("RUB", 0L); // первый вызов → идёт к клиенту
//        exchangeRateService.getExchangeRate("RUB", 0L); // второй вызов → берёт из кэша
//
//        // Assert
//        verify(exchangeRateService, times(1)).getExchangeRate("RUB", 0L);
//    }
}
