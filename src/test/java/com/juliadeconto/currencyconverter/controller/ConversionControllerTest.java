package com.juliadeconto.currencyconverter.controller;

import com.juliadeconto.currencyconverter.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ConversionController.class)
public class ConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private QuoteService quoteService;
}
