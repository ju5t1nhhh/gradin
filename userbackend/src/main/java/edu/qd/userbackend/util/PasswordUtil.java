package edu.qd.userbackend.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtil {

    private final static String algorithmName = "md5";

    private final static int hashIterations = 2;

    public static String encryptPassword(String salt, String password) {
        String newPassword = new SimpleHash(algorithmName,password,salt,hashIterations).toHex();
        return newPassword;
    }

}
