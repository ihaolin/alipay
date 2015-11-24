package me.hao0.alipay.demo.controller;

import me.hao0.alipay.demo.service.AlipayService;
import me.hao0.alipay.model.pay.WapPayDetail;
import me.hao0.alipay.model.pay.WebPayDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 支付
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 23/11/15
 */
@Controller
@RequestMapping("/pays")
public class Pays {

    private static final Logger logger = LoggerFactory.getLogger(Pays.class);

    @Autowired
    private AlipayService alipayService;

    /**
     * WEB支付
     */
    @RequestMapping("/web")
    public void webPay(@RequestParam("orderNumber") String orderNumber, HttpServletResponse resp){

        WebPayDetail detail = new WebPayDetail(orderNumber, "测试订单-" + orderNumber, "0.01");
        String form = alipayService.webPay(detail);
        logger.info("web pay form: {}", form);
        try {
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(form);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException e) {
            // ignore
        }
    }

    /**
     * WAP支付
     */
    @RequestMapping("/wap")
    public void wapPay(@RequestParam("orderNumber") String orderNumber, HttpServletResponse resp){

        WapPayDetail detail = new WapPayDetail(orderNumber, "测试订单-" + orderNumber, "0.01");
        String form = alipayService.wapPay(detail);
        logger.info("wap pay form: {}", form);
        try {
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(form);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException e) {
            // ignore
        }
    }
}
