package com.github.zhuque.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.github.zhuque.jwt.JwtProperties.PREFIX;


/**
 * jwt配置类
 * @author zhuque
 * @version 1.0
 * @date 2020/5/28 23:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = PREFIX)
public class JwtProperties {
    public static final String PREFIX = "authentication";
    /**
     * token过期时间
     */
    private Long expire;
    /**
     * token刷新过期时间
     */
    private Long refreshExpire;
}
