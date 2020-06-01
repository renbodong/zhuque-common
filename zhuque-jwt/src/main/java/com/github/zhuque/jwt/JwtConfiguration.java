package com.github.zhuque.jwt;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/28 23:00
 */
@EnableConfigurationProperties(value = {JwtProperties.class})
public class JwtConfiguration {
    @Bean
    public TokenUtils getTokenUtil(JwtProperties authServerProperties) {
        return new TokenUtils(authServerProperties);
    }
}
