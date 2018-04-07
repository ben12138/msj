package com.jlkj.msj.uitl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class EncryptionUtil {
    private EncryptionUtil(){}
    /**
     * @Des 得到相应的一个MD5加密后的字符串
     * @param psd
     * @param salt
     * @return    MD5加密后的字符串
     */
    public static String encoder(String psd, String salt) {
        try {
            StringBuffer stingBuffer = new StringBuffer();
            // 1.指定加密算法
            MessageDigest digest = MessageDigest.getInstance("MD5");
            // 2.将需要加密的字符串转化成byte类型的数据，然后进行哈希过程
            byte[] bs = digest.digest((psd + salt).getBytes());
            // 3.遍历bs,让其生成32位字符串，固定写法

            // 4.拼接字符串
            for (byte b : bs) {
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stingBuffer.append(hexString);
            }
            return stingBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到随机的盐
     * @return
     */
    public static String getSalt(){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0;i < 4;i++){
            sb.append(base.charAt(random.nextInt(base.length())));
        }
        return new String(sb);
    }
}
