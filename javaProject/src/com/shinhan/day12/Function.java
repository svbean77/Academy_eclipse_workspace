// 01 - Example
package com.shinhan.day12;

// interface: 규격서 (반드시 규칙을 지켜라!)
// 정의되어 있는 추상 메소드를 구현 클래스가 반드시 구현해야 함
// stream에서 배운 function이 아니고 내가 만든거임~
// T는 제네릭 타입: 사용시 결정한다
// 람다 표현식으로 가능한 interface이기를 바란다 -> 추상 메소드가 하나만 존재해야 함!!!!!!!
// 람다 표현식이 아니라면 구현 클래스를 만들거나 익명 구현 클래스 만든다. -> 추상 메소드 여러 개 가능!
@FunctionalInterface // 람다 표현식이 가능한지(함수형 프로그래밍인지) 확인하는 어노테이션
public interface Function<T> {
	public double apply(T t);
}
