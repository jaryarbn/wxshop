package com.grandline.wxshop.service;

import org.springframework.stereotype.Service;

/**
 * The type Mock sms code service.
 */
@Service
public class MockSmsCodeService implements SmsCodeService{
    @Override
    public String sendSmsCode(String tel) {
        return "000000";
    }
}
