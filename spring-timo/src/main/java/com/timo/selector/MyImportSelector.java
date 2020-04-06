package com.timo.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-06
 */
public class MyImportSelector implements ImportSelector {

	/**
	 * @param importingClassMetadata 当前标注了@Import注解的类的所有注解信息
	 * @return
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		return new String [] {"com.timo.entity.color.Blue","com.timo.entity.color.Red"};
	}
}
