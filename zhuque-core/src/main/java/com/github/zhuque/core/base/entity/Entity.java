package com.github.zhuque.core.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 实体基础父类
 *
 * @author zhuque
 * @version 1.0
 * @date 2020/5/31 20:11
 */
@Getter
@Setter
@Accessors(chain = true)
public class Entity<T> extends SuperEntity<T>{
    public static final String UPDATE_TIME = "updateTime";
    public static final String UPDATE_USER = "updateUser";

    private static final long serialVersionUID = -4513704843668714236L;

    @ApiModelProperty(value = "最后修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    protected LocalDateTime updateTime;

    @ApiModelProperty(value = "最后修改人")
    @TableField(value = "update_user", fill = FieldFill.UPDATE)
    protected T updateUser;
}
