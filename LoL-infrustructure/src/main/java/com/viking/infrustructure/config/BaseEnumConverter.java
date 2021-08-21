package com.viking.infrustructure.config;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", uses = {}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BaseEnumConverter {

}
