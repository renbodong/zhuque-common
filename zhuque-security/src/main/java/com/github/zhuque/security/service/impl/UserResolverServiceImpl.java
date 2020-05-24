package com.github.zhuque.security.service.impl;

import com.github.zhuque.core.base.R;
import com.github.zhuque.security.feign.UserQuery;
import com.github.zhuque.security.feign.UserResolverApi;
import com.github.zhuque.security.model.SysUser;
import com.github.zhuque.security.service.UserResolverService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 17:05
 */
public class UserResolverServiceImpl implements UserResolverService {
    @Autowired
    private UserResolverApi userResolverApi;
    @Override
    public R<SysUser> getById(Long id, UserQuery userQuery) {
        return userResolverApi.getById(id,userQuery);
    }
}
