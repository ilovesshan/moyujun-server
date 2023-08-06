package com.ilovesshan.common.util;

import com.ilovesshan.common.constants.Constants;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

public class AesUtil {

    public static SecretKeySpec generateKey(String password) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(Constants.AesKey.AES);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        keyGenerator.init(128, random);
        SecretKey originalKey = keyGenerator.generateKey();
        return new SecretKeySpec(originalKey.getEncoded(), Constants.AesKey.AES);
    }

    public static String aESEncode(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(Constants.AesKey.AES);
            cipher.init(Cipher.ENCRYPT_MODE, generateKey(password));
            byte[] bytes = cipher.doFinal(content.getBytes(Constants.AesKey.CHARSET_NAME));
            return Base64.getUrlEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String aESDecode(String content, String password) {
        try {
            byte[] bytes = Base64.getUrlDecoder().decode(content);
            Cipher cipher = Cipher.getInstance(Constants.AesKey.AES);
            cipher.init(Cipher.DECRYPT_MODE, generateKey(password));
            byte[] result = cipher.doFinal(bytes);
            return new String(result, Constants.AesKey.CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encrypt(String content) {
        return aESEncode(aESEncode(content, Constants.AesKey.SECRET_KEY), Constants.AesKey.SECRET_KEY);
    }

    public static String decrypt(String content) {
        return aESDecode(aESDecode(content, Constants.AesKey.SECRET_KEY), Constants.AesKey.SECRET_KEY);
    }
}