package com.github.zhuque.core.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

import java.util.stream.Stream;

/**
 * 字符串工具类
 * @author zhuque
 * @version 1.0
 * @date 2020/6/1 1:02
 */
public class StrHelper {
    /**
     * 有 任意 一个 Blank
     *
     * @param css CharSequence
     * @return boolean
     */
    public static boolean isAnyBlank(final CharSequence... css) {
        if (ObjectUtil.isEmpty(css)) {
            return true;
        }
        return Stream.of(css).anyMatch(StrUtil::isBlank);
    }
}
