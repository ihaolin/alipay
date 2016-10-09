package me.hao0.alipay.model.pay;

/**
 * 支付宝PC网页支付明细
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 10/11/15
 */
public class WebPayDetail extends PayDetail {

    private static final long serialVersionUID = -1542442458795168095L;

    /**
     * 客服端IP
     * {@link me.hao0.alipay.model.enums.AlipayField#EXTER_INVOKE_IP}
     */
    protected String exterInvokeIp;

    /**
     * 防钓鱼时间戳
     * {@link me.hao0.alipay.model.enums.AlipayField#ANTI_PHISHING_KEY}
     */
    protected String antiPhishingKey;

    /**
     * 支付宝错误通知跳转
     * {@link me.hao0.alipay.model.enums.AlipayField#ERROR_NOTIFY_URL}
     */
    protected String errorNotifyUrl;

    /**
     * 公用回传参数
     * {@link me.hao0.alipay.model.enums.AlipayField#EXTRA_COMMON_PARAM}
     */
    protected String extraCommonParam;

    public WebPayDetail(String outTradeNo, String orderName, String totalFee) {
        super(outTradeNo, orderName, totalFee);
    }

    public String getErrorNotifyUrl() {
        return errorNotifyUrl;
    }

    public void setErrorNotifyUrl(String errorNotifyUrl) {
        this.errorNotifyUrl = errorNotifyUrl;
    }

    public String getExterInvokeIp() {
        return exterInvokeIp;
    }

    public void setExterInvokeIp(String exterInvokeIp) {
        this.exterInvokeIp = exterInvokeIp;
    }

    public String getExtraCommonParam() {
        return extraCommonParam;
    }

    public void setExtraCommonParam(String extraCommonParam) {
        this.extraCommonParam = extraCommonParam;
    }

    public String getAntiPhishingKey() {
        return antiPhishingKey;
    }

    public void setAntiPhishingKey(String antiPhishingKey) {
        this.antiPhishingKey = antiPhishingKey;
    }

    @Override
    public String toString() {
        return "WebPayDetail{" +
                "exterInvokeIp='" + exterInvokeIp + '\'' +
                ", antiPhishingKey='" + antiPhishingKey + '\'' +
                ", errorNotifyUrl='" + errorNotifyUrl + '\'' +
                ", extraCommonParam='" + extraCommonParam + '\'' +
                "} " + super.toString();
    }
}
