package me.hao0.alipay.model;

import me.hao0.alipay.model.enums.AlipayField;
import java.util.Arrays;
import java.util.List;

/**
 * Alipay field collection
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 12/11/15
 */
public class AlipayFields {

    private AlipayFields() {
        
    }
    
    /**
     * PC支付服务器通知参数
     */
    public static final List<AlipayField> WEB_PAY_NOTIFY = Arrays.asList(
        AlipayField.SIGN, AlipayField.SIGN_TYPE, AlipayField.OUT_TRADE_NO, AlipayField.SUBJECT,
        AlipayField.PAYMENT_TYPE, AlipayField.NOTIFY_ID, AlipayField.NOTIFY_TIYE, AlipayField.NOTIFY_TIME,
        AlipayField.TRADE_NO, AlipayField.TRADE_STATUS, AlipayField.SELLER_ID, AlipayField.SELLER_EMAIL,
        AlipayField.BUYER_ID, AlipayField.BUYER_EMAIL, AlipayField.TOTAL_FEE, AlipayField.GMT_CREATE,
        AlipayField.GMT_PAYMENT, AlipayField.GMT_CLOSE, AlipayField.GMT_REFUND, AlipayField.REFUND_STATUS,
        AlipayField.PRICE, AlipayField.QUANTITY, AlipayField.BODY, AlipayField.DISCOUNT,
        AlipayField.IS_TOTAL_FEE_ADJUST, AlipayField.USE_COUPON, AlipayField.OUT_CHANNEL_TYPE,
        AlipayField.OUT_CHANNEL_AMOUNT, AlipayField.OUT_CHANNEL_INST, AlipayField.BUSINESS_SCENE,
        AlipayField.EXTRA_COMMON_PARAM
    );

    /**
     * PC支付页面跳转通知参数
     */
    public static final List<AlipayField> WEB_PAY_RETURN = Arrays.asList(
        AlipayField.IS_SUCCESS, AlipayField.SIGN, AlipayField.SIGN_TYPE, AlipayField.OUT_TRADE_NO,
        AlipayField.SUBJECT, AlipayField.PAYMENT_TYPE, AlipayField.EXTERFACE, AlipayField.TRADE_NO,
        AlipayField.TRADE_STATUS, AlipayField.NOTIFY_ID, AlipayField.NOTIFY_TIYE, AlipayField.NOTIFY_TIME,
        AlipayField.SELLER_ID, AlipayField.SELLER_EMAIL, AlipayField.BUYER_ID, AlipayField.BUYER_EMAIL,
        AlipayField.TOTAL_FEE, AlipayField.BODY, AlipayField.EXTRA_COMMON_PARAM, AlipayField.AGENT_USER_ID
    );

    /**
     * WAP支付服务器通知参数
     */
    public static final List<AlipayField> WAP_NOTIFY = Arrays.asList(
        AlipayField.SIGN, AlipayField.SIGN_TYPE, AlipayField.OUT_TRADE_NO, AlipayField.SUBJECT,
        AlipayField.PAYMENT_TYPE, AlipayField.NOTIFY_ID, AlipayField.NOTIFY_TIYE, AlipayField.NOTIFY_TIME,
        AlipayField.TRADE_NO, AlipayField.TRADE_STATUS, AlipayField.GMT_CREATE, AlipayField.GMT_PAYMENT,
        AlipayField.GMT_CLOSE, AlipayField.GMT_REFUND, AlipayField.REFUND_STATUS, AlipayField.SELLER_ID,
        AlipayField.SELLER_EMAIL, AlipayField.BUYER_ID, AlipayField.BUYER_EMAIL, AlipayField.TOTAL_FEE,
        AlipayField.PRICE, AlipayField.QUANTITY, AlipayField.BODY, AlipayField.DISCOUNT,
        AlipayField.IS_TOTAL_FEE_ADJUST, AlipayField.USE_COUPON
    );

    /**
     * WAP支付页面跳转通知参数
     */
    public static final List<AlipayField> WAP_PAY_RETURN = Arrays.asList(
        AlipayField.IS_SUCCESS, AlipayField.SIGN, AlipayField.SIGN_TYPE, AlipayField.OUT_TRADE_NO,
        AlipayField.SUBJECT, AlipayField.PAYMENT_TYPE, AlipayField.SERVICE, AlipayField.TRADE_NO,
        AlipayField.TRADE_STATUS, AlipayField.NOTIFY_ID, AlipayField.NOTIFY_TIYE, AlipayField.NOTIFY_TIME,
        AlipayField.SELLER_ID, AlipayField.TOTAL_FEE, AlipayField.BODY
    );

    /**
     * APP支付服务器通知参数
     */
    public static final List<AlipayField> APP_PAY_NOTIFY = Arrays.asList(
        AlipayField.SIGN, AlipayField.SIGN_TYPE, AlipayField.NOTIFY_ID, AlipayField.NOTIFY_TIME,
        AlipayField.NOTIFY_TIYE, AlipayField.OUT_TRADE_NO, AlipayField.SUBJECT, AlipayField.PAYMENT_TYPE,
        AlipayField.TRADE_STATUS, AlipayField.SELLER_ID, AlipayField.SELLER_EMAIL, AlipayField.TRADE_NO,
        AlipayField.BUYER_ID, AlipayField.BUYER_EMAIL, AlipayField.TOTAL_FEE, AlipayField.QUANTITY,
        AlipayField.PRICE, AlipayField.BODY, AlipayField.GMT_CREATE, AlipayField.GMT_PAYMENT,
        AlipayField.GMT_REFUND, AlipayField.IS_TOTAL_FEE_ADJUST, AlipayField.USE_COUPON, AlipayField.DISCOUNT,
        AlipayField.REFUND_STATUS
    );

    /**
     * 退款服务器通知参数
     */
    public static final List<AlipayField> REFUND_NOTIFY = Arrays.asList(
            AlipayField.SIGN, AlipayField.SIGN_TYPE, AlipayField.NOTIFY_ID, AlipayField.NOTIFY_TIYE,
            AlipayField.NOTIFY_TIME, AlipayField.BATCH_NO, AlipayField.SUCCESS_NUM, AlipayField.RESULT_DETAILS
    );
}
