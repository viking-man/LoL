package com.viking.infrustructure.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@MapperConfig(componentModel = "spring", uses = {BaseEnumConverter.class, CommonConverter.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class ConverterConfig {

}
