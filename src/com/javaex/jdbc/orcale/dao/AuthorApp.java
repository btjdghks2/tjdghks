package com.javaex.jdbc.orcale.dao;

import java.util.Iterator;
import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectAll();

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
