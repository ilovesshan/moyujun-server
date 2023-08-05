package com.ilovesshan.common.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

public class SystemUtil {
    /**
     * 当前系统环境是否是 windows
     *
     * @return boolean
     */
    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("win");
    }
}