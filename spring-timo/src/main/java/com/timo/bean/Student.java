package com.timo.bean;

import lombok.Data;

/**
 * @author wmx
 * @version 1.0
 * @description
 * @date 2020-04-03
 */
@Data
public class Student {

	private String name;

	private int age;

	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
}
