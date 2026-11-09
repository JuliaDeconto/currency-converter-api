package com.juliadeconto.currencyconverter.controller;

import com.juliadeconto.currencyconverter.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
@RequiredArgsConstructor
public class ConversionController {

    private final QuoteService quoteService;
}
