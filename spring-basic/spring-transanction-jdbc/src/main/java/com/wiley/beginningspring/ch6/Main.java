package com.wiley.beginningspring.ch6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Ch6Configuration.class);
		AccountService accountService = applicationContext.getBean(AccountService.class);
		
		accountService.transferMoney(1L, 2L, 5.0d);
	}
}
