package com.github.zhuque.security.feign.fallback;

import com.github.zhuque.core.base.R;
import com.github.zhuque.security.feign.UserQuery;
import com.github.zhuque.security.feign.UserResolverApi;
import com.github.zhuque.security.model.SysUser;
import org.springframework.stereotype.Component;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 15:29
 */
@Component
public class UserResolverApiFallBack implements UserResolverApi {
    @Override
    public R<SysUser> getById(Long id, UserQuery userQuery) {
        return R.timeout();
    }
}
