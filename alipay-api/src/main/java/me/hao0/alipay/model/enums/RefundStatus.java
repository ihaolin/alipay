package me.hao0.alipay.model.enums;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 11/11/15
 */
public enum RefundStatus {

    /**
     退款成功:
         全额退款情况：trade_status = TRADE_CLOSED，而refund_status=REFUND_SUCCESS；
         非全额退款情况：trade_status = TRADE_SUCCESS，而refund_status=REFUND_SUCCESS
     */
    REFUND_SUCCESS("REFUND_SUCCESS"),

    /**
     * 退款关闭
     */
    REFUND_CLOSED("REFUND_CLOSED");

    private String value;

    private RefundStatus(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
