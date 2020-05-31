package com.github.zhuque.jwt.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/28 23:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    /**
     * 令牌
     */
    private String token;
    /**
     * 有效时间
     */
    private Long expire;
    /**
     * 过期时间
     */
    private Date expireation;
}
