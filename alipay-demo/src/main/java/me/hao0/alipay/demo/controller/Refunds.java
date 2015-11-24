package me.hao0.alipay.demo.controller;

import me.hao0.alipay.demo.service.AlipayService;
import me.hao0.alipay.model.refund.RefundDetail;
import me.hao0.alipay.model.refund.RefundDetailData;
import me.hao0.common.date.Dates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Arrays;

/**
 * 退款
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 23/11/15
 */
@Controller
@RequestMapping("/refunds")
public class Refunds {

    private static final Logger logger = LoggerFactory.getLogger(Refunds.class);

    @Autowired
    private AlipayService alipayService;

    /**
     * 提交退款请求
     * @param batchNo 批次号(前面会加日期)，如0001
     *        {@link me.hao0.alipay.model.enums.AlipayField#BATCH_NO}
     * @param tradeNo 支付宝交易号，如2015112321001004010248104122
     * @return 是否提交成功
     */
    @RequestMapping("/submit")
    @ResponseBody
    public Boolean submit(
            @RequestParam("batchNo") String batchNo,
            @RequestParam("tradeNo") String tradeNo){
        RefundDetail detail = new RefundDetail();
        detail.setBatchNo(Dates.now("yyyyMMdd") + batchNo);
        RefundDetailData data = new RefundDetailData();
        data.setTradeNo(tradeNo);
        data.setFee("0.01");
        data.setReason("订单取消");
        detail.setDetailDatas(Arrays.asList(data));
        logger.info("refund submit: {}", detail);
        return alipayService.refund(detail);
    }
}
