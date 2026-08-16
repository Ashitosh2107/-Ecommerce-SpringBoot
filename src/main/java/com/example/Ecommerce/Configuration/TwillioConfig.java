//package com.example.Ecommerce.Configuration;
//
//import com.twilio.Twilio;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class TwillioConfig {
//
//    @Value("${twilio.account-sid}")
//    private String accountSid;
//
//    @Value("${twilio.auth-token}")
//    private String authToken;
//
//    @PostConstruct
//    public void init() {
//        Twilio.init(accountSid, authToken);
//    }
//}