// 02 - f2() p.697
package com.shinhan.day11;

@FunctionalInterface // 함수형 표현(람다식)으로 표현 가능한지 확인 -> 인터페이스에 1개의 메소드만 존재
public interface Calculable {
	void calculate(int x, int y);
}
