package com.viking.dao.user.service.impl;

import com.viking.dao.user.domain.UserDO;
import com.viking.dao.user.mapper.UserMapper;
import com.viking.dao.user.service.IUserDao;
import com.viking.dao.base.CommonServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表## 服务实现类
 * </p>
 *
 * @author auto
 * @since 2021-08-21
 */
@Service
public class UserDaoImpl extends CommonServiceImpl<UserMapper, UserDO> implements IUserDao {

}
