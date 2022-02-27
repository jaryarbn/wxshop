package com.grandline.wxshop.service;

/**
 * The interface Sms code service.
 */
public interface SmsCodeService {
    /**
     * 向一个指定手机号发验证码，返回正确答案
     *
     * @param tel 目标手机号
     * @return 正确答案 string
     */
    String sendSmsCode(String tel);
}
