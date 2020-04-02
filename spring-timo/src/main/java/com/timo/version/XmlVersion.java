package com.timo.version;

import com.timo.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-03-26
 */
public class XmlVersion {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		UserDao userDao = (UserDao) context.getBean("userDao");

		userDao.test();
	}
}
