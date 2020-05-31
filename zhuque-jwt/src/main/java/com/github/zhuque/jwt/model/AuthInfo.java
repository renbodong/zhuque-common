package com.github.zhuque.jwt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/28 23:22
 */
@Data
@Accessors(chain = true)
@ApiModel("认证信息")
@Builder
public class AuthInfo {
    /**
     * 令牌
     */
    @ApiModelProperty(value = "令牌")
    private String token;
    /**
     * 令牌类型
     */
    @ApiModelProperty(value = "令牌类型")
    private String tokenType;
    /**
     * 刷新令牌
     */
    @ApiModelProperty(value = "刷新令牌")
    private String refreshToken;
    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String name;
    /**
     * 用户账户
     */
    @ApiModelProperty(value = "用户账户")
    private String account;
    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    private String phone;
    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String avator;
    /**
     * 用户工作描述
     */
    @ApiModelProperty(value = "工作描述")
    private String workDescribe;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 过期时间
     */
    @ApiModelProperty(value = "过期时间")
    private long expire;
    /**
     * 到期时间
     */
    @ApiModelProperty(value = "到期时间")
    private Date expiration;
}
