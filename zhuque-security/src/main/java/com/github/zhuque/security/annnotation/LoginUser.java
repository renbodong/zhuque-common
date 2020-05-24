package com.github.zhuque.security.annnotation;

import java.lang.annotation.*;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/16 20:59
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser {
    /**
     * 是否查询SysUser的所有信息,true则通过rpc接口查询
     * @return
     */
    boolean isFull() default false;

    /**
     * 是否只查询角色信息，true则通过rpc接口查询
     * @return
     */
    boolean isRoles() default false;

    /**
     * 是否只查询组织信息，true则通过rpc接口查询
     * @return
     */
    boolean isResource() default false;

    /**
     * 是否只查询岗位信息，true则通过rpc接口查询
     */
    boolean isStation() default false;
}
