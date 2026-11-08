package com.juliadeconto.currencyconverter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final RestTemplate restTemplate;
}
