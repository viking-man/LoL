package com.viking.service.user.entity;

import com.viking.service.base.BaseVO;
import lombok.Data;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Data
public class UserVO extends BaseVO {

    private String username;

    private String password;

    private Integer accountType;
}
