package com.vikky.microsrervices.currencyexchangeservice.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExchangeValue {
    private Integer id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;

}
