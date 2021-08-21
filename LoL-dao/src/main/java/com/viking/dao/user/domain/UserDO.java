package com.viking.dao.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.viking.dao.base.CommonDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表##
 * </p>
 *
 * @author auto
 * @since 2021-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lol_user")
public class UserDO extends CommonDO {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 账号类型
     */
    private Integer accountType;


}
