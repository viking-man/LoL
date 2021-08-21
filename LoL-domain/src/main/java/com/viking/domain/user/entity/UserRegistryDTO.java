package com.viking.domain.user.entity;

import com.viking.domain.base.BaseDTO;
import lombok.Data;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Data
public class UserRegistryDTO extends BaseDTO {

    /**
     * 1:手机 2:邮箱
     */
    private Integer accountType;

    private String username;

    private String password;

    private String nickname;
}
