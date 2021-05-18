package com.javaex.jdbc.orcale.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AuthorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	selectAll();
//		inserAuthor();
//		updateAuthor();
		deleteAuthor();

	}
	private static void deleteAuthor() {
		// Scanner에서 저자 pk 입력 -> DELECTE
		Scanner scanner = new Scanner(System.in);
		selectAll();
		System.out.print("삭제할 저자:");
		int id = scanner.nextInt();
		
		AuthorDAO dao = new AuthorDAOImpl();
		boolean success = dao.delete(Long.valueOf(id));
		
		System.out.print
		
		
	}
	
	private static void updateAuthor() {
		//Scanner에서 저자 pk, 저자 설명을 입력 -> update
		Scanner scanner = new Scanner(System.in);
		selectAll(); // 목록 출력
		System.out.print("수정할 저자:");
		int id = scanner.nextInt();
		System.out.print("수정할 저자 정보:");
		String desc = scanner.nextLine();
		
		AuthorVO vo = new AuthorVO(Long.valueOf(id),null, desc);
		
		AuthorDAO dao = new AuthorDAOImpl();
		boolean success = dao.update(vo);
		
		System.out.println("UPDATE" + (success? "성공" : "실패"));
		
		selectAll();
	}
	
	private static void insertAuthor() {
		// Scanner에서 이름 입력 -> INSERT
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("저자 이름 :");
		String name = scanner.next();
		
		AuthorVO vo = new AuthorVO(null,name);
		AUthorDAO dao = new AuthorDAOImpl();
		
		boolean success = dao.insert(vo);
		
		System.out.println("INSERT" + (success? "성공" :"실패"));
		
		selectAll();
		scanner.close();
	}
	
	private static void selectAll() {
		AuthorDAO dao = new AuthorDAOImpl();
		List<AuthorVO> list = dao.getList();
		
		// Iterator
		Iterator<AuthorVO> ir = list.iterator();
		
		System.out.println("=========== Author List");
		
		while(it.hasNext()) {
			AuthorVO item = it.next(); // iterator에서 요소 추출
			System.out.printf("%d\t%s\t%s%n",

					item.getId(),
					item.getAuthorName(),
					item.getAuthorDesc());
		}
	}

}
