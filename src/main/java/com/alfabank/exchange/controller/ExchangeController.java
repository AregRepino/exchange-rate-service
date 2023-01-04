package com.alfabank.exchange.controller;

import com.alfabank.exchange.clients.dto.giphy.GiphyDataDto;
import com.alfabank.exchange.config.AppConfig;
import com.alfabank.exchange.dto.GiphyDto;
import com.alfabank.exchange.mapper.GiphyMapper;
import com.alfabank.exchange.repository.model.Giphy;
import com.alfabank.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final AppConfig appConfig;
    private final GiphyMapper giphyMapper;


    @ResponseStatus(OK)
    @GetMapping(value = "/exchange/gif", produces = "application/json")
    @ResponseBody
    public GiphyDto getCurrencyExchangeGif(@RequestParam(value = "currency", required = false) String currency) {
        if (currency == null) {
            currency = appConfig.getCurrency();
        }
        Giphy giphy = exchangeService.chooseGif(currency);
        return giphyMapper.toGiphyDto(giphy);
    }
}
