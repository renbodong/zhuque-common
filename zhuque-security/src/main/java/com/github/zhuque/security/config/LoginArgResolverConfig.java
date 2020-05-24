package com.github.zhuque.security.config;

import com.github.zhuque.security.resolver.ContextArgResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 自定义参数解析器
 *
 * @author zhuque
 * @version 1.0
 * @date 2020/5/16 19:17
 */
public class LoginArgResolverConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ContextArgResolver());
    }
}
