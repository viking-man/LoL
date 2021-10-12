package com.viking.service.user.impl;

import com.viking.domain.user.entity.UserDTO;
import com.viking.domain.user.entity.UserRegistryDTO;
import com.viking.domain.user.impl.UserDomainService;
import com.viking.infrustructure.exception.BusinessException;
import com.viking.service.user.IUserService;
import com.viking.service.user.converter.UserServiceConverter;
import com.viking.service.user.entity.UserLoginVO;
import com.viking.service.user.entity.UserRegistryVO;
import com.viking.service.user.entity.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Service
public class UserService implements IUserService {

    @Resource
    private UserDomainService userDomainService;

    @Resource
    private UserServiceConverter userServiceConverter;

    @Override
    public UserVO registry(UserRegistryVO registryVO) throws BusinessException {

        UserRegistryDTO registryDTO = userServiceConverter.toUserDTO(registryVO);
        UserDTO userDTO = userDomainService.registry(registryDTO);
        return userServiceConverter.toUserVO(userDTO);
    }

    @Override
    public Boolean login(UserLoginVO userLoginVO) {

        return null;
    }
}
