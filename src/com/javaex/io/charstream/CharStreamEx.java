package com.javaex.io.charstream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharStreamEx {

	 
		static String rootPath = System.getProperty("user.dir") + "\\files\\";
		static String filename = rootPath + "test.txt";
		
		public static void main(String[] args) {
			//텍스트 기록 (writer.)
			try {
				Writer fw = new Filewriter(filename);
				fw.write("Bit Computer\r\n");
				fw.write("Java programming\r\n");
				fw.write("2021.05");
				fw.flush();
				fw.close();
				
				System.out.println("파일 기록 완료!");
				
				// 텍스트 파일 읽어오기
				Reader fr = new FileReader(filename);
				
				System.out.println("---------------");
				int data = 0;
				while((data = fr.read()) != -1) {
					// int 읽고 -> 내부 데이터는 마지막 2바이트
					System.out.println((char)data);
				}
				System.out.println();
				fr.close();
				System.out.println("파일 읽기 완료");
			} catch (fileNotFoundException e) {
				System.err.println("파일을 찾을 수 업어용!");
			} catch (IOException e) {
				
			}
			}


