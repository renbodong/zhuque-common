package com.github.zhuque.security.config;

import com.github.zhuque.core.utils.SpringUtils;
import com.github.zhuque.security.feign.UserResolverApi;
import com.github.zhuque.security.service.UserResolverService;
import com.github.zhuque.security.service.impl.UserResolverServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 15:09
 */
@Configuration
@ConditionalOnProperty(name = "zhuque.scan.type", havingValue = "FEIGN", matchIfMissing = true)
@EnableFeignClients(basePackages = "com.github.zhuque.security.feign",basePackageClasses = UserResolverApi.class)
public class UserResolveFeignConfiguration {
    @Bean
    @ConditionalOnMissingBean(value = UserResolverService.class)
    public UserResolverService getUserRoleService() {
        return new UserResolverServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(SpringUtils.class)
    public SpringUtils getSpringUtils(ApplicationContext applicationContext) {
        SpringUtils.setApplicationContext(applicationContext);
        return new SpringUtils();
    }
}
