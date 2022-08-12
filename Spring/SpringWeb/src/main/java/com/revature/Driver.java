package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.service.PolkamanService;

public class Driver {

	public static void main(String[] args) {
		
		/*
		 * Let's prove that Spring created the bean that we want to use:
		 * 
		 * Note that there are several implementations of the ApplicationContext, including:
		 * 
		 * ClassPathXmlApplicationContext
		 * FileSystemXmlApplicationContext
		 * AnnotationConfigApplicationContext
		 */
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		PolkamanService ps = applicationContext.getBean("polkamanService", PolkamanService.class);
		
		System.out.println(ps.sortPolkamansByName());
		
	}
}
