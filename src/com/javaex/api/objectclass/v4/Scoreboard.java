package com.javaex.api.objectclass.v4;

import java.util.Arrays;

// v4. 깊은 복제
// 얕은 복제 : 필드 값만 복제 -> 참조 타입 필드는 주소가 복사
// 		참조 타입의 필드는 같은 객체를 참조하게 된다
// 깊은 복제
public class Scoreboard imlements Cloneable {
	private int scores[]; // 참조타입 필드

	public int[] getScores() {
		this.scores = scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Scoreboard [scores=" + Arrays.toString(scores) + "]";
	} // 참조 타입 필드
	
	public Scoreboard

	
	
}
