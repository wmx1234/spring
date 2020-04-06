package com.timo.config;

import com.timo.bean.color.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-06
 */
@Configuration
public class FactoryBeanConfig {

	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}

}
