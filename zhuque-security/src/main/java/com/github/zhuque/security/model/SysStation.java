package com.github.zhuque.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/16 21:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysStation {
    public static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 组织id
     */
    private Long orgId;
    /**
     * 排序
     */
    private Integer sortValue;
    /**
     * 状态
     */
    private Boolean status;
    /**
     * 描述
     */
    private String describe;

}
