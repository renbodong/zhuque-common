package com.github.zhuque.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/16 21:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysOrg implements Serializable{
    private static final long serialVersionUID = -7207537552693423353L;
    private Long id;
    /**
     * 名称
     */
    private String label;
    /**
     * 简称
     */
    private String abbreviation;
    /**
     * 父id
     */
    private Long parentId;
    /**
     * 排序
     */
    private Integer softValue;
    /**
     * 状态
     */
    private Boolean status;
    /**
     * 描述
     */
    private String describe;

}
