// 03 - 18장 LAB4_입출력
package com.shinhan.day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCalculator {
	public static void main(String[] args) throws Exception {
		String path = "C:\\SWacademy\\week1\\javaProject/src/com/shinhan/day12/data.txt";
		new FileCalculator().addCalculateResult(path);
	}

	void addCalculateResult(String inputFileName) throws Exception {
		FileReader fi = new FileReader(inputFileName);
//		DataInputStream dis = new DataInputStream(fi); // 저장할 때 DataOutputStream이 아니었기 떄문에 실패!
		BufferedReader br = new BufferedReader(fi);
		String line;
		int sum = 0;
		int mul = 1;

		while ((line = br.readLine()) != null) {
			sum += Integer.parseInt(line);
			mul *= Integer.parseInt(line);
			System.out.println(line);
		}
		System.out.println("합: " + sum + ", 곱: " + mul);
		br.close();
		fi.close();

		FileWriter fw = new FileWriter(inputFileName, true); // 기존 파일에 추가를 하고 싶다면 두 번째를 true로 쓰면 됨!!!!
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(sum + "");
		bw.newLine();
		bw.write(mul + "");
		bw.newLine();

		bw.close();
		fw.close();
	}
}
