package com.github.zhuque.security.service;

import com.github.zhuque.core.base.R;
import com.github.zhuque.core.context.BaseContextHandler;
import com.github.zhuque.security.feign.UserQuery;
import com.github.zhuque.security.model.SysUser;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 15:36
 */
public interface UserResolverService {
    R<SysUser> getById(Long id, UserQuery userQuery);

    default R<SysUser> getById(UserQuery userQuery){
        return getById(BaseContextHandler.getUserId(),userQuery);
    }
}
