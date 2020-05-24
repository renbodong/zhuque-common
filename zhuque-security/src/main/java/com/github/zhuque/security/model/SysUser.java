package com.github.zhuque.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/16 21:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser{
    private static final long serialVersionUID = 4093750982772614899L;
    private Long id;
    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;
    /**
     * 组织id
     */
    private Long orgId;

    /**
     * 岗位id
     */
    private Long stationId;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 照片
     */
    private String photo;

    /**
     * 工作描述
     */
    private String workDescribe;

    /**
     * 登陆次数 一直累计
     */
    private Integer loginCount;

    /**
     * 当前登录用户的角色编码
     */
    private List<SysRole> roles;

    /**
     * 当前登录用户的资源编码
     */
    private List<String> resources;

    /**
     * 当前登录用户的组织架构
     */
    private SysOrg org;

    /**
     * 当前登录的岗位
     */
    private SysStation station;

}
