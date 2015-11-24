package me.hao0.alipay.model.refund;

import java.io.Serializable;

/**
 * 单笔交易退款明细
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 21/11/15
 */
public class RefundDetailData implements Serializable {

    private static final long serialVersionUID = -9178222896185599335L;

    /**
     * 支付宝交易号
     */
    private String tradeNo;

    /**
     * 退款金额(元)
     */
    private String fee;

    /**
     * 退款原因
     */
    private String reason;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 格式化为支付宝需要的格式
     * @return tradeNo^fee^reason
     */
    public String format(){
        return tradeNo + "^" + fee + "^" + reason;
    }

    @Override
    public String toString() {
        return "RefundDetailData{" +
                "tradeNo='" + tradeNo + '\'' +
                ", fee='" + fee + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
