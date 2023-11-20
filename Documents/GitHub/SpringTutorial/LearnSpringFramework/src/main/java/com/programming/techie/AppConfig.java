package com.programming.techie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.programming.techie")
public class AppConfig {

//    @Bean(name = "basicSpellChecker", initMethod = "init", destroyMethod = "destroy")
//    public BasicSpellChecker createBasicSpellChecker() {
//        return new BasicSpellChecker();
//    }
//
//    @Bean(name = "advancedSpellChecker")
//    public AdvancedSpellChecker createAdvancedSpellChecker() {
//        return new AdvancedSpellChecker();
//    }
//
//    @Bean("emailClient")
//    public EmailClient createEmailClient() {
////        using constructor injection
////        EmailClient emailClient = new EmailClient(createAdvancedSpellChecker());
//        EmailClient emailClient = new EmailClient();
//        emailClient.setSpellChecker(createAdvancedSpellChecker());
//
////        using setter injection
//        return  emailClient;
//
//        //
//    }


}
