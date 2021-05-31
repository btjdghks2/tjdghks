package com.javaex.oop.summary;

public abstract class Animal {
	
	//필드
	protected String name;
	protected int age;
	
	// 생성자
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
		
	}

	public abstract void saay();
	public void eat() {
		System.out.printf("%s is eating...%n",name);
	}
}
