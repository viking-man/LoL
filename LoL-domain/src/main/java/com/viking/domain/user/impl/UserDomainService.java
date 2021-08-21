package com.viking.domain.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.viking.dao.user.domain.UserDO;
import com.viking.dao.user.service.impl.UserServiceImpl;
import com.viking.domain.user.IUserDomainService;
import com.viking.domain.user.entity.UserDTO;
import com.viking.domain.user.entity.UserRegistryDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Service
public class UserDomainService implements IUserDomainService {

    @Resource
    private UserServiceImpl userService;


    @Override
    public UserDTO registry(UserRegistryDTO registryDTO) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserDO::getUserName,registryDTO)

        userService.selectOne()

        return null;
    }
}
