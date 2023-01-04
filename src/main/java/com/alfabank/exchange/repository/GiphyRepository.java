package com.alfabank.exchange.repository;


import com.alfabank.exchange.repository.model.Giphy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiphyRepository extends JpaRepository <Giphy, Long> {
}
