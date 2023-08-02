package com.ilovesshan.common.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/2
 * @description:
 */

public class UuidUtil {
    public static String generator() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}