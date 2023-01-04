package com.alfabank.exchange.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Giphy {
    @Id
    @GeneratedValue
    private Long id;
    private String giphyId;
    private String url;
}
