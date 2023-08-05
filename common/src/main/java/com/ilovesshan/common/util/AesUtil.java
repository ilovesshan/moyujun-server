package com.ilovesshan.common.util;

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

    public static final String secretKey = "MIICdQIBADANBgkqhkiG9";
    public static final String AES = "AES";
    public static final String charsetName = "UTF-8";

    public static SecretKeySpec generateKey(String password) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        keyGenerator.init(128, random);
        SecretKey originalKey = keyGenerator.generateKey();
        return new SecretKeySpec(originalKey.getEncoded(), AES);
    }

    public static String aESEncode(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, generateKey(password));
            byte[] bytes = cipher.doFinal(content.getBytes(charsetName));
            return Base64.getUrlEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String aESDecode(String content, String password) {
        try {
            byte[] bytes = Base64.getUrlDecoder().decode(content);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, generateKey(password));
            byte[] result = cipher.doFinal(bytes);
            return new String(result, charsetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encrypt(String content) {
        return aESEncode(aESEncode(content, secretKey), secretKey);
    }

    public static String decrypt(String content) {
        return aESDecode(aESDecode(content, secretKey), secretKey);
    }
}