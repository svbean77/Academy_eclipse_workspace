// 01 복습 - 16장 확인문제 8번 (Function, Student)
package com.shinhan.day12;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class Example {
	private static Student[] studentList = { new Student("김1", 10, 20), new Student("김2", 10, 20),
			new Student("김3", 10, 20), new Student("김4", 10, 20), new Student("김5", 10, 20) };

	public static void main(String[] args) {
		double engAvg = avg(s -> s.getEngScore());
		System.out.println("영어 평균 점수: " + engAvg);

		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수: " + mathAvg);

//		stream을 사용한 방법
		double engAvg2 = Arrays.stream(studentList).mapToInt(s -> s.getEngScore()).average().orElse(0);
		double mathAvg2 = Arrays.stream(studentList).mapToInt(s -> s.getMathScore()).average().orElse(0);
		System.out.println("영어 평균 점수: " + engAvg2);
		System.out.println("수학 평균 점수: " + mathAvg2);

//		함수로 stream 사용한 방법
		double engAvg3 = avg2(s -> s.getEngScore());
		double mathAvg3 = avg2(s -> s.getMathScore());
		System.out.println("영어 평균 점수: " + engAvg3);
		System.out.println("수학 평균 점수: " + mathAvg3);

	}

//	람다 표현식만 사용한 예제
	public static double avg(Function<Student> f) {
		double result = 0;
		for (Student st : studentList) {
			double d = f.apply(st);
			result += d;
		}

		return result / studentList.length;
	}

//	함수로 람다 표현식과 stream 사용한 방법
	public static double avg2(ToIntFunction<Student> f) {
		return Arrays.stream(studentList).mapToInt(f).average().orElse(0);

	}

}
