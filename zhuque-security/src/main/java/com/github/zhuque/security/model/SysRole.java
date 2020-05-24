package com.github.zhuque.security.model;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/16 21:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRole{
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 描述
     */
    private String describe;
    /**
     * 是否启用
     */
    private Boolean isEnable;
    /**
     * 是否只读角色
     */
    private Boolean isRead;

    /**
     * 角色列表转换成角色编码列表
     * @param list 角色列表
     * @return list<String> 角色编码列表
     */
    public static List<String> getRoleCode(List<SysRole> list){
        if(ArrayUtil.isEmpty(list)){
            return Collections.emptyList();
        }
        return list.stream().map(SysRole::getCode).collect(Collectors.toList());
    }

    /**
     * 指定角色编码是否存在于角色列表中
     * @param list
     * @param code
     * @return
     */
    public static boolean contains(List<SysRole> list,String code){
        if(ArrayUtil.isEmpty(list) || StrUtil.isEmpty(code)){
            return false;
        }
        return list.stream().anyMatch(item->code.equals(item.getCode()));
    }



}
