package me.hao0.alipay.model.enums;

/**
 * 签名方式
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 11/11/15
 */
public enum SignType {

    MD5("MD5"),

    DSA("DSA"),

    RSA("RSA");

    private String value;

    private SignType(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
