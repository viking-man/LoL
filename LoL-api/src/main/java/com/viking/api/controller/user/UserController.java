package com.viking.api.controller.user;

import com.viking.infrustructure.exception.BusinessException;
import com.viking.service.user.entity.UserLoginVO;
import com.viking.service.user.entity.UserRegistryVO;
import com.viking.service.user.entity.UserVO;
import com.viking.service.user.impl.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/registry")
    public UserVO registryUser(@RequestBody UserRegistryVO userRegistryVO) throws BusinessException {

        return userService.registry(userRegistryVO);
    }

    @PostMapping("/user/login")
    public Boolean userLogin(@RequestBody UserLoginVO userLoginVO) throws BusinessException {

        return userService.login(userLoginVO);
    }
}
