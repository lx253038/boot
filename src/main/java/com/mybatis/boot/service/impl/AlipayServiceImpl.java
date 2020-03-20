package com.mybatis.boot.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.*;
import com.mybatis.boot.config.AlipayConfig;
import com.mybatis.boot.service.AlipayService;
import com.mybatis.boot.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author LX
 * @Date 2020/2/21 10:22
 * @Description
 */
@Service
@Slf4j
public class AlipayServiceImpl implements AlipayService {


    @Override
    public void aliPay(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        //aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        //aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        String order_number = new String(StringUtils.getOrderStr());
        //付款金额，从前台获取，必填
        String total_amount = new String("100");
        //订单名称，必填
        String subject = new String("祖万敏小可爱");
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(aliPayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //输出
        out.println(result);
        log.info("返回结果={}", result);

    }

    /**
     * 调取支付宝接口 web端支付
     */
    DefaultAlipayClient alipayClient = new DefaultAlipayClient(
            AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

    /**
     * 调取支付宝接口app端支付
     */
    AlipayClient alipayClients = new DefaultAlipayClient(
            AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);


    @Override
    public String webPagePay(String outTradeNo, Integer totalAmount, String subject) throws Exception {

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        /** 同步通知，支付完成后，支付成功页面*/
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        /** 异步通知，支付完成后，需要进行的异步处理*/
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"total_amount\":\"" + totalAmount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"商品名称\","
                + "\"timeout_express\":\"90m\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        /**转换格式*/
        String result = alipayClient.pageExecute(alipayRequest).getBody().replace('\"', '\'').replace('\n', ' ');
        return result;
    }

    @Override
    public String refund(String outTradeNo, String refundReason, Integer refundAmount, String outRequestNo) throws AlipayApiException {
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

        /** 调取接口*/
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"refund_amount\":\"" + refundAmount + "\","
                + "\"refund_reason\":\"" + refundReason + "\","
                + "\"out_request_no\":\"" + outRequestNo + "\"}");
        String result = alipayClient.execute(alipayRequest).getBody();
        return result;
    }

    @Override
    public String query(String outTradeNo) throws AlipayApiException {
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
        /**请求接口*/
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\"," + "\"trade_no\":\"" + "" + "\"}");
        /**转换格式*/
        String result = alipayClient.execute(alipayRequest).getBody();
        return result;
    }

    @Override
    public String close(String outTradeNo) throws AlipayApiException {
        AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\"," + "\"trade_no\":\"" + "" + "\"}");

        String result = alipayClient.execute(alipayRequest).getBody();

        return result;
    }

    @Override
    public String refundQuery(String outTradeNo, String outRequestNo) throws AlipayApiException {
        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();

        /** 请求接口*/
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"out_request_no\":\"" + outRequestNo + "\"}");

        /** 格式转换*/
        String result = alipayClient.execute(alipayRequest).getBody();

        return result;
    }

    @Override
    public String appPagePay(String outTradeNo, Integer totalAmount, String subject) throws Exception {
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();

        /** 同步通知，支付完成后，支付成功页面*/
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        /** 异步通知，支付完成后，需要进行的异步处理*/
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        /**销售产品码（固定）*/
        String productCode = "QUICK_WAP_WAY";

        /** 进行赋值 */
        AlipayTradeWapPayModel wapPayModel = new AlipayTradeWapPayModel();
        wapPayModel.setOutTradeNo(outTradeNo);
        wapPayModel.setSubject(subject);
        wapPayModel.setTotalAmount(totalAmount.toString());
        wapPayModel.setBody("商品名称");
        wapPayModel.setTimeoutExpress("2m");
        wapPayModel.setProductCode(productCode);
        alipayRequest.setBizModel(wapPayModel);

        /** 格式转换*/
        String result = alipayClients.pageExecute(alipayRequest).getBody().replace('\"', '\'').replace('\n', ' ');
        return result;
    }

}
