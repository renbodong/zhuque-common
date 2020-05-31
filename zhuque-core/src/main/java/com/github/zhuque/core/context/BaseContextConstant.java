package com.github.zhuque.core.context;

/**
 * 常量定义
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 12:33
 */
public class BaseContextConstant {
    /**
     * jwt封装的用户id
     */
    public static final String JWT_KEY_USR_ID = "userid";

    /**
     * jwt封装的用户姓名
     */
    public static final String JWT_KEY_NAME = "name";

    /**
     * jwt封装的用户账号
     */
    public static final String JWT_KEY_ACCOUNT = "account";
    /**
     * jwt封装的用户手机号
     */
    public static final String JWT_KEY_PHONE = "phone";

    /**
     * JWT token 签名
     */
    public static final String JWT_SIGN_KEY = "zhuque";

    /**
     * JWT中封装的 token 类型
     */
    public static final String JWT_KEY_TOKEN_TYPE = "token_type";

    /**
     * 刷新 Token
     */
    public static final String REFRESH_TOKEN_KEY = "refresh_token";

    /**
     * jwt封装的租户编码
     */
    public static final String JWT_KEY_TENANT = "tenant";

    /**
     * jwt封装的 客户端id
     */
    public static final String JWT_KEY_CLIENT_ID = "client_id";

    /**
     * user信息
     * 认证请求头
     */
    public static final String BEARER_HEADER_KEY = "token";

    /**
     * 灰度发布版本号
     */
    public static final String GRAY_VERSION = "garyversion";
}
