package com.timo.selector;

import com.timo.bean.color.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-06
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 *
	 * @param importingClassMetadata 标注了import类的注解信息
	 * @param registry 当前类的注册类
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		boolean blue = registry.containsBeanDefinition("com.timo.bean.color.Blue");

		boolean red = registry.containsBeanDefinition("com.timo.bean.color.Red");
		if(blue && red){
			//调用BeanDefinitionRegistry的registerBeanDefinition来手动注册类
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			registry.registerBeanDefinition("com.timo.bean.color.Yellow",rootBeanDefinition);
		}

	}

}
