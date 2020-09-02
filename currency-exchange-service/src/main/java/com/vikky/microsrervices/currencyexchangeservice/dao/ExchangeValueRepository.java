package com.vikky.microsrervices.currencyexchangeservice.dao;

import com.vikky.microsrervices.currencyexchangeservice.service.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Integer> {
    public ExchangeValue findByFromAndTo(String from, String to);
}
