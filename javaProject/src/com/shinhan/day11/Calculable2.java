// 02 - f5()
// 03 - f1()
// 03 - f2()
package com.shinhan.day11;

@FunctionalInterface // 함수형 표현(람다식)으로 표현 가능한지 확인 -> 인터페이스에 1개의 메소드만 존재
public interface Calculable2 {
	int calculate(int x, int y);
}
