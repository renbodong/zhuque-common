package com.github.zhuque.security.resolver;

import cn.hutool.core.util.ObjectUtil;
import com.github.zhuque.core.base.R;
import com.github.zhuque.core.context.BeanContextHandler;
import com.github.zhuque.core.utils.SpringUtils;
import com.github.zhuque.security.annnotation.LoginUser;
import com.github.zhuque.security.feign.UserQuery;
import com.github.zhuque.security.model.SysUser;
import com.github.zhuque.security.service.UserResolverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * token转换为SysUser
 * <p>
 * HandlerMethodArgumentResolver 处理函数参数的处理器
 *
 * @author zhuque
 * @version 1.0
 * @date 2020/5/16 19:20
 */
@Slf4j
public class ContextArgResolver implements HandlerMethodArgumentResolver {
    /**
     * 支持的参数
     * 可以设置一些标志，表示你这个分解器可以处理这些参数，返回ture才执行resolveArgument()函数
     *
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasMethodAnnotation(LoginUser.class) && methodParameter.getParameterType().equals
                (SysUser.class);
    }

    /**
     * 分解实参
     *
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        Long userId = BeanContextHandler.getUserId();
        String account = BeanContextHandler.getAccount();
        String name = BeanContextHandler.getName();

        SysUser sysUser = SysUser.builder().id(userId).account(account).name(name).build();
        try {
            //获取参数上的注解
            LoginUser loginUser = methodParameter.getParameterAnnotation(LoginUser.class);
            boolean isQuery = loginUser.isFull() || loginUser.isResource() || loginUser.isRoles() || loginUser.isStation();
            if (isQuery) {
                UserResolverService userResolverService = SpringUtils.getBean(UserResolverService.class);
                R<SysUser> result = userResolverService.getById(UserQuery.builder()
                        .full(loginUser.isFull())
                        .org(loginUser.isResource())
                        .resource(loginUser.isResource())
                        .roles(loginUser.isRoles())
                        .station(loginUser.isStation()).build());
                if (result.getIsSuccess() && ObjectUtil.isEmpty(result.getData())) {
                    return result.getData();
                }

            }
        } catch (Exception e) {
            log.warn("注入登录人信息，发生异常. --> {}", sysUser, e);
        }

        return sysUser;
    }
}
