package com.viking.domain.user.converter;

import com.viking.dao.user.domain.UserDO;
import com.viking.domain.user.entity.UserDTO;
import com.viking.infrustructure.config.ConverterConfig;
import org.mapstruct.Mapper;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Mapper(config = ConverterConfig.class)
public interface UserConverter {

    UserDTO toUserDTO(UserDO userDO);
}
