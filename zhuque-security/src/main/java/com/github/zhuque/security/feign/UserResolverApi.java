package com.github.zhuque.security.feign;

import com.github.zhuque.core.base.R;
import com.github.zhuque.security.feign.UserQuery;
import com.github.zhuque.security.feign.fallback.UserResolverApiFallBack;
import com.github.zhuque.security.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 15:27
 */
@FeignClient(name = "${zhuque.feign.oauth-server:zhuque-oauth-server}",path = "/user",fallback =
        UserResolverApiFallBack.class)
public interface UserResolverApi {
    @PostMapping(value = "/anno/id/{id}")
    R<SysUser> getById(@PathVariable("id") Long id, @RequestBody UserQuery userQuery);
}
