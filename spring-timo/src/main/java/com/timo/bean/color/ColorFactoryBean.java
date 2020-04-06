package com.timo.bean.color;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-06
 */
public class ColorFactoryBean implements FactoryBean<Color> {
	@Override
	public Color getObject() throws Exception {
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}
}
