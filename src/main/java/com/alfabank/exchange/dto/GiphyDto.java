package com.alfabank.exchange.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GiphyDto {
    private Long id;
    private String giphyId;
    private String url;
}
