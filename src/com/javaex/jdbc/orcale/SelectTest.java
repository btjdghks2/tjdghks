package com.javaex.jdbc.orcale;

import java.sql.*;
//departments 테이블로부터 모든 레코드를 불러와서
//department _id :department_name  형태출력

public class SelectTest {

	public static void main(String[] args) {
		Connenction conn = null;
		Statement stmt = null;
		ResultSet rs = null; // 레코드 객체
		
		try {
			conn = DBConfig.getConnection();
			//statement 생성
			stmt = conn,CreateStatement(); // connection -> statement
			String sql = "SELECT department_id, department_name" +
						"FROM departments";
		rs = stmt.executeQuery(sql) // SELECT -executeQuery -> ResultSet 반환
		
		while (rs.next()) {
			Long deptid = rs.getLong(1); // 1번째 컬럼의 Long 데이터
			String depatName = rs.getString ("department_name"); // 컬럼의 표시이름으로 값 받아오기
			
			System.out.printf("%d:%s%n", deptId, deptName);
		}
		} catch (SQLException e) {
			e,printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				
				
		}
		}
		
		
		//커넥션 획득
		//statement 생성
		//쿼리 실행
		//결과 객체 받아오기
		//결과 출력

	}

}
