// 07
// f1: Student stream (list)
// f2: Account stream (list)
// f3: 숫자 범위로 stream
// f4: data.text, 지금은 그냥 파일 읽음
// f5: data.text, 파일 스트림으로 읽기 p.734
// f6: 중간처리 - 필터링 p.736
// f7: 중간처리 - 필터링 추가문제
// f8: 중간처리 - 필터링한 요소를 매핑 (평균)
// f9: 중간처리 - 기본타입간의 변환 p. 741
// f10: 중간처리 - 복수 개의 요소로 변환 p.743
// f11: 중간처리 - 일반 정렬 방법
// f12: 중간처리 - stream을 이용한 정렬
// f13: 최종처리 - 매칭 + Optimal클래스
// f14: 그룹핑 p.765
package com.shinhan.day11;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest3 {

	public static void main(String[] args) throws IOException, URISyntaxException {
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
//		f11();
//		f12();
//		f13();
		f14();
	}

	private static void f14() {
		List<Student2> data = new ArrayList<>();
		data.add(new Student2("김길동", 95, "남"));
		data.add(new Student2("홍길동", 85, "남"));
		data.add(new Student2("김길순", 100, "여"));
		data.add(new Student2("김아라", 90, "여"));
		data.add(new Student2("박길동", 90, "남"));

//		collect: group으로 집계 후 다시 group이 Collection이 되도록
//		성별로 그룹화하여 점수 평균 계산
		Map<String, Double> map = data.stream()
				.collect(Collectors.groupingBy(s -> s.getGender(), Collectors.averagingDouble(s -> s.getScore())));
		System.out.println(map);
	}

	private static void f13() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] arr2 = {};
		boolean result1 = Arrays.stream(arr).allMatch(num -> num % 2 == 0);
		System.out.println("모두 짝수? " + result1);
		boolean result2 = Arrays.stream(arr).anyMatch(num -> num % 2 == 0);
		System.out.println("일부 짝수? " + result2);
		boolean result3 = Arrays.stream(arr).noneMatch(num -> num % 2 == 0);
		System.out.println("모두 홀수? " + result3);

		System.out.println();
		double avg = Arrays.stream(arr).filter(num -> num % 2 == 0).average().orElse(0); // 있으면 값, 없으면 0 (defualt)
		double avg2 = Arrays.stream(arr2).filter(num -> num % 2 == 0).average().orElse(0); // 있으면 값, 없으면 0 (defualt)
		System.out.println("avg: " + avg);
		System.out.println("avg2: " + avg2);
	}

	private static void f12() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("양4", 90));
		data.add(new Student("김3", 70));
		data.add(new Student("정5", 60));
		data.add(new Student("김2", 80));
		data.add(new Student("최7", 80));

//		Student에 들어있는 정렬 기준으로 정렬해줌! (점수 오름, 이름 내림)
		System.out.println("--- student의 기준대로 ---");
		data.stream().sorted().forEach(st -> System.out.println(st));
		System.out.println("--- 바꾼 기준대로 ---");
		data.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).forEach(st -> System.out.println(st));
	}

	private static void f11() {
		Integer[] arr = { 100, 88, 99, 50, 60 };
//		배열을 사용한 정렬 방법
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
//		어차피 comparator은 함수형 클래스니까 람다 표현식으로 쓰자!
		Arrays.sort(arr, (a, b) -> b - a); // Comparator는 제네릭을 받기 때문에 기본형이 아닌 Wapper class로 선언해야 함!!!!
		System.out.println(Arrays.toString(arr));

		Student[] arr2 = { new Student("이", 90), new Student("김", 77), new Student("박", 77), new Student("김", 80),
				new Student("최", 88), new Student("한", 100), };
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));

		Arrays.sort(arr2, (a, b) -> a.getName().compareTo(b.getName()));
		System.out.println(Arrays.toString(arr2));
	}

	private static void f10() {
//		문장을 단어 단위로 stream 받고싶다!!

		List<String> data = new ArrayList<>();
		data.add("This is java");
		data.add("i am a best developer");
		System.out.println("--- stream 사용한 방법 ---");
		data.stream().flatMap(str -> Arrays.stream(str.split(" "))).forEach(w -> System.out.println(w));

		Stream stream = data.stream().flatMap(str -> Arrays.stream(str.split(" ")));
		stream.forEach(w -> System.out.println(w));
//		stream.forEach(w -> System.out.println(w)); // 이미 stream을 소진했기 때문에 오류 발생

		System.out.println("--- 외부 반복자 for문 사용한 방법 ---");
		for (String row : data) {
			String[] arr = row.split(" ");
			for (String s : arr) {
				System.out.println(s);
			}
		}
	}

	private static void f9() {
		int[] arr = { 10, 20, 70, 90 };
		Arrays.stream(arr).asDoubleStream().forEach(x -> System.out.print(x + " "));
		System.out.println();

		Arrays.stream(arr).boxed().forEach(x -> System.out.println(x.floatValue()));
	}

	private static void f8() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("양4", 90));
		data.add(new Student("김3", 70));
		data.add(new Student("정5", 60));
		data.add(new Student("김2", 80));

		System.out.println("--- 성이 김씨인 학생 ---");
		data.stream().filter(st -> st.getName().startsWith("김")).mapToInt(st -> st.getScore()).average()
				.ifPresent(avg -> System.out.println("평균: " + avg));
	}

	private static void f7() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("양4", 90));
		data.add(new Student("김3", 70));
		data.add(new Student("정5", 60));
		data.add(new Student("김2", 80));

//		점수가 70보다 높은 학생
		System.out.println("--- 점수가 70보다 높은 학생 ---");
		data.stream().distinct().filter(st -> st.getScore() > 70).forEach(st -> System.out.println(st));

		System.out.println("--- 성이 김씨인 학생 ---");
		data.stream().filter(st -> st.getName().startsWith("김")).forEach(st -> System.out.println(st));
	}

	private static void f6() {
		List<String> data = new ArrayList<>();
		data.add("홍길동1");
		data.add("홍길동3");
		data.add("홍길동5");
		data.add("홍길동6");
		data.add("홍길동2");
		data.add("홍길동4");
		data.add("홍길동5");
		data.add("홍길동6");

		data.stream().forEach(str -> System.out.print(str + " / "));
		System.out.println();

//		distinct: 중복 제거
		data.stream().distinct().forEach(str -> System.out.print(str + " / "));
		System.out.println();

//		filter: 조건에 따른 요소 필터링
		data.stream().distinct().filter(s -> s.endsWith("6")).forEach(str -> System.out.print(str + " / "));
	}

	private static void f5() throws URISyntaxException, IOException {
		Path path = Paths.get(StreamTest3.class.getResource("data.txt").toURI());
		System.out.println(path);

		Stream<String> streamData = Files.lines(path, Charset.defaultCharset()); // default는 utf-8 (3byte씩 읽음)
		streamData.forEach(line -> System.out.println(line));
	}

	private static void f4() throws IOException {
//		그냥 파일 읽은거
		System.out.println("--- FileInputStream ---");
		FileInputStream fi = new FileInputStream("src/com/shinhan/day11/data.txt"); // 1byte씩 읽음 (한 줄씩 읽지 않아) 경로는 src,
																					// 한글 깨짐
		int i;
		while ((i = fi.read()) != -1) {
			System.out.print((char) i);
		}

		System.out.println("--- FileReader ---");
		FileReader fr = new FileReader("src/com/shinhan/day11/data.txt"); // 1byte씩 읽음 (한 줄씩 읽지 않아) 경로는 src, 한글 깨짐
		int j;
		while ((j = fr.read()) != -1) {
			System.out.print((char) j);
		}

	}

	private static void f3() {
//		내부 반복자
		IntStream.range(1, 10).forEach(num -> System.out.println(num + "---")); // 1~9의 범위를 stream으로 받겠다!
		IntStream.rangeClosed(1, 10).forEach(num -> System.out.println(num + "@@@")); // 1~10의 범위를 stream으로 받겠다!

//		외부 반복자
		for (int i = 1; i < 10; i++) {
			System.out.println(i + "***");
		}
	}

	private static void f2() {
		List<Account> data = new LinkedList<>();
		data.add(new Account("123", "홍1", 1000));
		data.add(new Account("124", "홍2", 2000));
		data.add(new Account("127", "홍6", 3000));
		data.add(new Account("128", "홍5", 4000));
		data.add(new Account("126", "홍4", 5000));
		data.add(new Account("125", "홍3", 6000));

//		모든 계좌의 잔고의 합 출력
//		Stream을 몰랐다면 향상 for를 썼을 것..: 외부 반복자를 이용한 것
		int total = 0;
		for (Account acc : data) {
			total += acc.getBalance();
		}
		System.out.println("잔고들의 합계: " + total);

//		Stream으로 바꿔보자: 내부 반복자 사용
		Long total2 = data.stream().mapToLong(acc -> acc.getBalance()).sum(); // long > int이기 때문에 형 변환 가능
		System.out.println("내부 반복자 돌림 Account - balance 합계: " + total2);

		total2 = data.stream().map(acc -> acc.getOwner()).count();
		System.out.println("건수는 " + total2);

		data.stream().map(acc -> acc.getOwner()).forEach(owner -> System.out.println(owner + "님의 통장"));
//		forEach: parallelStream으로 하면 내가 입력한 순서가 변할 수 있다
//		forEachOrdered: parallelStream으로 해도 내가 입력한 순서가 보장된다

	}

	private static void f1() {
//		여러 건의 데이터 저장: 베열, Collection (List, Set, Map)
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("김4", 90));
		data.add(new Student("김3", 70));
		data.add(new Student("김5", 60));
		data.add(new Student("김2", 80));

//		데이터를 stream으로 만들어서 중간 처리 + 최종 처리를 하고싶다!
		System.out.println("--- 최종 처리(forEach) ---");
		data.stream().forEach((st) -> { // 이거는 최종 처리만 한 것
			System.out.println(st);
			System.out.println(st.getName() + "의 점수: " + st.getScore());
		});

		System.out.println("--- 중간 처리(mapToInt) + 최종 처리 ---");
		data.stream().mapToInt(st -> st.getScore()).forEach(score -> {
			System.out.println("점수: " + score);
			System.out.println("------------------");
		});

		System.out.println("--- 최종 처리(average, getAsDouble) ---");
		double d = data.stream().mapToInt(st -> st.getScore()).average().getAsDouble();
		System.out.println("평군: " + d);

		System.out.println("--- Optional Double (변수에 저장) ---");
		OptionalDouble option = data.stream().mapToInt(st -> st.getScore()).average();

		option.ifPresent(result -> System.out.println("값: " + result));

		System.out.println("--- Optional Double (이어서 작성 ifPresent) ---");
		data.stream().mapToInt(st -> st.getScore()).average().ifPresent(result -> System.out.println("값: " + result));

		System.out.println("--- Optional Double (이어서 작성 ifPresentOrElse) ---");
		data.stream().mapToInt(st -> st.getScore()).average()
				.ifPresentOrElse(result -> System.out.println("평균값: " + result), () -> {
					System.out.println("평균을 계산할 수 없다..");
				});

	}

}
