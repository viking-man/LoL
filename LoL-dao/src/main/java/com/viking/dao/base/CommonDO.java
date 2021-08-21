package com.viking.dao.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@Data
public class CommonDO implements Serializable {

    /**
     * 主键
     */

    private Long id;
    /**
     * 设备记录有效状态
     */
    @TableLogic(value = "1", delval = "0")
    private Boolean status;

    /**
     * 所属发布环境
     */
    @TableField(fill = FieldFill.INSERT)
    private String env;

    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String creator;

    /**
     * 修改者
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifier;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long gmtCreate;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long gmtModified;
}
