package com.viking.service.user;

import com.viking.service.user.entity.UserRegistryVO;
import com.viking.service.user.entity.UserVO;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
public interface IUserService {

    UserVO registry(UserRegistryVO registryVO);
}
