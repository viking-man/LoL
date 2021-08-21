package com.viking.infrustructure.util;

/**
 * 主键ID生成器
 *
 * @author victor.han
 */
public final class PrimaryIdGenerator {

    private PrimaryIdGenerator() {
    }

    /**
     * 生成全局唯一的Id
     *
     * @return
     */
    /**
     * 获得数值型主键
     *
     * @return
     */
    public static String generateId() {
        return String.valueOf(SnowFlakeUuId.nextId());
    }

}
