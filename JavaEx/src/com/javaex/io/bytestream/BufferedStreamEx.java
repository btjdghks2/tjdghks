package com.javaex.io.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class BufferedStreamEx {

	
		static String rootPath = System.getProperty("user.dir") + "\\files\\";
		static String source = rootPath + "img.jpg";
		static String target = rootPath + "img_buffered_copy.jpg";

		public static void main(String[] args) {
			try {
				InputStream fis = new FileInputStream(source); // 주스트림
				outputStream fos = new FileOutputStream(target); // 주스트림
				
				// 보조 스트림 : 주그트림으로부터 Stream을 얻어온다
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				
				//데이터 읽어오기
//				int data = 0;
				byte[] data = new byte[10240];// 10KB짜리 버퍼
				int size = 0; // 읽어온 데이터 바이트 수
				
				while((size = bis.read(data)) != -1) {
					bos.write(data); // 출력
					System.out.println(size + "바이트 복사했습니다");
					
				}
				
				bis.close();
				bos.close();
				// 보조 스트림을 닫으면 기반 스트림도 닫힌다
				
				System.out.println("파일을 복사했습니다!");
			} catch (fileNotFoundException e) {
				System.err.println("파일을 찾을 수 없습니다.");
			} catch (IOException e)
			}
		}

}
