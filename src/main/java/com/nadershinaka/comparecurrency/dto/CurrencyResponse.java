package com.nadershinaka.comparecurrency.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CurrencyResponse {
    private Map<String, Double> quotes;
}
