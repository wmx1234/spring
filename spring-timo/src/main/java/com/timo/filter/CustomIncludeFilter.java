package com.timo.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author wmx
 * @version 1.0
 * @description 自定义FileType过滤器
 * @date 2020-04-03
 */
public class CustomIncludeFilter implements TypeFilter {


	/**

	 * @param metadataReader 读取到当前正在扫描类信息
	 * @param metadataReaderFactory 可以获取到其他类信息的
	 * @return whether this filter matches
	 * @throws IOException in case of I/O failure when reading metadata
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

		//获取当前类注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前类的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前类资源（路径等等）
		Resource resource = metadataReader.getResource();

		String className = classMetadata.getClassName();

		if(className.toLowerCase().endsWith("controller")){
			return true;
		}

		return false;
	}
}
