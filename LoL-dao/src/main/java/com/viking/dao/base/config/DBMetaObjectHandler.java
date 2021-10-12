package com.viking.dao.base.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.tuya.zhurong.infrastructure.common.domain.UserSession;
import com.tuya.zhurong.infrastructure.context.SessionContextHolder;
import com.tuya.zhurong.infrastructure.util.StringUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;

/**
 * 自动填充处理
 * @author wyj
 * @since 2020/10/26
 */
public class DBMetaObjectHandler implements MetaObjectHandler {
    /**
     * 创建时间
     */
    private static String  GMT_CREATE = "gmtCreate";
    /**
     * 修改时间
     */
    private static String GMT_MODIFIED = "gmtModified";
    /**
     * 创建人
     */
    private static String  CREATOR = "creator";
    /**
     * 修改人
     */
    private static String MODIFIER = "modifier";
    /**
     * 项目名称
     */
    private static final String PROJECT = "lol";
    /**
     * 所属环境
     */
    private static String ENV = "env";
    @Value("${runtime.env:dev}")
    private String runtimeEnv;
    @Override
    public void insertFill(MetaObject metaObject) {
        long mowTime = Instant.now().toEpochMilli();
        UserSession userSession = SessionContextHolder.get();
        String uid = userSession == null || StringUtil.isBlank(userSession.getUid()) ? PROJECT : SessionContextHolder.getUid();
        this.strictInsertFill(metaObject, GMT_CREATE, Long.class, mowTime);
        this.strictInsertFill(metaObject, GMT_MODIFIED, Long.class, mowTime);
        this.strictInsertFill(metaObject, CREATOR, String.class, uid);
        this.strictInsertFill(metaObject, MODIFIER, String.class, uid);
        this.strictInsertFill(metaObject, ENV, String.class, runtimeEnv);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, GMT_MODIFIED, Long.class, Instant.now().toEpochMilli());
        UserSession userSession = SessionContextHolder.get();
        String uid = userSession == null || StringUtil.isBlank(userSession.getUid()) ? PROJECT : SessionContextHolder.getUid();
        this.strictUpdateFill(metaObject, MODIFIER, String.class, uid);
    }
}
