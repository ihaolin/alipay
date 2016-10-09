package me.hao0.alipay.model.enums;

/**
 * 支付宝相关字段集
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 12/11/15
 */
public enum AlipayField {

    PARTNER("partner", "商户ID"),

    PAY_METHOD("paymethod", "支付类型"),

    IT_B_PAY("it_b_pay", "超时设置"),

    INPUT_CHARSET("_input_charset", "字符集设置"),

    NOTIFY_URL("notify_url", "支付宝服务器通知地址"),

    RETURN_URL("return_url", "支付宝页面跳转地址"),

    /**
     * 设置请求出错时的通知页面路径(该功能需要联系支付宝开通)
     * 当商户通过该接口发起请求时，如果出现提示报错，
     * 支付宝会根据请求出错时的通知错误码通过异步的方式发送通知给商户。
     */
    ERROR_NOTIFY_URL("error_notify_url", "支付宝错误通知地址"),

    /**
     * 用户在创建交易时，该用户当前所使用机器的IP。如果商户申请后台开通防钓鱼IP地址检查选项，此字段必填，校验用。
     */
    EXTER_INVOKE_IP("exter_invoke_ip", "客户端IP"),

    /**
     * 通过时间戳查询接口获取的加密支付宝系统时间戳，如果已申请开通防钓鱼时间戳验证，则此字段必填。
     */
    ANTI_PHISHING_KEY("anti_phishing_key", "防钓鱼时间戳"),

    /**
     * 收银台页面上，商品展示的超链接
     */
    SHOW_URL("show_url", "商品展示链接"),

    ORDER_NAME("order_name", "商品名称"),

    /**
     * T发起，F不发
     */
    RN_CHECK("rn_check", "是否发起实名校验"),

    /**
     * 航旅订单金额描述，由四项或两项构成，各项之间由“|”分隔，
     * 每项包含金额与描述，金额与描述间用“^”分隔，票面价之外的价格之和必须与otherfee相等。
     */
    AIR_TICKET("air_ticket", "航旅订单金额"),

    /**
     * 航旅订单中除去票面价之外的费用，单位为RMB-Yuan。
     *  取值范围为[0.01,100000000.00]，精确到小数点后两位。
     */
    OTHER_FEE("other_fee", "航旅订单其它费用"),

    /**
     * 接入极简版wap收银台时支持。当商户请求是来自手机支付宝，在手机支付宝登录后，
     *  有生成登录信息token时，使用该参数传入token将可以实现信任登录收银台，不需要再次登录。
     *  注意：登录后用户还是有入口可以切换账户，不能使用该参数锁定用户。
     */
    EXTERN_TOKEN("extern_token", "手机支付宝token"),

    /**
     * 需要与支付宝实名认证时所填写的证件号码一致
     */
    BUYER_CERT_NO("buyer_cert_no", "买家证件号码"),

    /**
     * 需要与支付宝实名认证时所填写的证件号码一致
     */
    BUYER_REAL_NAME("buyer_real_name", "买家真实姓名"),

    /**
     * 如需使用该字段，需向支付宝申请开通，否则传入无效。
     */
    SCENE("scene", "收单场景"),

    SIGN("sign", "签名"),

    SIGN_TYPE("sign_type", "签名类型"),

    OUT_TRADE_NO("out_trade_no", "我方唯一订单号"),

    SUBJECT("subject", "商品名称"),

    PAYMENT_TYPE("payment_type", "支付类型"),

    /**
     * 有效性一般为1分钟
     */
    NOTIFY_ID("notify_id", "通知校验ID"),

    NOTIFY_TIYE("notify_type", "通知类型"),

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    NOTIFY_TIME("notify_time", "通知时间"),

    TRADE_NO("trade_no", "支付宝交易号"),

    TRADE_STATUS("trade_status", "交易状态"),

    SELLER_ID("seller_id", "卖家支付宝账户号"),

    /**
     * 卖家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。
     * 登录时，seller_email和seller_user_id两者必填一个。如果两者都填，以seller_user_id为准。
     */
    SELLER_USER_ID("seller_user_id", "卖家支付宝账户号"),

    SELLER_EMAIL("seller_email", "卖家支付宝帐号"),

    BUYER_ID("buyer_id", "买家支付宝账户号"),

    BUYER_EMAIL("buyer_email", "买家支付宝帐号"),

    /**
     * 取值范围为[0.01，100000000.00]，精确到小数点后两位
     */
    TOTAL_FEE("total_fee", "订单的总金额"),

    GMT_CREATE("gmt_create", "交易创建时间"),

    GMT_PAYMENT("gmt_payment", "交易付款时间"),

    GMT_CLOSE("gmt_close", "交易关闭时间"),

    GMT_REFUND("gmt_refund", "退款时间"),

    REFUND_STATUS("refund_status", "退款状态"),

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    REFUND_DATE("refund_date", "退款请求时间"),

    /**
     * 如果请求时使用的是total_fee，那么price等于total_fee；如果请求时使用的是price，那么对应请求时的price参数，原样通知回来。
     */
    PRICE("price", "商品单价"),

    /**
     * 如果请求时使用的是total_fee，那么quantity等于1；如果请求时使用的是quantity，那么对应请求时的quantity参数，原样通知回来。
     */
    QUANTITY("quantity", "购买数量"),

    /**
     * 该笔订单的备注、描述、明细等。对应请求时的body参数，原样通知回来。
     */
    BODY("body", "商品描述"),

    /**
     * 支付宝系统会把discount的值加到交易金额上，如果需要折扣，本参数为负数。
     */
    DISCOUNT("discount", "折扣"),

    IS_TOTAL_FEE_ADJUST("is_total_fee_adjust", "该交易是否调整过价格"),

    USE_COUPON("use_coupon", "买家是否使用红包"),

    /**
     * 该笔交易所使用的支付渠道。格式为：渠道1|渠道2|…，如果有多个渠道，用“|”隔开
     */
    OUT_CHANNEL_TYPE("out_channel_type", "支付渠道组合信息"),

    /**
     * 该笔交易通过使用各支付渠道所支付的金额。格式为：金额1|金额2|…，如果有多个支付渠道，各渠道所支付金额用“|”隔开。
     */
    OUT_CHANNEL_AMOUNT("out_channel_amount", "支付金额组合信息"),

    /**
     * 该交易支付时实际使用的银行渠道。格式为：支付渠道1|支付渠道2|…，如果有多个支付渠道，用“|”隔开
     */
    OUT_CHANNEL_INST("out_channel_inst", "实际支付渠道"),

    /**
     * 回传给商户此标识为qrpay时，表示对应交易为扫码支付。目前只有qrpay一种回传值。非扫码支付方式下，目前不会返回该参数。
     */
    BUSINESS_SCENE("business_scene", "是否扫码支付"),

    /**
     * 用于商户回传参数
     *  该值不能包含等号、与号等特殊字符。如果用户请求时传递了该参数，则返回给商户时会回传该参数。
     */
    EXTRA_COMMON_PARAM("extra_common_param", "公用回传参数"),

    /**
     * 表示接口调用是否成功，并不表明业务处理结果，如T
     */
    IS_SUCCESS("is_success", "成功标识"),

    /**
     * 标志调用哪个接口返回的链接，如create_direct_pay_by_user
     */
    EXTERFACE("exterface", "服务接口名称"),

    /**
     * 标志调用哪个接口返回的链接，如alipay.wap.create.direct.pay.by.user
     */
    SERVICE("service", "接口名称"),

    /**
     * 本参数用于信用支付。它代表执行支付操作的操作员账号所属的代理人的支付宝唯一用户号。以2088开头的纯16位数字。
     */
    AGENT_USER_ID("agent_user_id", "信用支付购票员的代理人ID"),

    ERROR_CODE("error_code", "错误码"),

    APP_ID("app_id", "客户端号"),

    APPENV("appenv", "客户端来源"),

    /**
     * 业务扩展参数，支付宝特定的业务需要添加该字段，json格式。 商户接入时和支付宝协商确定。
     */
    OUT_CONTEXT("out_context", "商户业务扩展参数"),

    /**
     * 进行一次即时到账批量退款，都需要提供一个批次号，通过该批次号可以查询这一批次的退款交易记录，
     * 对于每一个合作伙伴，传递的每一个批次号都必须保证唯一性。格式为：退款日期（8位）+流水号（3～24位）。
     * 不可重复，且退款日期必须是当天日期。流水号可以接受数字或英文字符，建议使用数字，但不可接受“000”。
     */
    BATCH_NO("batch_no", "退款批次号"),

    /**
     * 即参数detail_data的值中，“#”字符出现的数量加1，最大支持1000笔（即“#”字符出现的最大数量为999个）
     */
    BATCH_NUM("batch_num", "总笔数"),

    /**
     * 退款请求的明细数据:
     * 1. 数据集格式: 第一笔#第二笔#...#第N笔
     * 2. 单笔格式: 原付款支付宝交易号^退款总金额^退款理由
     * 3. 不支持退分润功能
     */
    DETAIL_DATA("detail_data", "单笔数据集"),

    /**
     * 0 小于 success_num 小于等于 总退款笔数(batch_num)
     */
    SUCCESS_NUM("success_num", "退款成功总数"),

    /**
     * 1. 退手续费结果返回格式:
     *  交易号^退款金额^处理结果$退费账号^退费账户ID^退费金额^处理结果
     * 2. 不退手续费结果返回格式：
     *  交易号^退款金额^处理结果
     * 3. 若退款申请提交成功，处理结果会返回“SUCCESS”。若提交失败，退款的处理结果中会有报错码
     */
    RESULT_DETAILS("result_details", "退款结果明细"),

    GOODS_TYPE("goods_type", "商品类型");

    private String field;

    private String desc;

    private AlipayField(String field, String desc){
        this.field = field;
        this.desc = desc;
    }

    public String field(){
        return field;
    }

    public String desc(){
        return desc;
    }

    @Override
    public String toString() {
        return field;
    }
}
