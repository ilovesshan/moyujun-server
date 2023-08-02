package com.ilovesshan.common.util;

import java.security.SecureRandom;
import java.util.Random;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/2
 * @description:
 */

public class RandomUtil {
    private static final String SYMBOLS = "0123456789";
    private static final Random RANDOM = new SecureRandom();

    public static String getRandomStr(int length) {
        char[] nonceChars = new char[length];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
}
