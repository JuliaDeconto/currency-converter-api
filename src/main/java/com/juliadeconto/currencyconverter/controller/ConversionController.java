package com.juliadeconto.currencyconverter.controller;

import com.juliadeconto.currencyconverter.dto.ConversionResponseDTO;
import com.juliadeconto.currencyconverter.dto.QuoteDTO;
import com.juliadeconto.currencyconverter.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/convert")
@RequiredArgsConstructor
public class ConversionController {

    private final QuoteService quoteService;

    @GetMapping
    public ConversionResponseDTO convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal amount) {

        QuoteDTO quote = quoteService.getQuote(from, to);

        BigDecimal rate = new BigDecimal(quote.getBid());
    }
}
