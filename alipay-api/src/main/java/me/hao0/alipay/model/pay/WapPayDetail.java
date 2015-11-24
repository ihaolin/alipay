package me.hao0.alipay.model.pay;

import me.hao0.alipay.annotation.Optional;

/**
 * 支付宝WAP支付明细
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 10/11/15
 */
public class WapPayDetail extends PayDetail {

    private static final long serialVersionUID = -4046847553452516114L;

    /**
     * 商品展示网址
     * {@link me.hao0.alipay.model.enums.AlipayField#SHOW_URL}
     */
    @Optional
    private String showUrl;

    /**
     * 手机支付宝token
     * {@link me.hao0.alipay.model.enums.AlipayField#EXTERN_TOKEN}
     */
    @Optional
    private String externToken;

    /**
     * 航旅订单其它费用
     * {@link me.hao0.alipay.model.enums.AlipayField#OTHER_FEE}
     */
    @Optional
    private String otherFee;

    /**
     * 航旅订单金额
     * {@link me.hao0.alipay.model.enums.AlipayField#AIR_TICKET}
     */
    @Optional
    private String airTicket;

    /**
     * 是否发起实名校验
     * {@link me.hao0.alipay.model.enums.AlipayField#RN_CHECK}
     */
    @Optional
    private String rnCheck;

    /**
     * 买家证件号码
     * {@link me.hao0.alipay.model.enums.AlipayField#BUYER_CERT_NO}
     */
    @Optional
    private String buyerCertNo;

    /**
     * 买家真实姓名
     * {@link me.hao0.alipay.model.enums.AlipayField#BUYER_REAL_NAME}
     */
    @Optional
    private String buyerRealName;

    /**
     * 收单场景
     * {@link me.hao0.alipay.model.enums.AlipayField#SCENE}
     */
    @Optional
    private String scene;

    public WapPayDetail(String outTradeNo, String orderName, String totalFee) {
        super(outTradeNo, orderName, totalFee);
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getExternToken() {
        return externToken;
    }

    public void setExternToken(String externToken) {
        this.externToken = externToken;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getAirTicket() {
        return airTicket;
    }

    public void setAirTicket(String airTicket) {
        this.airTicket = airTicket;
    }

    public String getRnCheck() {
        return rnCheck;
    }

    public void setRnCheck(String rnCheck) {
        this.rnCheck = rnCheck;
    }

    public String getBuyerCertNo() {
        return buyerCertNo;
    }

    public void setBuyerCertNo(String buyerCertNo) {
        this.buyerCertNo = buyerCertNo;
    }

    public String getBuyerRealName() {
        return buyerRealName;
    }

    public void setBuyerRealName(String buyerRealName) {
        this.buyerRealName = buyerRealName;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    @Override
    public String toString() {
        return "WapPayFields{" +
                "showUrl='" + showUrl + '\'' +
                ", externToken='" + externToken + '\'' +
                ", otherFee='" + otherFee + '\'' +
                ", airTicket='" + airTicket + '\'' +
                ", rnCheck='" + rnCheck + '\'' +
                ", buyerCertNo='" + buyerCertNo + '\'' +
                ", buyerRealName='" + buyerRealName + '\'' +
                ", scene='" + scene + '\'' +
                "} " + super.toString();
    }
}
