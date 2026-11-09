package com.juliadeconto.currencyconverter.service;

import com.juliadeconto.currencyconverter.dto.QuoteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final RestTemplate restTemplate;

    public QuoteDTO getQuote(String from, String to) {
        String url = "https://economia.awesomeapi.com.br/json/last/" + from + "-" + to;

        ResponseEntity<Map<String, QuoteDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, QuoteDTO>>() {}
        );

        Map<String, QuoteDTO> body = response.getBody();

        return body.get(from + to);
    }
}
