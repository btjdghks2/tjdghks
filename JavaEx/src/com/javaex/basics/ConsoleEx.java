package com.javaex.basics;

import java.util.Scanner; // java.util 패키지의 Scanner  클래스를 로드해라
// 필요한 클래스 들어있는 패키지를 정확하게 지칭해야 한다.
public class ConsoleEx {

	public static void main(String[] args) {
		consoleOutputEx();
		consoleInputEx();
		stringBasic();
		stringFormatEx();
		multiDimArray();
		attayCopySystem();
		

	}
	
	public static void multiDimArray() {
		// 2차원 배열 new type[행수][열수]
		// 3차원 배열 new type[면][행수][열수]
		int[][] twoDimen = new int[5][10]; // 5행10열
		
		int table[][] = {
				{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
				{2, 3, 4, 5, 6, 7, 8, 9, 0, 1},
				{3, 4, 5, 6, 7, 8, 9, 0, 1, 2},
				{4, 5, 6, 7, 8, 9 ,0, 1, 2, 3},
				{5, 6, 7 ,8, 9 ,0, 1, 2, 3, 4}
		};  //배열의 배열
		
		// 배열 내부의 모든 값을 합산
		int total = 0;

		System.out.println("table 배열의 행수:" + table.length);
		for(int row = 0; row < table.length; row;;) {
			for(int col = 0; col < table[row].length; col++) {
				System.out.print(table[row][col] + "\t");
				total += table[row][col];
			}
			System.out.println();
		}
		System.out.println("총계:" + total);
	}
	
	private static void attayCopySystem() {
		// System 객체를 이용한 배열의 복사
		int source[] {1, 2, 3};
	}
		 
	private static void attayCopyFor() {
		
		int source[] = {1, 2, 3};
		int target[] = new int[10];
		
		System.arraycopy(source, // 원본 배열의 식별자
				0, // 복사 시작 인덱스(원본 배열의)
				target, // 복사 대상 배열
				3, // 복사 시작 인덱스(대상 배열의)
				source.length);
		
		// 출력
		for (int i=0; i< < target.length; i++) {
			System.out.print(target[i] + "\t")
		}
		System.out.println();
		
		 // Enhanced For :  순차 객체로부터 값을 하나씩 추출하여 할당
		for (int value : target) {
			System.out.print(false)value + "\t");
	}
		System.out.println();
		//연습
		/* 
	private static void attayCopyFor() {
		
		chr a[] = {t,h,i,s,i,s,a,p,e,n,c,i,l};
		int target[] = new int[10];
		
		System.arraycopy(source, // 원본 배열의 식별자
				0, // 복사 시작 인덱스(원본 배열의)
				target, // 복사 대상 배열
				3, // 복사 시작 인덱스(대상 배열의)
				source.length);
		
		// 출력
		for (int i=0; i< < target.length; i++) {
			System.out.print(target[i] + "\t")
		}
		System.out.println();
		
		 // Enhanced For :  순차 객체로부터 값을 하나씩 추출하여 할당
		for (int value : target) {
			System.out.print(false)value + "\t");
	}
		System.out.println();
	}
	}
	*/
	 // 연습
	private static void stringFormatEx() {
		//형식화된 문자열
		//%s,%d,%f,%n,%%
		
		String food = "사과";
		int total = 10;
		int eat = 3;
		
		System.out.println(total + "개의" + food + "중에서" + 
		eat + "개를 먹었다.");
		
		// -> 포멧화된 출력
		
		System.out.println("%d개의 %s 중에서 %d 개를 먹었다%n",
				total,food,eat);
		// %d, %f 등의 포멧 문자에는 부가 정보를 담을 수 있다.
		float rate = 1.234f;
		// 현재 이자율은 __% 입니다
		
		System.out.printf("현재 이자율은 %f%% 입니다.%n",rate);
		// 부가 정보로 소숫점 자릿수 직전
		System.out.printf("현재 이자율은 %.2f%%입니다.%n", rate);
		
		//포멧 형식은 String.format 메서드를 이용, 문자열 생성시 활용 가능
		String fmt = "%d 개의 %s 중에서 %d 개를 먹었다%n";
		String trsult = String.format(fmt,5, "바나나",2);
		String.out.println(result);
	
	}
	
	
	private static void stringBasic() {
		
		String str;
		str = "Java"
		String str2 = "Java";
		String str3 = new String("Java");
		
		System.out.println("str == str2 ?" + (str == str2));
		System.out.println("str == str3 ?" + (str == str3));
	}
}
	
	private static void consoleInputEx() {
		// 팁1. ctrl + Shift + O
		// 팁2. 자동 완성 기능 활용 : ctrl + Space
			Scanner scanner = new Scanner(System.in); // 표준입역으로부터 데이터 입력
	
			System.out.println("이름을 입력해 주세요");
			System.out.print("이름 : ");
			
			String name = scanner.next();
			
			System.out.print("나이 : ");
			
			int age = scanner.nextInt();
			System.out.println("당신의 이름은" + name + "이고" + age + "살입니다.");
			
			// 쓰고 나면 닫아주자.
			scanner.close();
			
			
	}
	private static void consoleOutputEx() {
		// 콘솔 출력
		// System.out -> 표준 출력
		// System.err -> 표준 에러
		
		// print 매서드 -> 출력 후 개행 안함
		// println 매서드 -> 출력 후 개행 함
		// printf 매서드 -> 형식화된 출력 -> TODO: 뒤쪽 String 항목에서 정리
		System.out.print("Hello");
		System.out.println("Javas");
		
		//이스케이프 문자 : 특수한 의미를 가진 문자
		System.out.println("Hello\nJava"); // /n -> 강제 개행
		System.out.println("Hello\tJava"); // /t -> 탭 문자
		
		System.out.println("Hello,\"java\""); // =" -> "
				// \ 자체를 표기하고자 할 때
		String dir = "C:\\windows\\System";
		System.out.println(dir);
		
		System.err.println("표준 에러 출력!");
		
		
				

	
	}
	
}
