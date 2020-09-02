package com.vikky.microservices.currencyconversionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

  @Autowired private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

  @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrency(
      @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

    Map<String, String> uriVariable = new HashMap<>();
    uriVariable.put("from", from);
    uriVariable.put("to", to);
    ResponseEntity<CurrencyConversionBean> responseEntity =
        new RestTemplate()
            .getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBean.class,
                uriVariable);
    CurrencyConversionBean conversionBean = responseEntity.getBody();
    assert conversionBean != null;
    return new CurrencyConversionBean(
        conversionBean.getId(),
        from,
        to,
        conversionBean.getConversionMultiple(),
        quantity,
        quantity.multiply(conversionBean.getConversionMultiple()),
        conversionBean.getPort());
  }

  @GetMapping(value = "/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrencyFeign(
      @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

    CurrencyConversionBean conversionBean =
        currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
    assert conversionBean != null;
    return new CurrencyConversionBean(
        conversionBean.getId(),
        from,
        to,
        conversionBean.getConversionMultiple(),
        quantity,
        quantity.multiply(conversionBean.getConversionMultiple()),
        conversionBean.getPort());
  }
}
