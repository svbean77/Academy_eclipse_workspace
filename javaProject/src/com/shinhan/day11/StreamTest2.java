// 06 - (Student) p.727
package com.shinhan.day11;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamTest2 {

	public static void main(String[] args) {
		List<Student> data = Arrays.asList(new Student("홍길동1", 100), new Student("홍길동5", 70), new Student("홍길동3", 80),
				new Student("홍길동2", 40), new Student("홍길동4", 90));

		System.out.println("--- 단순 forEach ---");
		data.forEach(st -> System.out.println(st));

		System.out.println("--- 중간 처리를 하고 싶다! ---");

		OptionalDouble opAvg = data.stream().mapToInt(st -> st.getScore()).average();
		opAvg.ifPresentOrElse(a -> {
			System.out.println("평균이 존재한다!");
			System.out.println("평균은 " + opAvg.getAsDouble());
		}, () -> {
			System.out.println("평균을 계산할 수 없다..");
		});

//		mapToInt: 중간처리 - map: '변형한다'의 의미
//		average: 최종처리 - 평균을 구한다.
		double avg = data.stream().mapToInt(st -> st.getScore()).average().getAsDouble();
		System.out.println("평균: " + avg);

	}

}
