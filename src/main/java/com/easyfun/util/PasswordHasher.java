package com.easyfun.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author     ：李冠良
 * @description：
    无描述
 * @date       ：2024/12/29 下午4:33
 */

public class PasswordHasher {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}