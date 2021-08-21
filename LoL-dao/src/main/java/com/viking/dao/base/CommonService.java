package com.viking.dao.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

/**
 * @author wyj
 * @since 2020/10/20
 */
public interface CommonService<T>{
    /**
     * 查询列表
     * @param query
     * @return
     */
    List<T> selectList(QueryWrapper<T> query);


    /**
     * 查询列表
     * @param query
     * @return
     */
    T selectOne(QueryWrapper<T> query);


    /**
     * 查询列表并按照指定类型转换
     * @param query
     * @param targetClass
     * @return
     */
    List selectList(QueryWrapper<T> query,Class<?> targetClass);


    /**
     * 获取查询条件（默认status=1 and env=runtimeEnv）
     * @param entity
     * @return
     */
    QueryWrapper<T> getQueryWrapper(T entity);
}
