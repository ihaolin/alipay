package me.hao0.alipay.core;

import me.hao0.alipay.model.enums.PayMethod;
import me.hao0.alipay.model.enums.PaymentType;

/**
 * The Alipay builder
 */
public final class AlipayBuilder {

    private Alipay alipay;

    public static AlipayBuilder newBuilder(String merchantId, String secret) {
        AlipayBuilder builder = new AlipayBuilder();
        builder.alipay = new Alipay(merchantId, secret);
        return builder;
    }

    /**
     * 仅需要APP支付时，可以不配置secret
     * @param merchantId 商户编号
     * @return this builder
     */
    public static AlipayBuilder newBuilder(String merchantId) {
        return newBuilder(merchantId, "");
    }

    /**
     * Set email account
     * @param email email account
     * @return this
     */
    public AlipayBuilder email(String email) {
        alipay.email = email;
        return this;
    }

    /**
     * Set the charset of the merchant，ex. utf-8、gbk、gb2312，default is utf-8
     * @param charset charset
     * @return this
     */
    public AlipayBuilder inputCharset(String charset) {
        alipay.inputCharset = charset;
        return this;
    }

    /**
     * Set the Payment type
     * @see me.hao0.alipay.model.enums.PaymentType
     * @param type the payment type
     * @return this
     */
    public AlipayBuilder paymentType(PaymentType type) {
        alipay.paymentType = type.value();
        return this;
    }

    /**
     * 设置支付超时时间，默认1h
     *
     * @param time 一旦超时，该笔交易就会自动被关闭。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。该参数数值不接受小数点，如1.5h，可转换为90m。
     * @return this
     */
    public AlipayBuilder expired(String time) {
        alipay.expired = time;
        return this;
    }

    /**
     * 设置默认支付方式，默认BUY
     *
     * @param method 支付方式
     * @return this
     */
    public AlipayBuilder payMethod(PayMethod method) {
        alipay.payMethod = method.value();
        return this;
    }

    /**
     * 设置APP RSA私钥
     * @param rsaPriKey RSA私钥
     * @return this
     */
    public AlipayBuilder appPriKey(String rsaPriKey){
        alipay.appPriKey = rsaPriKey;
        return this;
    }

    /**
     * 设置APP RSA公钥
     * @param rsaPubKey RSA公钥
     * @return this
     */
    public AlipayBuilder appPubKey(String rsaPubKey){
        alipay.appPubKey = rsaPubKey;
        return this;
    }

    /**
     * 设置二维码RSA私钥
     * @param rsaPriKey RSA私钥
     * @return this
     */
    public AlipayBuilder qrPriKey(String rsaPriKey){
        alipay.qrPriKey = rsaPriKey;
        return this;
    }

    /**
     * 设置二维码 RSA公钥
     * @param rsaPubKey RSA公钥
     * @return this
     */
    public AlipayBuilder qrPubKey(String rsaPubKey){
        alipay.qrPubKey = rsaPubKey;
        return this;
    }

    /**
     * 设置支付超时时间
     * @param payExpired 超时时间
     * @return this
     */
    public AlipayBuilder payExpired(String payExpired){
        alipay.expired = payExpired;
        return this;
    }

    public Alipay build() {
        return alipay.start();
    }
}