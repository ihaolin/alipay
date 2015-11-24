package me.hao0.alipay.model.enums;

/**
 * 支付类型
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 11/11/15
 */
public enum PaymentType {

    /**
     * buy the item
     */
    BUY("1"),

    /**
     * donate
     */
    DONATE("47"),

    /**
     * coupon
     */
    CARD_COUPON("47");

    private String value;

    private PaymentType(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
