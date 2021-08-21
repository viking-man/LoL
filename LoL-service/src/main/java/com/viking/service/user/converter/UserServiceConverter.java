package com.viking.service.user.converter;

import com.viking.dao.user.domain.UserDO;
import com.viking.domain.user.entity.UserDTO;
import com.viking.domain.user.entity.UserRegistryDTO;
import com.viking.infrustructure.config.ConverterConfig;
import com.viking.service.user.entity.UserRegistryVO;
import com.viking.service.user.entity.UserVO;
import org.mapstruct.Mapper;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Mapper(config = ConverterConfig.class)
public interface UserServiceConverter {

    UserRegistryDTO toUserDTO(UserRegistryVO userRegistryVO);

    UserVO toUserVO(UserDTO userDTO);
}
