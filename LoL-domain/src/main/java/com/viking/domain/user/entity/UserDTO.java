package com.viking.domain.user.entity;

import com.viking.domain.base.BaseDTO;
import lombok.Data;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Data
public class UserDTO extends BaseDTO {

    private String username;

    private String password;

    private Integer accountType;
}
