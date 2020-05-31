package com.github.zhuque.jwt.utils;

import com.github.zhuque.core.context.BaseContextConstant;
import com.github.zhuque.jwt.model.JwtUserInfo;
import com.github.zhuque.jwt.model.Token;
import com.google.common.base.Charsets;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.Data;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/28 23:48
 */
public class JwtUtils {

    /**
     * jwt签名进行base64编码
     */
    private static final String BASE64_SECURITY = Base64.getEncoder().encodeToString(BaseContextConstant.JWT_SIGN_KEY.getBytes(Charsets.UTF_8));

    /**
     * 创建令牌
     *
     * @param user        user
     * @param expireMills 有效时间
     * @return jwt
     */
    public static Token createJWT(Map<String, String> user, Long expireMills) {
        //1.定义签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills);

        //2.生成签名密钥
        byte[] apiSecretBytes = Base64.getDecoder().decode(BASE64_SECURITY);
        Key secretKeySpec = new SecretKeySpec(apiSecretBytes, signatureAlgorithm.getJcaName());

        //3.添加构成jwt的类
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JsonWebToken").signWith(signatureAlgorithm, secretKeySpec);

        //4.设置jwt参数
        user.forEach(builder::claim);

        //5.添加token的过期时间
        long expires = nowMills + expireMills * 1000;
        Date exp = new Date(expires);
        builder.setExpiration(exp).setNotBefore(now);

        //6.组装token信息
        return Token.builder().token(builder.compact()).expire(expires).expireation(exp).build();

    }


}
