package com.viking.service.user.entity;


import com.viking.service.base.BaseVO;
import lombok.Data;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Data
public class UserLoginVO extends BaseVO {

    /**
     * 1:手机 2:邮箱
     */
    private Integer accountType;

    private String username;

    private String password;
}
