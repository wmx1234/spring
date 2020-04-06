package com.timo.config;

import com.timo.filter.CustomIncludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author Administrator
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-06
 */
//包扫描，将扫描到带有@Controller、@Service、@Repository、@Component注解的类加载到容器中
@ComponentScan(
		value="com.timo",
		//扫描的时候，只包含includeFilters过滤的组件
		includeFilters={
				//FilterType共有五种类型,详情看源码
				//这里只介绍一下自定义的类型CUSTOM，需要一个实现TypeFilter接口的类
				//@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class}),
				@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {CustomIncludeFilter.class})
		},
		//使用@includeFilters需要将默认过滤方式关闭，默认是全部扫描
		useDefaultFilters=false
		//,
		//扫描的时候，排除excludeFilters过滤的组件
//		excludeFilters = {
//				//按照注解方式过滤，注解类型是Controller.class
//				//FilterType
//				@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//		}
)

/**
 * {@link ComponentScans} @ComponentScans属性值是一个ComponentScan数组,等同于直接配置多个ComponentScan,
 * 注：不能和多个@ComponentScan共存，但是可以和一个@ComponentScan共同使用
 */

@ComponentScans(value = {
		@ComponentScan(value="com.timo.controller",useDefaultFilters = false),
		@ComponentScan(value="com.timo.service",useDefaultFilters = false)
})
@Configuration
public class ComponentScanConfig {


}
