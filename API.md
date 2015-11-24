# Alipay API文档

+ 已实现组件:
	
	+ 支付: <a href="#pay-api">pay()</a>
	+ 退款: <a href="#refund-api">refund()</a>
	+ 验证: <a href="#verify-api">verify()</a>
	
+ **<a id="pay-api">支付pay()</a>**:

	```java
	/**
     * WEB支付
     * @param webPayDetail web支付信息
     * @return 自动提交表单(可直接输出到浏览器)
     */
    String webPay(WebPayDetail webPayDetail);
	
	 /**
     * WAP支付
     * @param wapPayDetail wap支付信息
     * @return 自动提交表单(可直接输出到浏览器)
     */
    String wapPay(WapPayDetail wapPayDetail);
    
    /**
     * APP支付
     * @param appPayDetail 支付字段信息
     * @return APP支付字符串，传给客户端发起支付
     */
    String appPay(AppPayDetail appPayDetail)
	```

+ **<a id="pay-api">退款refund()</a>**:
	
	```java
	/**
     * 发起退款请求
     * @param refundDetail 退款明细
     * @return 退款是否提交成功(不表示实际退款结果, 需从支付宝退款通知中来确认)
     */
    Boolean refund(RefundDetail refundDetail);
	```

+ **<a id="verify-api">验证verify()</a>**:
	
	```java
	/**
     * MD5验证通知参数签名是否合法(WEB支付，WAP支付，退款服务器通知)
     * @param notifyParams 通知参数
     * @return 合法返回true，反之false
     */
    Boolean md5(Map<String, String> notifyParams);
    
    /**
     * RSA验证通知参数是否合法(如APP支付服务器通知)，需配置appPriKey和appPubKey
     * @param notifyParams 通知参数
     * @return 合法返回true，反之false
     */
    Boolean rsa(Map<String, String> notifyParams)
	```
		
        