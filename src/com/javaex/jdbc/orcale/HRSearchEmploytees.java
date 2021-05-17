package com.javaex.jdbc.orcale;

import java.sql.*;
// Scanner로 키워드 입력
// first_name, last_name 필드 대상 부분 검색
// 이름 성, Email, 전화번호, 입사일 출력
import java.util.Scanner;

public class HRSearchEmploytees {

	public static void main(String[] args) {
		Connection conn = null;;
		Statement stmt = null;
		ResultSet rs =null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = DBConfig.getConnection();
			
			System.out.print("검색어:");
			String keyword = scanner.next();
			
			String sql = "SELECT first_name, last_name," +
			"email,phone_number, hire_date" +
			"FROM employees" +
			"WHERE lower(first_name) LIKE '%" + keyword.toLowerCase() + "%OR" +
			"lower(last_name) Like '"% + keyword.toLowerCase() + "%'";
			
		System.out.println("QUERY:" sql);
		
		stmt = conn.createStatement();
		// 쿼리 수행
		rs = stmt.executeQuery(sql);
		//Loop
		while(rs.next()) {
			String firstName = rs.getString(1);
			String lastName = rs.getString(2);
			String email = rs.getString("email");
			String phoneNumber = rs.getString("phone_number");
			String hireDate= rs.getDate("hire_date"); // java.util.Date
			
			//출력
			System.out/printf("%s%s:%s,%s,%s%n",
					firstName, lastName, email,phone_)
		}
		}

	}

}
