package com.javaex.excption;

import java.io.IOException;
// 예외의 두 종류
// 종류 1. checked Exception -> 반드시 예외처리를 해줘야 한다.
// 종류 2. runtime Exception -> 예외를 처리 해 주지 않아도 된다.

public class ThrowExcept {
	public void executeException() {
		System.err.println("강제 예외 발생");
		throw new IOException("강제 예외");
	}
	
	// Unchecked Exceotion
	
		public void executeRuntimeException() {
			System.err.println("강제 런타임 예외");
			throw new RuntimeException("런타임 예외");
}
		
		public double divide(int num1, int num2) {
			double result;
			
			// 일반적인 예외 -> 구체적인 "예외전환"해서
			// 예외상황에서의 상황 정보를 담고 있는 것이 좋다
			result = num1 / num2;
		}catch (ArithmeticException e) {
			// 구체적인 예외 전환 바깥으로 소갲
			System.err.print("예외의 전환");
			throw new CustomAritheticException("사용자 정의 예외",
					num1, num2);
			
		}
		return result;
}
