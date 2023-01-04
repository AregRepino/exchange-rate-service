package com.alfabank.exchange;

import com.alfabank.exchange.dto.GiphyDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableFeignClients
public class ExchangeApplication {

    public static void main(String... args) {
        SpringApplication.run(ExchangeApplication.class, args);

    }

}
