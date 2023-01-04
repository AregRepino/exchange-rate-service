package com.alfabank.exchange.controller;

import com.alfabank.exchange.config.AppConfig;
import com.alfabank.exchange.dto.GiphyDto;
import com.alfabank.exchange.mapper.GiphyMapper;
import com.alfabank.exchange.repository.model.Giphy;
import com.alfabank.exchange.service.ExchangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)

public class ExchangeControllerTest {
    @Configuration
    @Import(ExchangeController.class)
    static class Config {
    }


    @MockBean
    private ExchangeService exchangeService;

    @MockBean
    private AppConfig appConfig;
    // это значит что мы подстовляем фейкаваю реализацию
    @MockBean
    private GiphyMapper giphyMapper;
    // реальную реализацию
    @Autowired
    private ExchangeController exchangeController;

    @Test
    public void getCurrencyExchangeGif() {

//        given
        Giphy giphy = new Giphy();
        GiphyDto giphyDto = new GiphyDto();
        given(exchangeService.chooseGif(anyString())).willReturn(giphy);
        given(giphyMapper.toGiphyDto(giphy)).willReturn(giphyDto);

//        when
        GiphyDto result = exchangeController.getCurrencyExchangeGif("RUB");

//        then
        assertNotNull(result);
        assertEquals(giphyDto, result);
    }


    @Test
    public void getCurrencyExchangeGifWithDefaultCurrency() {

//        given
        given(appConfig.getCurrency()).willReturn("EUR");
        Giphy giphy = new Giphy();
        GiphyDto giphyDto = new GiphyDto();
        given(exchangeService.chooseGif("EUR")).willReturn(giphy);
        given(giphyMapper.toGiphyDto(giphy)).willReturn(giphyDto);

//        when
        GiphyDto result = exchangeController.getCurrencyExchangeGif(null);

//        then
        assertNotNull(result);
        assertEquals(giphyDto, result);
    }


}
