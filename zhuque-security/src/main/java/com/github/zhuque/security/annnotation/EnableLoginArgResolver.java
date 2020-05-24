package com.github.zhuque.security.annnotation;

import com.github.zhuque.security.config.LoginArgResolverConfig;
import com.github.zhuque.security.config.UserResolveFeignConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在启动类上添加该注解来----开启自动登录用户对象注入
 * Token转化SysUser
 *
 * @author zhuque
 * @version 1.0
 * @date 2020/5/16 19:07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({UserResolveFeignConfiguration.class,LoginArgResolverConfig.class})
public @interface EnableLoginArgResolver {
}
