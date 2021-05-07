package com.javaex.basics;

public class OperEx {

	public static void main(String[] args) {
		 arithOperEx();
		logicOper();
		 bitOper();
		 bitShift();
		 conditionalOper();
		 
	}
	
	// 鍮꾪듃 �떆�봽�듃 �뿰�궛�옄
	// 鍮꾪듃 �떒�쐞 �씠�룞
	private static void bitShift() {
		int data = 1;
		
		System.out.println(data);
		System.out.println("1鍮꾪듃 �쇊履� �떆�봽�듃 : "  + 
				Integer.toBinaryString (data << 1));
		System.out.println("4鍮꾪듃 �쇊履� �떆�봽�듃 : "  + 
				Integer.toBinaryString (data << 4));
		
		data  = 0b100;
		System.out.println("�썝蹂�:" +
				Integer.toBinaryString (data));
		
		
		
		
		
	}
	// 3�빆 �뿰�궛�옄 : 議곌굔遺� �뿰�궛
	private static void conditionalOper() {
		int a =10;
		
		// a媛� 吏앹닔(2�쓽 諛곗닔)硫� 吏앹닔, �븘�땲硫� ���닔
		String message;
		//議곌굔�떇 ? 李� �씪�븣�쓽 媛� : 嫄곗쭞留먯씪�븣�쓽 媛�
		message = a % 2 == 0? "吏앹닔" : "���닔";
		
		System.out.println(a + "�뒗 " + message);
		
		int score = 40;
		
		// 80 �젏 �씠�긽�씠硫� Good
		// 80~50 �씠硫� pass
		// 洹� �씠�븯硫� Fail
		message = score >= 80? "Good" : score >=  50 ? "pass" : "Fail";
		
		System.out.println("�젏�닔 : " + score + ", 寃곌낵 : " + message);
		
	}
	
	
	// 鍮꾪듃 �뿰�궛�옄
	// 鍮꾪듃�떒�쐞濡� 誘몄꽭�븳 議곗옉�씠 �븘�슂�븷 �븣 �궗�슜
	// �븯�뱶�썾�뼱 ���뿉 , �씠誘몄� �봽濡쒖꽭�떛
	private static void bitOper() {
		byte b1 = 0b1101;
		byte b2 = 0b0111;
		
		System.out.println("b1:" + Integer.toBinaryString(b1));
		System.out.println("b2:" + Integer.toBinaryString(b2));
		int result = b1 & b2; // 鍮꾪듃 �끉由� 怨� : �몮�떎 1�씠�뼱�빞 1鍮꾪듃濡� �꽭�똿
		System.out.println("b1&b2:" + Integer.toBinaryString(result));
		result = b1 | b2;	// 鍮꾪듃 �끉由� �빀 : �몮 以� �븳 媛쒕쭔 1�씠硫� 1鍮꾪듃 �꽭�똿
		System.out.println("b1|b2:" + Integer.toBinaryString(result));
		result =~b1; // 鍮꾪듃 �끉由� 遺��젙 : 1 <-> 0
		System.out.println("~b1:" + Integer.toBinaryString(result));
		
	}
	
	
	// 鍮꾧탳�뿰�궛, �끉由� �뿰�궛
	// 寃곌낵濡� boolean  諛섑솚, �끉由� 媛믪쑝濡� �봽濡쒓렇�옩�쓽 �쓲由� �젣�뼱 -> 以묒슂
	private static void logicOper() {
			// qlry dustkswk >,>=,<,<=,==(媛숇떎), !=(媛숈� �븡�떎)
		int n1 = 7;
		int n2 = 3;
		
		System.out.println("a媛� b�� 媛숈�媛�? " +(n1 == n2));
		System.out.println("a媛� b�� 媛숈� �븡��媛�?" + (n1 != n2));
		
		// �끉由� �뿰�궛 : AND (�끉由ш낢 :&&), OR(�끉由ы빀 : ||), NOT(�끉由� 遺��젙 : !)
		// -> 吏묓빀�쓣 �뼚�삱由ъ옄

		int n3 = 5;
		
		// n3�뒗 0 珥덇낵, 10 誘몃쭔�쓽 媛믪씤媛�?
		// 議곌굔 1: n3 > 0
		// 議곌굔 2: n3 < 10
		// 議곌굔 1and 議곌굔 2 : 援먯쭛�빀 �쁺�뿭
		boolean r1 = n3 > 0;	//議곌굔 1
		boolean r2 = n3 < 10;	//議곌굔 2
		boolean r1andr2 = r1 && r2;// n3 > 0 && n3 < 10
		System.out.println("n3媛� 0珥덇낵 10誘몃쭔 �쁺�뿭�뿉 �엳�뒗媛�?" + r1andr2);
		
		// n3�뒗 0�씠�븯�씠嫄곕굹 10 �씠�긽�쓽 媛믪씤媛�?
		//	議곌굔1: n3 <= 0
		//	議곌굔 2 :n3 >= 10
		// -> 議곌굔 1 or 議곌굔 2 : �빀吏묓빀 �쁺�뿭
		r1 = n3 <= 0; // 議곌굔1
		r2 = n3 >= 10; // 議곌굔2
		boolean r1orr2 = r1||r2; // n3 <= 0|| n3 >= 10
		System.out.println("n3媛� 0�씠�븯�씠嫄곕굹 n3媛� 10 �씠�긽�쓽 �쁺�뿭?" + r1orr2);
		
		// not �끉由щ��젙 -> trun <-> false 諛섏쟾
		boolean rNot =!(n3>0 && n3 < 10); // �뿬吏묓빀 �쁺�뿭
		// -> n3 <=0 || n3 >=0
		System.out.println("�끉由щ��젙 : " + rNot);
		
		
	}
	
	// �궛�닠 �뿰�궛�옄
	private static void arithOperEx() {
		int a = 7;
		int b = 3;
		
		//遺��샇�뿰�궛�옄 : +,-
		System.out.println(-a); // a*-1
		
		// �궗移숈뿰�궛 +,-,*,/
		System.out.println(a + "/" + b + "=" + (a / b)); // �젙�닔 �굹�닓�뀍�쓽 紐� 
		System.out.println("a瑜� b濡� �굹�늿 �굹癒몄� :" + (a % b)); // �젙�닔 �굹�닓�뀍�쓽 �굹癒몄�

	// �젙�닔 / �젙�닔 -> �젙�닔
		//�떎�젣 �굹�닓�뀍�쓽 寃곌낵�뒗 ?
		System.out.println((float)a /(float)b); // int -> float 濡� 蹂��븿
		System.out.println((float)a/ b); // b�뒗 float濡� �옄�룞蹂��솚
	
		System.out.println("---------");
		// 利앷컧�뿰�궛�옄 ++,--
		// �쐞移섏뿉 �뵲�씪 �뿰�궛�닚�꽌媛� �떖�씪吏꾨떎.
		a=7;
		
		System.out.println("a:" + a);
		System.out.println("�쟾�쐞 利앷컧�뿰�궛 : " + (++a));
		System.out.println("理쒖쥌 a : " + a);
		
		a = 7;
		System.out.println("a:" + a);
		System.out.println("�썑�쐞 利앷컧�뿰�궗 :" + (a++));
		System.out.println("理쒖쥌 a : " + a);
		
		// �굹�닓�깦 蹂댁땐 
		a = 7;
	//	System.out.println( a / 0); -> �젙�닔瑜� 0�쑝濡� �굹�늻硫� ArithmeticExcepyion
		System.out.println((float)a / 0); // Infinity
		
		// Infinity媛� �룷�븿�맂 �뿰�궛�떇�� �빆�긽 Infinity
		// Infinity�쓽 泥댄겕 �빆�긽 �븘�슂�븿
		
		System.out.println("7.0/ 0 �� �쑀�븳�닔�씤媛�?" + Double.isFinite(7.0/0));
		
		//Infinity 媛� �룷�븿�맂 �뿰�궛�떇 -> Infinity
		System.out.println("0.0 / 0.0 ?" + (0.0/0.0));// Not A Number
		// NaN媛� �룷�븿�맂 �뿰�궛�떇 -> NaN
		System.out.println("0.0/0.0 is NaN?" + Double.isNaN(0.0 / 0.0));
		System.out.println( 0.0 / 0.0 + 10); //洹몃옒�룄 NaN
		
		
		
	}
}
