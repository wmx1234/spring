package com.timo.bean;

import lombok.Data;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-03
 */
@Data
public class Person {

	private String name;

	private int age;

	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}

	public void init(){

	}
}
