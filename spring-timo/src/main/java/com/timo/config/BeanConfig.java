package com.timo.config;

import com.timo.bean.Person;
import com.timo.filter.LinuxConditionFilter;
import com.timo.filter.WindowsConditionFilter;
import org.springframework.context.annotation.*;

/**
 * @author wmx
 * @version 1.0
 * @description 通过@Bean注解给容器注入组件
 * @date 2020-03-26
 */
@Configuration
public class BeanConfig {

	/**
	 * 返回类型相当于class属性
	 * id 默认是方法名，也可以在@Bean上指定  比如@Bean("user1")
	 * @Bean相当于配置文件中的bean标签
	 * <bean id="person" class="com.timo.entity.Person">
	 * 	 	<property name="userName" value="zhangsan"></property>
	 * 	 	<property name="password" value="123456"></property>
	 * </bean>
	 */
	@Bean
	public Person person(){
		System.out.println("person被加载到容器中");
		return new Person("张三",18);
	}


	/**
	 * 默认是单例模式，在容器创建之后，会直接加载组件到容器中
	 * @Lazy开启懒加载,在首次使用的时候才会将组件加载到容器中
	 * @return
	 */
	@Lazy
	@Bean("person01")
	public Person person01(){

		System.out.println("person被加载到容器中");

		return new Person("张三01",18);
	}

	/**
	 * singleton单例 （默认）在这种情况下，当IOC容器启动的时候,就调用该方法创建实例放入到容器中
	 * 注：如果想要singleton模式下，也是在调用的时候再创建实例放入到容器中，可以使用@Lazy实现懒加载
	 * prototype多实例 当IOC容器启动的时候,并不会调用方法创建实例放入到容器中，而是在每次获取的时候才会调用方法创建对象
	 *
	 * web项目中
	 * request 每个request一个实例
	 * session 每个session一个实例
	 */
	@Scope("prototype")
	@Bean("person02")
	public Person Person02(){
		System.out.println("student被加载到容器中");
		return new Person("张三02",18);
	}

	/**
	 * 当在linux环境下运行时，注册改组件(可以在Edit Configurations的VM options下设置，然后进行测试)
	 * {@link Conditional} 表示有条件的给容器注册Bean,接收一个Condition类类型的数组
	 * @return
	 */
	@Conditional({LinuxConditionFilter.class})
	@Bean
	public Person linus(){
		return new Person("Linus",50);
	}

	/**
	 * 当在Windows环境下运行时，注册改组件
	 */
	@Conditional({WindowsConditionFilter.class})
	@Bean
	public Person bill(){
		return new Person("Bill Gates",65);
	}
}
