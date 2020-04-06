package com.timo.config;


import com.timo.bean.color.Blue;
import com.timo.bean.color.Color;
import com.timo.selector.MyImportBeanDefinitionRegistrar;
import com.timo.selector.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-06
 */
@Configuration
@Import({Blue.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ImportConfig {
}
