package com.github.zhuque.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jwt 存储的内容
 * @author zhuque
 * @version 1.0
 * @date 2020/5/28 23:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUserInfo {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户账户
     */
    private String account;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户手机号
     */
    private String phone;
}
