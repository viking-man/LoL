package com.viking.domain.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.viking.dao.user.domain.UserDO;
import com.viking.dao.user.service.impl.UserDaoImpl;
import com.viking.domain.user.IUserDomainService;
import com.viking.domain.user.converter.UserConverter;
import com.viking.domain.user.entity.UserDTO;
import com.viking.domain.user.entity.UserRegistryDTO;
import com.viking.infrustructure.exception.BusinessException;
import com.viking.infrustructure.util.PrimaryIdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Service
public class UserDomainService implements IUserDomainService {

    @Resource
    private UserDaoImpl userDao;

    @Resource
    private UserConverter userConverter;

    @Override
    public UserDTO registry(UserRegistryDTO registryDTO) throws BusinessException {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserDO::getUserName, registryDTO.getUsername());
        UserDO userDO = userDao.selectOne(queryWrapper);
        if (!Objects.isNull(userDO)) {
            throw new BusinessException("用户名已经被使用");
        }

        userDO = new UserDO();
        userDO.setAccountType(registryDTO.getAccountType());
        userDO.setPassword(registryDTO.getPassword());
        userDO.setUserId(PrimaryIdGenerator.generateId());
        userDO.setUserName(registryDTO.getUsername());
        userDO.setNickName(registryDTO.getNickname());

        boolean save = userDao.save(userDO);
        if (save) {
            return userConverter.toUserDTO(userDO);
        } else {
            throw new BusinessException("数据库异常");
        }
    }
}
