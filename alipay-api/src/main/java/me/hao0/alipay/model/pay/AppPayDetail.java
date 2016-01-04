package me.hao0.alipay.model.pay;

import me.hao0.alipay.annotation.Optional;
import me.hao0.alipay.model.enums.GoodsType;

/**
 * 支付宝APP支付明细
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 10/11/15
 */
public class AppPayDetail extends PayDetail {

    private static final long serialVersionUID = 7265488308580697604L;

    /**
     * 客户端号，标识客户端
     * {@link me.hao0.alipay.model.enums.AlipayField#APP_ID}
     */
    @Optional
    private String appId;

    /**
     * 客户端来源
     *  {@link me.hao0.alipay.model.enums.AlipayField#APPENV}
     */
    @Optional
    private String appenv;

    /**
     * 是否发起实名校验
     * {@link me.hao0.alipay.model.enums.AlipayField#RN_CHECK}
     */
    @Optional
    private String rnCheck;

    /**
     * 授权令牌(32)
     * {@link me.hao0.alipay.model.enums.AlipayField#EXTERN_TOKEN}
     */
    @Optional
    private String externToken;

    /**
     * 商户业务扩展参数
     * {@link me.hao0.alipay.model.enums.AlipayField#OUT_CONTEXT}
     */
    @Optional
    private String outContext;

    /**
     * 商品详情
     */
    private String body;

    /**
     * 商品类型
     * @see me.hao0.alipay.model.enums.GoodsType
     */
    @Optional
    private GoodsType goodsType;

    public AppPayDetail(String outTradeNo, String orderName, String totalFee, String body) {
        super(outTradeNo, orderName, totalFee);
        this.body = body;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppenv() {
        return appenv;
    }

    public void setAppenv(String appenv) {
        this.appenv = appenv;
    }

    public String getRnCheck() {
        return rnCheck;
    }

    public void setRnCheck(String rnCheck) {
        this.rnCheck = rnCheck;
    }

    public String getExternToken() {
        return externToken;
    }

    public void setExternToken(String externToken) {
        this.externToken = externToken;
    }

    public String getOutContext() {
        return outContext;
    }

    public void setOutContext(String outContext) {
        this.outContext = outContext;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "AppPayDetail{" +
                "appId='" + appId + '\'' +
                ", appenv='" + appenv + '\'' +
                ", rnCheck='" + rnCheck + '\'' +
                ", externToken='" + externToken + '\'' +
                ", outContext='" + outContext + '\'' +
                ", body='" + body + '\'' +
                ", goodsType=" + goodsType +
                "} " + super.toString();
    }
}
