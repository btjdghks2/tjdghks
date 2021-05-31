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
		// Scanner���� ���� pk �Է� -> DELECTE
		Scanner scanner = new Scanner(System.in);
		selectAll();
		System.out.print("������ ����:");
		int id = scanner.nextInt();
		
		AuthorDAO dao = new AuthorDAOImpl();
		boolean success = dao.delete(Long.valueOf(id));
		
		System.out.print
		
		
	}
	
	private static void updateAuthor() {
		//Scanner���� ���� pk, ���� ������ �Է� -> update
		Scanner scanner = new Scanner(System.in);
		selectAll(); // ��� ���
		System.out.print("������ ����:");
		int id = scanner.nextInt();
		System.out.print("������ ���� ����:");
		String desc = scanner.nextLine();
		
		AuthorVO vo = new AuthorVO(Long.valueOf(id),null, desc);
		
		AuthorDAO dao = new AuthorDAOImpl();
		boolean success = dao.update(vo);
		
		System.out.println("UPDATE" + (success? "����" : "����"));
		
		selectAll();
	}
	
	private static void insertAuthor() {
		// Scanner���� �̸� �Է� -> INSERT
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� �̸� :");
		String name = scanner.next();
		
		AuthorVO vo = new AuthorVO(null,name);
		AUthorDAO dao = new AuthorDAOImpl();
		
		boolean success = dao.insert(vo);
		
		System.out.println("INSERT" + (success? "����" :"����"));
		
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
			AuthorVO item = it.next(); // iterator���� ��� ����
			System.out.printf("%d\t%s\t%s%n",

					item.getId(),
					item.getAuthorName(),
					item.getAuthorDesc());
		}
	}

}
