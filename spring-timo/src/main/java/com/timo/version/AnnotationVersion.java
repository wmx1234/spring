package com.timo.version;

import com.timo.config.SpringConfig;
import com.timo.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-03-26
 */
public class AnnotationVersion {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		UserDao userDao = (UserDao)context.getBean("userDao");

		userDao.test();


	}


}
