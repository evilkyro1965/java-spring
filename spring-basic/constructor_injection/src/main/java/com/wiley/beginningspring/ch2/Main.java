package com.wiley.beginningspring.ch2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 10/5/15.
 */
public class Main {

    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/com/wiley/beginningspring/ch2/ch2-beans.xml"
        );

        AccountService accountService = applicationContext.getBean("acccountService",AccountService.class);

        System.out.println("Before money transfer");
        System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());

        accountService.transferMoney(1, 2, 5.0);

        System.out.println("After money transfer");
        System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
    }

}
