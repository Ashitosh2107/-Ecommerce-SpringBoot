//package com.example.Ecommerce.ServiceImpl;
//
//import com.example.Ecommerce.Service.SmsService;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SmsServiceImpl implements SmsService {
//
//    @Value("${twilio.phone-number}")
//    private String twilioPhoneNumber;
//
//    @Override
//    public void sendOtp(String phoneNumber, String otp) {
//
//        Message.creator(
//                new PhoneNumber(phoneNumber),
//                new PhoneNumber(twilioPhoneNumber),
//                "Your verification OTP is: " + otp
//        ).create();
//    }
//}