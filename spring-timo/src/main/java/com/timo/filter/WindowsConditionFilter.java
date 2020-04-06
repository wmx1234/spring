package com.timo.filter;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-03
 */
public class WindowsConditionFilter implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		//获取
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//获取到Bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		//获取到当前环境信息
		Environment environment = context.getEnvironment();

		String osName = environment.getProperty("os.name");

		return osName.contains("Windows");
	}
}
