package com.github.zhuque.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 20:49
 */
public class SpringUtils {
    private static ApplicationContext applicationContext;
    private static ApplicationContext parentApplicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext ctx) {
        Assert.notNull(ctx, "SpringUtils injection ctx is null");
        applicationContext = ctx;
        parentApplicationContext = ctx.getParent();
    }

    public static Object getBean(String name) {
        Assert.hasText(name, "SpringUtils name is null or empty");
        try {
            return applicationContext.getBean(name);
        } catch (BeansException e) {
            return parentApplicationContext.getBean(name);
        }
    }

    public static <T> T getBean(String name, Class<T> type) {
        Assert.hasText(name, "SpringUtils name is null or empty");
        Assert.notNull(type,"SpringUtils type is null");
        try {
            return applicationContext.getBean(name,type);
        } catch (BeansException e) {
            return parentApplicationContext.getBean(name,type);
        }
    }

    public static <T> T getBean(Class<T> type){
        Assert.notNull(type,"SpringUtils type is null");
        try {
            return applicationContext.getBean(type);
        } catch (BeansException e) {
            return parentApplicationContext.getBean(type);
        }
    }

    public static <T> Map<String,T> getBeanOfType(Class<T> type){
        Assert.notNull(type,"SpringUtils type is null");
        try {
            return applicationContext.getBeansOfType(type);
        } catch (BeansException e) {
            return parentApplicationContext.getBeansOfType(type);
        }
    }

    public static ApplicationContext publishEvent(Object event){
        applicationContext.publishEvent(event);
        return applicationContext;
    }



}
