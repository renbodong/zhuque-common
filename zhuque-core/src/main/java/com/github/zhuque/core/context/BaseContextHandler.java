package com.github.zhuque.core.context;

import cn.hutool.core.convert.Convert;
import com.github.zhuque.core.utils.StrPool;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取当前域中的 用户id appid 用户昵称
 * 注意： appid 通过token解析，  用户id 和 用户昵称必须在前端 通过请求头的方法传入。 否则这里无法获取
 *
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 1:07
 */
public class BaseContextHandler {
    private static final ThreadLocal<Map<String, String>> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 向当前域中设置值
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, Object value) {
        Map<String, String> map = getLocalMap();
        map.put(key, value == null ? StrPool.EMPTY : value.toString());
    }

    /**
     * 从当前域中获取值
     *
     * @param key  键
     * @param type 值类型的class
     * @param <T>  值类型
     * @return T类型对象
     */
    public static <T> T get(String key, Class<T> type) {
        Map<String, String> map = getLocalMap();
        return Convert.convert(type, map.get(key));
    }

    /**
     * 从当前域中获取值
     *
     * @param key  键
     * @param type 值类型的class
     * @param def  为从当前域中获取到,就返回该默认值
     * @param <T>  值类型
     * @return T类型对象
     */
    public static <T> T get(String key, Class<T> type, Object def) {
        Map<String, String> map = getLocalMap();
        return Convert.convert(type, map.getOrDefault(key, def == null ? StrPool.EMPTY : def.toString()));
    }

    /**
     * 从当前域中获取值
     *
     * @param key 键
     * @return String 类型值，未获取到返回空串
     */
    public static String get(String key) {
        Map<String, String> map = getLocalMap();
        return map.getOrDefault(key, StrPool.EMPTY);
    }


    /**
     * 获取当前线程的map<String,String>
     *
     * @return 当前线程的map
     */
    private static Map<String, String> getLocalMap() {
        Map<String, String> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(10);
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    /**
     * 设置当前线程的mao
     *
     * @param threadLocalMap 线程map
     */
    public static void setLocalMap(Map<String, String> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }

    /**
     * 移除当前线程的THREAD_LOCAL
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }

    /**
     * 从当前域中获取用户id
     *
     * @return Long 用户id
     */
    public static Long getUserId() {
        return get(BaseContextConstant.JWT_KEY_USR_ID, Long.class, 0L);
    }

    /**
     * 从当前域中获取用户id
     *
     * @return String 用户id
     */
    public static String getUserIdStr() {
        return getUserId().toString();
    }

    /**
     * 在当前域中设置用户id
     *
     * @param userId Long 用户id
     */
    public static void setUserId(Long userId) {
        set(BaseContextConstant.JWT_KEY_USR_ID, userId);
    }

    /**
     * 在当前域中存储用户id
     *
     * @param userId String 用户ID
     */
    public static void setUserId(String userId) {
        set(BaseContextConstant.JWT_KEY_USR_ID, userId);
    }

    /**
     * 在当前域中存储用户姓名
     *
     * @param name String 用户姓名
     */
    public static void setName(String name) {
        set(BaseContextConstant.JWT_KEY_NAME, name);
    }

    /**
     * 获取当前域中的用户姓名
     *
     * @return String 用户姓名
     */
    public static String getName() {
        return get(BaseContextConstant.JWT_KEY_NAME, String.class);
    }

    /**
     * 从当前域中获取账号
     *
     * @return String 用户账号
     */
    public static String getAccount() {
        return get(BaseContextConstant.JWT_KEY_ACCOUNT, String.class);
    }

    /**
     * 在当前域存储用户账号
     *
     * @param account String 用户账号
     */
    public static void setAccount(String account) {
        set(BaseContextConstant.JWT_KEY_ACCOUNT, account);
    }

    /**
     * 在当前域中存储token
     *
     * @param token String token
     */
    public static void setToken(String token) {
        set(BaseContextConstant.BEARER_HEADER_KEY, token);
    }

    /**
     * 从当前域中获取token
     *
     * @return String token
     */
    public static String getToken() {
        return get(BaseContextConstant.BEARER_HEADER_KEY, String.class);
    }

    /**
     * 从当前域中获取租户编码
     *
     * @param tenant String 租户编码
     */
    public static void setTenant(String tenant) {
        set(BaseContextConstant.JWT_KEY_TENANT, tenant);
    }

    /**
     * 从当前域中获取租户编码
     *
     * @return String 租户编码
     */
    public static String getTenant() {
        return get(BaseContextConstant.JWT_KEY_TENANT, String.class);
    }

    /**
     * 当前域中存储客户端id
     *
     * @param clientId String 客户端id
     */
    public static void setClientId(String clientId) {
        set(BaseContextConstant.JWT_KEY_CLIENT_ID, clientId);
    }

    /**
     * 从当前域中获取客户端id
     *
     * @return String 客户端id
     */
    public static String getClientId() {
        return get(BaseContextConstant.JWT_KEY_CLIENT_ID, String.class);
    }

    /**
     * 在当前域存储灰度发布版本号
     *
     * @param grayVersion String 灰度发布版本好
     */
    public static void setGrayVersion(String grayVersion) {
        set(BaseContextConstant.GRAY_VERSION, grayVersion);
    }

    /**
     * 从当前域中获取灰度发布版本号
     *
     * @return String 灰度发布版本号
     */
    public static String getGrayVersion() {
        return get(BaseContextConstant.GRAY_VERSION, String.class);
    }

}
