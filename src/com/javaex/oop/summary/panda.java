package com.javaex.oop.summary;

public class panda extends Animal {
	public panda(String name, int age) {
		super(name,age);
	}

	@Override
	public void saay() {
		System.out.printf("%s : zzz~~%n",name);
		
	}

}
