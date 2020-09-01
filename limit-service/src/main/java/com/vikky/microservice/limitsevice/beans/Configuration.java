package com.vikky.microservice.limitsevice.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {

    private Integer minimum;
    private Integer maximum;

}
