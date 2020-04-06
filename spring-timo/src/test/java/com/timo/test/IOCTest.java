package com.timo.test;



import com.timo.config.FactoryBeanConfig;
import com.timo.config.ImportConfig;
import com.timo.config.BeanConfig;
import com.timo.bean.Person;
import com.timo.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-01
 */
public class IOCTest {

	/**
	 * 测试配置类中@Bean和xml配置
	 */
	@Test
	public void test01(){

		//读取配置类中的Bean
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		//读取项目目录下xml配置文件中的Bean
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring.xml");



		Person person = (Person)applicationContext.getBean("person");

		System.out.println(person);



		User user2 = (User)applicationContext.getBean("user");

		System.out.println(user2);
	}



	/**
	 * 测试@Scope
	 */
	@Test
	public void test02(){

		//读取配置类
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

		//user在上面容器启动的时候就已经加载到了容器中，而且是单例的，只会调用一次
		Person singletonPerson01 = (Person)applicationContext.getBean("person01");

		Person singletonPerson02 = (Person)applicationContext.getBean("person01");

		Person prototypePerson01 = (Person)applicationContext.getBean("person02");

		Person prototypePerson02 = (Person)applicationContext.getBean("person02");

		//@Bean默认是单例的 true
		System.out.println(singletonPerson01 == singletonPerson02);
		//@Scope("prototype") false
		System.out.println(prototypePerson01 == prototypePerson02);

	}

	/**
	 * 测试@Conditional()注解
	 */

	@Test
	public void test03(){

		//读取配置类
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

		Environment environment = applicationContext.getEnvironment();

		System.out.println(environment.getProperty("os.name"));

		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

		for (String s : beanNamesForType) {
			System.out.println(s);
		}
	}

	/**
	 * 测试@ComponentScan注解
	 */
	@Test
	public void test04(){
		//
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		System.out.println("==========================================================");
		for(String name : beanDefinitionNames){
			System.out.println("bean name:"+name);
		}
		System.out.println("==========================================================");
	}

	/**
	 * {@link Import}
	 */
	@Test
	public void test05(){

		//读取配置类
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);

		printBeanName(applicationContext);

	}

	@Test
	public void test06(){

		//读取配置类
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);

		//虽然配置类中返回的是ColorFactoryBean但是实际获取的确实Color对象
		//输出结果： bean type:class com.timo.entity.color.Color
		Object colorBean = applicationContext.getBean("colorFactoryBean");
		System.out.println("bean type:"+colorBean.getClass());

		//如果就是想获得ColorFactoryBean本身对象
		//输出结果：bean type:class com.timo.entity.color.ColorFactoryBean
		Object colorFactoryBean = applicationContext.getBean("&colorFactoryBean");
		System.out.println("bean type:"+colorFactoryBean.getClass());
	}

	public void printBeanName(AnnotationConfigApplicationContext applicationContext){
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		for (String s : beanDefinitionNames) {
			System.out.println(s);
		}
	}
}
