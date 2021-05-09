package com.javaex.oop.shape.vi;

public class Circle extends Shape{
	// 
	pritected double radius;	//반지름
	
	// 생성자
	public Circle(int x, int y, double radius) {
		super(x,y);
		this.radius = radius;
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
			System.out.printf("dnjs[x=%d,y=%d,area=%,2f]을 그렸습니다", )
	}
	

	@Override
	public void area() {
		// TODO Auto-generated method stub
		return Math.PI *radius*radius;
	}


}
