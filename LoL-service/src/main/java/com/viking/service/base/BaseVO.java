package com.viking.service.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Data
public class BaseVO implements Serializable {

    /**
     * sessionId
     */
    private String sid;
}
