package com.viking.dao.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
public interface CommonMapper<T> extends BaseMapper<T> {

    /**
     * 查询符合条件的所有数据
     *
     * @param queryWrapper
     * @return
     */
    default List<T> selectAll(Wrapper<T> queryWrapper) {
        return selectAll(queryWrapper, Integer.MAX_VALUE);
    }

    /**
     * 查询符合条件的所有数据
     *
     * @param queryWrapper
     * @param maxSize
     * @return
     */
    default List<T> selectAll(Wrapper<T> queryWrapper, Integer maxSize) {
        if (Objects.isNull(queryWrapper)) {
            return new ArrayList<>();
        }
        int maxTotal = Objects.isNull(maxSize) ? 1000 : maxSize;
        Page<T> page = this.selectPage(new Page<T>(0, maxTotal), queryWrapper);
        int total = (int) page.getTotal();
        List<T> record = new ArrayList<T>(Math.min(total, maxTotal));
        while (true) {
            record.addAll(page.getRecords());
            if (record.size() >= total) {
                break;
            }
            page = this.selectPage(new Page<T>(record.size(), maxTotal - record.size()), queryWrapper);
        }
        return record;
    }

    /**
     * 查询第一笔数据
     *
     * @param queryWrapper
     * @return
     */
    default T selectFirst(Wrapper<T> queryWrapper) {
        Page<T> page = this.selectPage(new Page<T>(1, 1), queryWrapper);
        List<T> list = page.getRecords();
        return (list != null && !list.isEmpty()) ? list.get(0) : null;
    }
}
