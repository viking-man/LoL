package com.viking.api.controller.user;

import com.viking.api.controller.user.entity.UserRegistryVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@RestController("/user")
public class UserController {

    @PostMapping("/registry")
    public String registryUser(@RequestBody UserRegistryVO userRegistryVO) {


        return "Hello World!";
    }
}
