package com.alfabank.exchange.service;

import com.alfabank.exchange.clients.GiphyClient;
import com.alfabank.exchange.clients.OpenExchangeRatesClient;
import com.alfabank.exchange.clients.dto.giphy.GiphyDataDto;
import com.alfabank.exchange.clients.dto.giphy.GiphySearchResponseDto;
import com.alfabank.exchange.clients.dto.oxr.ExchangeResponseDto;
import com.alfabank.exchange.mapper.GiphyMapper;
import com.alfabank.exchange.repository.GiphyRepository;
import com.alfabank.exchange.repository.model.Giphy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    private final OpenExchangeRatesClient oxrClient;
    private final GiphyClient giphyClient;
    private final GiphyRepository giphyRepository;
    private final GiphyMapper giphyMapper;


    public Giphy chooseGif(String currency) {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        ExchangeResponseDto latestExchange = oxrClient.getLatest();
        ExchangeResponseDto yesterdayExchange = oxrClient.getHistorical(yesterday.toString());

        double todayValue = latestExchange.getRates().getOrDefault(currency, 0.0);
        double yesterdayValue = yesterdayExchange.getRates().getOrDefault(currency, 0.0);

        String query = ExchangeUtils.buildQueryKeyword(todayValue, yesterdayValue);

        GiphySearchResponseDto giphySearchResponseDto = giphyClient.search(query);

        int count = giphySearchResponseDto.getData().size();
        int random = (int) ( Math.random() * ( count - 1 ) );


        GiphyDataDto giphyDataDto = giphySearchResponseDto.getData().get(random);
        Giphy giphy = giphyMapper.toGiphy(giphyDataDto);

        giphy = giphyRepository.save(giphy);

        return giphy;
    }

}
