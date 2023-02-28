package com.matchit.me.leonparser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Market {

    private String id;

    private String resultName;

    private BigDecimal coefficient;
}
