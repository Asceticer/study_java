package com.asceticer.study;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/4/8 16:16
 * @Version: 1.0
 */
public class T {

    public static void main(String[] args) throws UnsupportedEncodingException {
       /*String[] s = "110.168.1.18".split("\\.");
        byte[] b =new byte[4];
        for (int i=0; i<4;i++) {
            b[i] = (byte)Integer.parseInt(s[i]);
        }
*/
        List list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(12);
        Object a = list.stream().collect(Collectors.toList());
        System.out.println(a);

    }

    public static String bytesToHexString(byte[] bArray){

            StringBuffer sb = new StringBuffer(bArray.length);
            for (int i = 0; i < bArray.length; i++) {
                sb.append(ByteToHexString(bArray[i]));
            }
            return sb.toString();

    }

    public static final String ByteToHexString(byte bte) {
        String sTemp = Integer.toHexString(0xFF & bte);
        if (sTemp.length() < 2) {
            sTemp = "0" + sTemp.toUpperCase();
        }
        return sTemp;
    }
}
