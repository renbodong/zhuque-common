package com.github.zhuque.jwt;

import cn.hutool.core.convert.Convert;
import com.github.zhuque.jwt.model.AuthInfo;
import com.github.zhuque.jwt.model.JwtUserInfo;
import com.github.zhuque.jwt.model.Token;
import com.github.zhuque.jwt.utils.JwtUtils;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static com.github.zhuque.core.context.BaseContextConstant.*;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/28 23:17
 */
@AllArgsConstructor
public class TokenUtils {
    /**
     * jwt配置
     */
    private JwtProperties jwtProperties;


    public AuthInfo createAuthInfo(JwtUserInfo jwtUserInfo, Long expireMills) {
        if (expireMills == null || expireMills <= 0) {
            expireMills = jwtProperties.getExpire();
        }

        //1.创建token
        Map<String, String> map = new HashMap<String, String>();
        map.put(JWT_KEY_TOKEN_TYPE, BEARER_HEADER_KEY);
        map.put(JWT_KEY_USR_ID, Convert.toStr(jwtUserInfo.getUserId(), ""));
        map.put(JWT_KEY_ACCOUNT, jwtUserInfo.getAccount());
        map.put(JWT_KEY_NAME, jwtUserInfo.getName());
        map.put(JWT_KEY_PHONE, jwtUserInfo.getPhone());
        Token token = JwtUtils.createJWT(map, expireMills);

        //2.利用生成的token信息构造AuthInfo对象

        AuthInfo info = AuthInfo.builder()
                .account(jwtUserInfo.getAccount())
                .name(jwtUserInfo.getName())
                .phone(jwtUserInfo.getPhone())
                .token(token.getToken())
                .userId(jwtUserInfo.getUserId())
                .tokenType(BEARER_HEADER_KEY)
                .expire(token.getExpire())
                .expiration(token.getExpireation())
                .refreshToken(createRefreshToken(jwtUserInfo).getToken()).build();

        return info;

    }


    /**
     * 创建刷新token
     *
     * @param jwtUserInfo jwtUserInfo
     * @return
     */
    private Token createRefreshToken(JwtUserInfo jwtUserInfo) {
        Map<String,String> map = new HashMap<>();
        map.put(JWT_KEY_TOKEN_TYPE,REFRESH_TOKEN_KEY);
        map.put(JWT_KEY_USR_ID,Convert.toStr(jwtUserInfo.getUserId()));
        return JwtUtils.createJWT(map,jwtProperties.getExpire());
    }
}
