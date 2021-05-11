package com.javaex.io.bytestream;

import java.io.IOException;

public class File {

	public class FileClassEx {
		static String rootPath = System.getProperty("user.dir") + "\\files\\";
	}
	public static void main(String[] args) {
		// 파일 객체의 생성
		String rootPath;
		file root = new File(rootPath);
		//파일이 실제 존재하는가?
		System.out.println(rootPath + ":" + root.exists());
		//파일 정보 출력
		printInfo(root);
		
		//디렉토리 생성 : subdir
		
		File child = new File(rootPath + "\\subdir\\");
		
		if(!child.exists()) { // 생성할 디렉터리가 없으면
			child.mkdirs();
			System.out.println("subdir 생성!");
		
		}
		//파일 생성 : myFile.txt
		File newFile = new File(rootPath + "myFile.txt"); // 파일 정보만 생성
		if(!newFile.exists()) {
			try {
				newFile.createNewFile(); // 실제 파일생성
				System.out.println("myFile.txt 생성!");
			} catch(IOException e) {
				System.err.println("파일을 만들지 못했엉!");
			}
		}
		printInfo(root);
		
		// 파일 지우기
		newFile.delete();
		printInfo(root);
				
			}
	
		

	}


