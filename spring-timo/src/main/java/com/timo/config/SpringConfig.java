package com.timo.config;

import com.timo.entity.User;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-03-26
 */
//@Configuration 该类作为配置类，自动加载到容器中
@Configuration
//包扫描，将扫描到带有@Controller、@Service、@Repository、@Component注解的类加载到容器中
//@ComponentScan 被@Repeatable注释，表示是可重复注解
@ComponentScan(
		value="com.timo",
		//扫描的时候，只包含includeFilters过滤的组件
		includeFilters={
				@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
		},
		//使用@includeFilters需要将默认过滤方式关闭，默认是全部扫描
		useDefaultFilters=false,
		//扫描的时候，排除excludeFilters过滤的组件
		excludeFilters = {
				//按照注解方式过滤，注解类型是Controller.class
				//FilterType
				@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
		})

/**
 * @ComponentScans 配置多个ComponentScan,等同于直接配置多个ComponentScan,
 * 不能和多个@ComponentScan共存，但是可以和一个@ComponentScan共同使用
 */
@ComponentScans(value = {
		@ComponentScan(value="com.timo",useDefaultFilters = false),
		@ComponentScan(value="com.timo",useDefaultFilters = false)
})
public class SpringConfig {


	/**
	 * 返回类型相当于class属性
	 * id 默认是方法名，也可以在@Bean上指定  比如@Bean("user1")
	 * @Bean相当于配置文件中的bean标签
	 * <bean id="user" class="com.timo.entity.User">
	 * 	 	<property name="userName" value="zhangsan"></property>
	 * 	 	<property name="password" value="123456"></property>
	 * </bean>
	 */

	@Bean
	public User user(){
		User user = new User();
		user.setUserName("zhangsan");
		user.setUserName("123456");
		return user;
	}

}
