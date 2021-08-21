package com.viking.domain.user;

import com.viking.domain.user.entity.UserDTO;
import com.viking.domain.user.entity.UserRegistryDTO;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
public interface IUserDomainService {

    UserDTO registry(UserRegistryDTO registryDTO);
}
