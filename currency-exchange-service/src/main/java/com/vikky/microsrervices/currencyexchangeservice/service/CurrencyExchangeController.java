package com.vikky.microsrervices.currencyexchangeservice.service;

import com.vikky.microsrervices.currencyexchangeservice.dao.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {

  @Autowired private ExchangeValueRepository exchangeValueRepository;

  @Autowired private Environment environment;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    int portNumber =
        Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
    return exchangeValueRepository.findByFromAndTo(from, to);
  }
}
