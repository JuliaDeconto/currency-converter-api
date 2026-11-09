package com.juliadeconto.currencyconverter.controller;

import com.juliadeconto.currencyconverter.dto.QuoteDTO;
import com.juliadeconto.currencyconverter.service.QuoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.mockito.Mockito.when;

@WebMvcTest(ConversionController.class)
public class ConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private QuoteService quoteService;

    @Test
    void shouldConvertCurrencySuccessfully() throws Exception {

        QuoteDTO quote = new QuoteDTO();
        quote.setBid("5.00");

        when(quoteService.getQuote("USD", "BRL")).thenReturn(quote);

        mockMvc.perform(get("/convert")
                        .param("from", "USD")
                        .param("to", "BRL")
                        .param("amount", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(500.00));
    }

    @Test
    void shouldReturnBadRequestWhenCurrencyIsBlank() throws Exception {

        mockMvc.perform(get("/convert")
                        .param("from", " ")
                        .param("to", "BRL")
                        .param("amount", "100"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Currency codes must not be blank"));
    }

    @Test
    void shouldReturnBadRequestWhenAmountIsNotNumber() throws Exception {

        mockMvc.perform(get("/convert")
                        .param("from", "USD")
                        .param("to", "BRL")
                        .param("amount", "abc"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid amount: must be a number"));
    }
}
