package com.github.zhuque.core.context;

/**
 * 常量定义
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 12:33
 */
public class BeanContextConstant {
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
