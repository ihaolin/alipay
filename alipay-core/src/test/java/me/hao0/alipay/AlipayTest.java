package me.hao0.alipay;

import me.hao0.alipay.core.Alipay;
import me.hao0.alipay.core.AlipayBuilder;
import me.hao0.alipay.model.pay.AppPayDetail;
import me.hao0.alipay.model.pay.WapPayDetail;
import me.hao0.alipay.model.pay.WebPayDetail;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static org.junit.Assert.*;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 11/11/15
 */
public class AlipayTest {

    private Alipay alipay;

    @Before
    public void init() throws IOException {
        Properties props = new Properties();
        InputStream in = Object.class.getResourceAsStream("/dev.properties");
        props.load(in);
        alipay = AlipayBuilder.newBuilder(
                props.getProperty("pid"),
                props.getProperty("secret"))
                .appPriKey(props.getProperty("prikey"))
                .appPubKey(props.getProperty("pubkey"))
                .build();
    }

    @Test
    public void testWebPay(){
        WebPayDetail fields = new WebPayDetail("DM1234567800", "ss", "0.01");
        fields.setExterInvokeIp("222.112.105.129");
        String form = alipay.pay().webPay(fields);
        assertNotNull(form);
        System.out.println(form);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWebPayOutTradeNoEmpty(){
        WebPayDetail fields = new WebPayDetail("", "ss", "0.01");
        fields.setExterInvokeIp("222.112.105.129");
        String form = alipay.pay().webPay(fields);
        assertNotNull(form);
        System.out.println(form);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWebPayOrderNameNull(){
        WebPayDetail fields = new WebPayDetail("DM1234567800", null, "0.01");
        fields.setExterInvokeIp("222.112.105.129");
        String form = alipay.pay().webPay(fields);
        assertNotNull(form);
        System.out.println(form);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWebPayTotalFeeEmpty(){
        WebPayDetail fields = new WebPayDetail("DM1234567800", "ss", "");
        fields.setExterInvokeIp("222.112.105.129");
        String form = alipay.pay().webPay(fields);
        assertNotNull(form);
        System.out.println(form);
    }

    @Test
    public void testWapPay(){
        WapPayDetail fields = new WapPayDetail("DM12345678999", "ss", "0.01");
        String form = alipay.pay().wapPay(fields);
        assertNotNull(form);
        System.out.println(form);
    }

    @Test
    public void testAppPay(){
        AppPayDetail fields = new AppPayDetail("DM1234567779", "ss", "0.01", "测试商品");
        String payString = alipay.pay().appPay(fields);
        assertNotNull(payString);
        System.out.println(payString);
    }

    @Test
    public void testVerifyNotifyId(){
        assertTrue(alipay.verify().notifyId("3eec9e00f788cfede8f767eb2a22a7ec54"));
        assertFalse(alipay.verify().notifyId("xxxxx"));
    }
}
