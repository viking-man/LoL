package com.viking.dao.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wyj
 * @since 2020/10/20
 */
public class CommonServiceImpl<M extends BaseMapper<T>, T extends CommonDO> extends ServiceImpl<M, T> implements CommonService<T> {

    @Autowired(required = false)
    protected CommonMapper<T> commonMapper;
    /**
     * 由Apollo注入Env参数
     */
    @Value("${runtime.env:dev}")
    protected String runtimeEnv;
    /**
     * 环境参数
     */
    private static final String ENV_PARAMETER = "env";

    @Override
    public List<T> selectList(QueryWrapper<T> queryWrapper) {
        if (queryWrapper == null) {
            queryWrapper = getQueryWrapper(null);
        } else if (queryWrapper.getExpression().getNormal().stream().filter(e -> e.getSqlSegment().equals(ENV_PARAMETER)).collect(Collectors.toList()).size() == 0) {
            queryWrapper.eq(ENV_PARAMETER, runtimeEnv);
        }
        return commonMapper.selectList(queryWrapper);

    }

    @Override
    public T selectOne(QueryWrapper<T> queryWrapper) {
        if (queryWrapper == null) {
            queryWrapper = getQueryWrapper(null);
        } else if (queryWrapper.getExpression().getNormal().stream().filter(e -> e.getSqlSegment().equals(ENV_PARAMETER)).collect(Collectors.toList()).size() == 0) {
            queryWrapper.eq(ENV_PARAMETER, runtimeEnv);
        }
        return super.getOne(queryWrapper);
    }

    @Override
    public List selectList(QueryWrapper<T> queryWrapper, Class<?> targetClass) {
        List<T> list = commonMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public QueryWrapper<T> getQueryWrapper(T entity) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(entity);
        queryWrapper.eq(ENV_PARAMETER, runtimeEnv);
        return queryWrapper;
    }

    public T setDefaultValue(T entity) {
        entity.setEnv(runtimeEnv);
        entity.setGmtCreate(System.currentTimeMillis());
        entity.setStatus(true);
        return entity;
    }

}
