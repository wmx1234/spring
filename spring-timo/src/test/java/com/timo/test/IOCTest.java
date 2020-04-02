package com.timo.test;

import com.timo.config.SpringConfig;
import com.timo.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-01
 */
public class IOCTest {

	@Test
	public void test01(){
		//读取配置类
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

		User user = (User)applicationContext.getBean("user");

		System.out.println(user);

		//读取项目目录下xml配置文件
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring.xml");

		User user2 = (User)applicationContext.getBean("user");

		System.out.println(user2);
	}

	@Test
	public void test02(){
		//
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		for(String name : beanDefinitionNames){
			System.out.println("bean name:"+name);
		}

	}

}
