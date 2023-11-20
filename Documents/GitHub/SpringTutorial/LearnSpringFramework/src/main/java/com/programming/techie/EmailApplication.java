package com.programming.techie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class EmailApplication {
    public static void main(String[] args) {

        //        Dependecy Injection via xml config
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        //        Dependecy Injection via java config
        ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        EmailClient emailClient = applicationContext.getBean("emailClient",EmailClient.class);
        emailClient.sendEmail("this is my first email");
        emailClient.sendEmail("this is my first email");
//        ApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("beans.xml");
//        ApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        EmailClient emailClient = applicationContext.getBean("emailClient", EmailClient.class);
//        emailClient.sendEmail("Hey, " +
//                "This is my first email message.");
//        emailClient.sendEmail("Hey, " +
//                "This is my second email message.");
//
//        // Bean Scopes
        AdvancedSpellChecker advancedSpellChecker = applicationContext.getBean("advancedSpellChecker", AdvancedSpellChecker.class);
        System.out.println(advancedSpellChecker);
        AdvancedSpellChecker advancedSpellChecker1 = applicationContext.getBean("advancedSpellChecker", AdvancedSpellChecker.class);
        System.out.println(advancedSpellChecker1);
//
//        ((AnnotationConfigApplicationContext) applicationContext).registerShutdownHook();
    }
}
