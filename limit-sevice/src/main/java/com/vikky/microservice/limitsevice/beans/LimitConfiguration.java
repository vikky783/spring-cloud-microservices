package com.vikky.microservice.limitsevice.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LimitConfiguration {
    private Integer maxValue;
    private Integer minValue;

}
