package com.juliadeconto.currencyconverter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ConversionResponseDTO {

    private String from;
    private String to;
    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal result;
}
