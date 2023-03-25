// 03
package com.shinhan.day01;

// VariableTest.java -> 컴파일 VariableTest.css
// 1. JVM이 VariableTest class를 load (Loader에 의해, static이 method 영역에 올라감)
// 2. 검증
// 3. main 시작
public class VariableTest {
int score;
	public static void main(String[] args) {
		// 1. 변수 선언
		int a; //지역 변수(local)
		// System.out.println(a); // 초기화하지 않으면 사용할 수 없음
		// System.out.println(score);  // 변수 생성 시기가 다르기 때문에 에러 (static은 non-static 사용 불가)
		
		// 2. 변수 사용
		a = 10; //할당
		
		System.out.println(a); // 읽기
		System.out.println(a + 20); // 읽기
		
		// 3. 선언 + 사용
		int a2 = 30;
		System.out.println(a2);
	}

}
