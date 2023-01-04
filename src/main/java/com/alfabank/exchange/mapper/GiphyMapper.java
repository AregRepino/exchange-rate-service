package com.alfabank.exchange.mapper;

import com.alfabank.exchange.clients.dto.giphy.GiphyDataDto;
import com.alfabank.exchange.dto.GiphyDto;
import com.alfabank.exchange.repository.model.Giphy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class GiphyMapper {


    public abstract GiphyDto toGiphyDto (Giphy giphy);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "giphyId", source = "id")
    public abstract Giphy toGiphy (GiphyDataDto giphyDataDto);

}
