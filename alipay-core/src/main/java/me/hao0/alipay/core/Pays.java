package me.hao0.alipay.core;

import me.hao0.alipay.exception.AliPayException;
import me.hao0.alipay.model.enums.AlipayField;
import me.hao0.alipay.model.enums.Service;
import me.hao0.alipay.model.enums.SignType;
import me.hao0.alipay.model.pay.AppPayDetail;
import me.hao0.alipay.model.pay.PayDetail;
import me.hao0.alipay.model.pay.WapPayDetail;
import me.hao0.alipay.model.pay.WebPayDetail;
import me.hao0.common.security.RSA;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import static me.hao0.common.util.Preconditions.*;

/**
 * Pay Component
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 22/11/15
 */
public class Pays extends Component {

    Pays(Alipay alipay){
        super(alipay);
    }

    /**
     * WEB支付
     * @param webPayDetail 支付字段信息
     * @return 自动提交表单(可直接输出到浏览器)
     */
    public String webPay(WebPayDetail webPayDetail){
        Map<String, String> payParams = buildWebPayParams(webPayDetail);
        return buildPayForm(payParams);
    }

    /**
     * 构建PC支付参数
     * @param webPayDetail 字段集合
     * @return WEB支付参数
     */
    private Map<String, String> buildWebPayParams(WebPayDetail webPayDetail) {

        // 公共参数
        Map<String, String> webPayParams = buildPayParams(webPayDetail, Service.WEB_PAY);

        // PC特有参数
        putIfNotEmpty(webPayParams, AlipayField.EXTER_INVOKE_IP, webPayDetail.getExterInvokeIp());
        putIfNotEmpty(webPayParams, AlipayField.ANTI_PHISHING_KEY, webPayDetail.getAntiPhishingKey());
        putIfNotEmpty(webPayParams, AlipayField.ERROR_NOTIFY_URL, webPayDetail.getErrorNotifyUrl());
        putIfNotEmpty(webPayParams, AlipayField.EXTRA_COMMON_PARAM, webPayDetail.getExtraCommonParam());

        // md5签名参数
        buildMd5SignParams(webPayParams);

        return webPayParams;
    }

    /**
     * WAP支付
     * @param wapPayDetail 支付字段信息
     * @return 自动提交表单(可直接输出到浏览器)
     */
    public String wapPay(WapPayDetail wapPayDetail){
        Map<String, String> wapPayParams = buildWapPayParams(wapPayDetail);
        return buildPayForm(wapPayParams);
    }

    /**
     * 构建WAP支付参数
     * @param wapPayDetail 字段集合
     * @return WAP支付参数
     */
    private Map<String, String> buildWapPayParams(WapPayDetail wapPayDetail) {

        // 公共参数
        Map<String, String> wapPayParams = buildPayParams(wapPayDetail, Service.WAP_PAY);

        // WAP特有参数
        putIfNotEmpty(wapPayParams, AlipayField.SHOW_URL, wapPayDetail.getShowUrl());
        putIfNotEmpty(wapPayParams, AlipayField.RN_CHECK, wapPayDetail.getRnCheck());
        putIfNotEmpty(wapPayParams, AlipayField.AIR_TICKET, wapPayDetail.getAirTicket());
        putIfNotEmpty(wapPayParams, AlipayField.BUYER_CERT_NO, wapPayDetail.getBuyerCertNo());
        putIfNotEmpty(wapPayParams, AlipayField.BUYER_REAL_NAME, wapPayDetail.getBuyerRealName());
        putIfNotEmpty(wapPayParams, AlipayField.EXTERN_TOKEN, wapPayDetail.getExternToken());
        putIfNotEmpty(wapPayParams, AlipayField.OTHER_FEE, wapPayDetail.getOtherFee());
        putIfNotEmpty(wapPayParams, AlipayField.SCENE, wapPayDetail.getScene());

        // md5签名参数
        buildMd5SignParams(wapPayParams);

        return wapPayParams;
    }

    /**
     * 构建支付表单
     * @param payParams 支付参数
     * @return 支付表单
     */
    private String buildPayForm(Map<String, String> payParams) {
        StringBuilder form = new StringBuilder();

        form.append("<form id=\"pay_form\" name=\"pay_form\"").append(" action=\"" + Alipay.GATEWAY).append(AlipayField.INPUT_CHARSET+"=").append(alipay.inputCharset).append("\" method=\"POST\">");
        for (Map.Entry<String, String> param : payParams.entrySet()){
            form.append("<input type=\"hidden\" name=\"")
                    .append(param.getKey()).append("\" value=\"").append(param.getValue()).append("\" />");
        }
        form.append("<input type=\"submit\" value=\"去支付\" style=\"display:none;\" />");
        form.append("</form>");
        form.append("<script>document.forms['pay_form'].submit();</script>");

        return form.toString();
    }

    /**
     * APP支付
     * @param appPayDetail 支付字段信息
     * @return APP支付字符串
     */
    public String appPay(AppPayDetail appPayDetail){
        checkNotNullAndEmpty(alipay.appPriKey, "app private key");
        Map<String, String> appPayParams = buildAppPayParams(appPayDetail);
        return buildRsaPayString(appPayParams);
    }

    private Map<String, String> buildAppPayParams(AppPayDetail appPayDetail) {

        // 公共参数
        Map<String, String> appPayParams = buildPayParams(appPayDetail, Service.APP_PAY);

        // APP支付无return_url, paymethod
        appPayParams.remove(AlipayField.RETURN_URL.field());

        // APP特有参数
        checkNotNullAndEmpty(appPayDetail.getBody(), "body");
        appPayParams.put(AlipayField.BODY.field(), appPayDetail.getBody());

        putIfNotEmpty(appPayParams, AlipayField.APP_ID, appPayDetail.getAppId());
        putIfNotEmpty(appPayParams, AlipayField.APPENV, appPayDetail.getAppenv());
        putIfNotEmpty(appPayParams, AlipayField.EXTERN_TOKEN, appPayDetail.getExternToken());
        putIfNotEmpty(appPayParams, AlipayField.OUT_CONTEXT, appPayDetail.getOutContext());
        putIfNotEmpty(appPayParams, AlipayField.RN_CHECK, appPayDetail.getRnCheck());
        if (appPayDetail.getGoodsType() != null){
            appPayParams.put(AlipayField.GOODS_TYPE.field(), appPayDetail.getGoodsType().value());
        }

        return appPayParams;
    }

    /**
     * 构建RSA签名参数
     * @param payParams 支付参数
     * @return RSA签名后的支付字符串
     */
    private String buildRsaPayString(Map<String, String> payParams) {
        String payString = buildSignString(payParams, "\"");
        String sign = RSA.sign(payString, alipay.appPriKey, alipay.inputCharset);
        try {
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AliPayException("sign encode failed", e);
        }
        payString += ("&sign_type=\"" + SignType.RSA.value() + "\"&sign=\""+ sign +"\"");
        return payString;
    }

    /**
     * 构建支付公共参数
     * @param payDetail 字段
     * @param service 服务接口
     * @return PC和WAP公共支付参数
     */
    private Map<String, String> buildPayParams(PayDetail payDetail, Service service){

        Map<String, String> payParams = new HashMap<>();

        // 配置参数
        payParams.putAll(alipay.payConfig);

        // 业务参数
        payParams.put(AlipayField.SERVICE.field(), service.value());

        checkNotNullAndEmpty(payDetail.getOutTradeNo(), "outTradeNo");
        payParams.put(AlipayField.OUT_TRADE_NO.field(), payDetail.getOutTradeNo());

        checkNotNullAndEmpty(payDetail.getOrderName(), "orderName");
        payParams.put(AlipayField.SUBJECT.field(), payDetail.getOrderName());

        checkNotNullAndEmpty(payDetail.getTotalFee(), "totalFee");
        payParams.put(AlipayField.TOTAL_FEE.field(), payDetail.getTotalFee());

        putIfNotEmpty(payParams, AlipayField.NOTIFY_URL, payDetail.getNotifyUrl());
        putIfNotEmpty(payParams, AlipayField.RETURN_URL, payDetail.getReturnUrl());

        return payParams;
    }
}
