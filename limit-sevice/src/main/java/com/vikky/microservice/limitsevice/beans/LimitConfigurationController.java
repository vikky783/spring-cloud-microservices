package com.vikky.microservice.limitsevice.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    private final Configuration configuration;

    @Autowired
    public LimitConfigurationController(Configuration configuration){
        this.configuration = configuration;
    }
    @RequestMapping("/limits")
    public LimitConfiguration retrieveLimitFromConfiguration() {
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());

    }
}
