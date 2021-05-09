package com.javaex.oop.shape.vi;

public class ShaprApp {

	public static void main(String[] args) {
//		SHape s = new Shape // 추상 클래스는 인스턴스화 불가
		
		Shape r = new(10,20,100,50);
		Shape c = newCircle(30,40,30);
		
		r.draw();
		c.draw();

	}

}
