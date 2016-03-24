package me.hao0.alipay.demo.controller;

import me.hao0.alipay.demo.service.AlipayService;
import me.hao0.alipay.model.AlipayFields;
import me.hao0.alipay.model.enums.AlipayField;
import me.hao0.alipay.model.enums.TradeStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 通知
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 23/11/15
 */
@RestController
@RequestMapping("/notifies")
public class Notifies {

    private static final Logger logger = LoggerFactory.getLogger(Notifies.class);

    @Autowired
    private AlipayService alipayService;

    /**
     * 支付宝服务器通知
     */
    @RequestMapping("/backend")
    public String backend(HttpServletRequest request){
        Map<String, String> notifyParams = new HashMap<>();

        // TODO 这里还是建议直接从request中获取map参数，兼容支付宝修改或增减参数
        for (AlipayField f : AlipayFields.WEB_PAY_NOTIFY){
            notifyParams.put(f.field(), request.getParameter(f.field()));
        }
        logger.info("backend notify params: {}", notifyParams);
        if (!alipayService.notifyVerifyMd5(notifyParams)){
            logger.error("backend sign verify failed");
            return "FAIL";
        }

        String tradeStatus = notifyParams.get(AlipayField.TRADE_STATUS.field());
        if (TradeStatus.TRADE_FINISHED.value().equals(tradeStatus)
                || TradeStatus.TRADE_SUCCESS.value().equals(tradeStatus)){
            // 交易成功
            // TODO business logic
        }

        logger.info("backend notify success");
        return "SUCCESS";
    }

    /**
     * 支付宝web前端跳转通知
     */
    @RequestMapping("/web/frontend")
    public String webFrontend(HttpServletRequest request){

        Map<String, String> receives = new HashMap<>();

        // TODO 这里还是建议直接从request中获取map参数，兼容支付宝修改或增减参数
        for (AlipayField f : AlipayFields.WEB_PAY_RETURN){
            receives.put(f.field(), request.getParameter(f.field()));
        }

        String tradeStatus = receives.get(AlipayField.TRADE_STATUS.field());
        if (TradeStatus.TRADE_FINISHED.value().equals(tradeStatus)
                || TradeStatus.TRADE_SUCCESS.value().equals(tradeStatus)){
            // 交易成功
            // TODO business logic
        }

        logger.info("web frontend notify params: {}", receives);
        logger.info("web frontend sign: {}", alipayService.notifyVerifyMd5(receives));

        return receives.toString();
    }

    /**
     * 支付宝wap前端跳转通知
     */
    @RequestMapping("/wap/frontend")
    public String wapFrontend(HttpServletRequest request){

        Map<String, String> receives = new HashMap<>();

        // TODO 这里还是建议直接从request中获取map参数，兼容支付宝修改或增减参数
        for (AlipayField f : AlipayFields.WAP_PAY_RETURN){
            receives.put(f.field(), request.getParameter(f.field()));
        }

        String tradeStatus = receives.get(AlipayField.TRADE_STATUS.field());
        if (TradeStatus.TRADE_FINISHED.value().equals(tradeStatus)
                || TradeStatus.TRADE_SUCCESS.value().equals(tradeStatus)){
            // 交易成功
            // TODO business logic
        }

        logger.info("wap frontend notify params: {}", receives);
        logger.info("wap frontend sign: {}", alipayService.notifyVerifyMd5(receives));

        return receives.toString();
    }

    /**
     * 退款通知
     */
    @RequestMapping("/refund")
    public String refund(HttpServletRequest request){
        Map<String, String> receives = new HashMap<>();

        // TODO 这里还是建议直接从request中获取map参数，兼容支付宝修改或增减参数
        for (AlipayField f : AlipayFields.REFUND_NOTIFY){
            receives.put(f.field(), request.getParameter(f.field()));
        }

        logger.info("refund notify params: {}", receives);
        if (!alipayService.notifyVerifyMd5(receives)){
            System.out.println("refund sign verify failed");
            return "FAIL";
        }

        // TODO business logic

        logger.info("refund notify success");
        return "SUCCESS";
    }
}
