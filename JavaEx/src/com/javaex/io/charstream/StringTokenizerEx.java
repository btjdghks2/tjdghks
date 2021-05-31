package com.javaex.io.charstream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class StringTokenizerEx {
	static String rootPath = System.getProperty("user.dir") + "\\files\\";
	static String filename = rootPath + "thieves.txt"; 
	
	//FileReader,BufferedReader, StringTokenizer의 조합으로 만들어 봅시다

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Reader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				// 분절
				StringTokenizer st = new StringTokenizer(line, ""); // 공백으로 분절
				
				whlie (st.hasMoreTokens()) { // 남아있는 토큰 확인
					String token = st.nextToken();
					System.out.print(token + " ");
				}
				System.out.println();
			}
		}catch (fileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			}
			
		}

	}


