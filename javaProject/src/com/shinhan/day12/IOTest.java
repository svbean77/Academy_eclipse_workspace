// 02 - 입출력
// f1: InputStream byte 배열 읽기
// f2: 1byte씩 읽기 - FileInputStream, day11 data.txt 읽기!, stream to reader (보조스트림)
// f3: 2byte씩 읽기 - FileReader로 읽기, day11 data.txt 읽기!
// f4: 상대경로, 절대경로 연습
// f5: 한 줄씩 읽기 - BufferedXxx
// f6: stream의 files.lines 사용해보기 (어제 했었음) f5랑 같은 결과 만들기!
// f7: 기본 타입을 보장해 파일 작성 p.805
// f8: PrintWriter
// f9: 직렬화 (Student)
// f10: 직렬화 (Account)
// f11: File
package com.shinhan.day12;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

public class IOTest {

	public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
		f11();
	}

	private static void f11() {
		String fileName = "src/com/shinhan/day12/scoredata.txt";
		File f = new File(fileName);
		System.out.println("파일이 존재? " + f.exists());
		Date d = new Date(f.lastModified());
		System.out.println("마지막 수정 날짜? " + d);
		System.out.println("파일 길이? " + f.length());
		System.out.println("폴더냐? " + f.isDirectory());
		System.out.println("파일이냐? " + f.isFile());
	}

	private static void f10() throws IOException, ClassNotFoundException {
		FileOutputStream fw = new FileOutputStream("serialized2.dat"); // 확장명은 아무거나 줘도 됨 (객체를 변형시켰으니 깨진 문자로 보일거야)
		ObjectOutputStream oos = new ObjectOutputStream(fw);

		oos.writeObject(new Account("123", "김1"));
		oos.writeObject(new Account("443", "김2"));
		oos.writeObject(new Account("5553", "김3"));

//		가까운 자원을 먼저 반납
		oos.close();
		fw.close();

		FileInputStream fi = new FileInputStream("serialized2.dat");
		ObjectInputStream ois = new ObjectInputStream(fi);
		Account s1 = (Account) ois.readObject();
		Account s2 = (Account) ois.readObject();
		Account s3 = (Account) ois.readObject();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		fi.close();
	}

	private static void f9() throws IOException, ClassNotFoundException {
		FileOutputStream fw = new FileOutputStream("serialized.dat"); // 확장명은 아무거나 줘도 됨 (객체를 변형시켰으니 깨진 문자로 보일거야)
		ObjectOutputStream oos = new ObjectOutputStream(fw);

		oos.writeObject(new Student("kim1", 100, 99));
		oos.writeObject(new Student("kim2", 100, 99));
		oos.writeObject(new Student("kim3", 100, 99));

//		가까운 자원을 먼저 반납
		oos.close();
		fw.close();

		FileInputStream fi = new FileInputStream("serialized.dat");
		ObjectInputStream ois = new ObjectInputStream(fi);
		Student s1 = (Student) ois.readObject();
		Student s2 = (Student) ois.readObject();
		Student s3 = (Student) ois.readObject();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		fi.close();
	}

	private static void f8() throws IOException {
		FileWriter fw = new FileWriter("print.txt");
		PrintWriter pw = new PrintWriter(fw);

		pw.print(false); // fw에는 없던 기능!
		pw.print("false");
		pw.write(97);
		pw.write("true");

		pw.close();
		fw.close();
	}

	private static void f7() throws IOException {
		FileWriter fw = new FileWriter("primitiveData.txt");
//		char, int 타입만 보장할 수 있음! 다른 타입은 살릴 수 없어
		fw.write(100);
		fw.write(200);

		FileReader fr = new FileReader("primitiveData.txt");
		int a = fr.read();
		int b = fr.read();

		System.out.println("a + b = " + (a + b));

		fw.close();
		fr.close();

//		그대로 얻을 수 있음!
		OutputStream fw2 = new FileOutputStream("primitiveData2.txt");
		DataOutputStream dos = new DataOutputStream(fw2);
		dos.writeInt(100);
		dos.writeInt(200);
		dos.writeBoolean(false);
		dos.writeDouble(3.14);
		dos.writeChar('A');
		dos.close();

		FileInputStream fr2 = new FileInputStream("primitiveData2.txt");
		DataInputStream dis = new DataInputStream(fr2);
		int c = dis.readInt();
		int d = dis.readInt();
		boolean e = dis.readBoolean();
		double f = dis.readDouble();
		char g = dis.readChar();
		System.out.println("c: " + c);
		System.out.println("d: " + d);
		System.out.println("e: " + e);
		System.out.println("f: " + f);
		System.out.println("g: " + g);

		dis.close();
		fr2.close();
	}

	private static void f6() throws IOException {
		String fileName = "src/com/shinhan/day12/scoredata.txt";
		Path path = Paths.get(fileName);
		Files.lines(path).forEach(row -> {
			System.out.print(row.replace("/", "\t"));
			String[] arr = row.split("/");
			int total = 0;
			for (int i = 1; i < arr.length; i++) {
				try {
					total += Integer.parseInt(arr[i]);
				} catch (NumberFormatException e) {
				}
			}
			if (total != 0) {
				System.out.println("\t" + total + "\t" + (total / (arr.length - 1)));
			} else {
				System.out.println("\t총점\t평균");
			}
		});
	}

	private static void f5() throws IOException {
		String path = "src/com/shinhan/day12/scoredata.txt";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String row;
		String title = row = br.readLine(); // 얘는 제목이니까 총점, 평균 계산 안하니 따로 빼두자
		System.out.println(title.replaceAll("/", "\t") + "\t총점\t평균");
		System.out.println("-------------------------------------------");
		while ((row = br.readLine()) != null) {
			System.out.print(row.replaceAll("/", "\t"));
//			점수 평균 계산을 하고싶어!!
			String[] arr = row.split("/");
			int total = 0;
			for (int i = 1; i < arr.length; i++) {
				total += Integer.parseInt(arr[i]);
			}

			System.out.println("\t" + total + "\t" + (total / (arr.length - 1)));
		}

		fr.close();
	}

	private static void f4() throws IOException, URISyntaxException {
		// 1. 현재 class기준 (bin)
		Path path = Paths.get(IOTest.class.getResource("Example.class").toURI());
		System.out.println(path);
		// 2.절대경로: /로 시작한다.
		Path path2 = Paths.get(IOTest.class.getResource("/com/shinhan/day11/data.txt").toURI());
		System.out.println(path2);
		// 3.상대경로는 현재위치를 기준으로한다.
//		//다음은 현재의 절대경로를 얻는다.
		Path path3 = Paths.get("");
		System.out.println(path3.toAbsolutePath());
		String path4 = System.getProperty("user.dir");
		System.out.println(path4);
	}

	private static void f3() throws IOException {
		String path = "src/com/shinhan/day11/data.txt"; // 상대 경로
//		맨 앞을 /로 시작: 절대 경로, 폴더로 시작: 상대 경로
		FileReader fr = new FileReader(path);
		FileWriter fw = new FileWriter("src/com/shinhan/day11/data2.txt"); // 경로에 저장됨! 이름은 data2.txt

		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
			fw.write(i); // 파일 복사 로직임!!!
		}
		fr.close();
		fw.close(); // 읽기, 쓰기로 용도가 다르기 때문에 누구를 먼저 닫든 ㄱㅊ
	}

	private static void f2() throws IOException {
		String path = System.getProperty("user.dir");
		System.out.println(path); // 절대 경로 얻기, 이 이후의 경로를 적어야 함
		path += "/src/com/shinhan/day11/data.txt"; // 경로에 \를 넣어도 됨! 하지만 \를 넣기 위해 \\로 역슬래시를 넣어야 함 (제어문자로 인식)
		FileInputStream fi = new FileInputStream(path);

		System.out.println("--- FileInputStream ---");
		int i; // -1은 EOF (End Of File) -> while문으로 -1이 아닐 때까지 돌면 됨!
		while ((i = fi.read()) != -1) {
			System.out.print((char) i);
		}

		System.out.println("--- InputStreamReader (stream to reader) ---");
		FileInputStream fi2 = new FileInputStream(path);
		InputStreamReader ir = new InputStreamReader(fi2); // stream을 reader로 바꿔줌
		while ((i = ir.read()) != -1) {
			System.out.print((char) i);
		}

		fi.close();
		ir.close();
		fi2.close();
	}

	private static void f1() throws IOException {
//		InputStream, OutputStream (1byte 처리), Reader, Writer (2byte 처리)
//		FileInputStream, FileOutputStream: 파일을 입출력 하나보네! 1byte씩 처리하나보네!
//		FileReader, FileWriter: 파일을 입출력 하나보네! 2byte씩 처리하나보네!
		InputStream is = System.in; // 표준입력: 키보드. 변경 가능(System.setXxx)

		byte[] arr = new byte[100];
		int i = is.read(arr);
		System.out.println(i); // 몇 개의 데이터가 들어갔는가 (마지막 2개는 엔터, 줄바꿈 따라서 2개 없애야 데이터임)
		System.out.println(Arrays.toString(arr));

		for (int j = 0; j < i - 2; j++) {
			System.out.print((char) arr[j]);
		}
	}

}
