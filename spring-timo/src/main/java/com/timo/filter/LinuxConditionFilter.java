package com.timo.filter;

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
public class LinuxConditionFilter implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		Environment environment = context.getEnvironment();

		String osName = environment.getProperty("os.name");

		return osName.contains("Linux");
	}
}
