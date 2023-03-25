// 05 - f4()
package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.ToString;

// Arrays.sort 위한 클래스

@AllArgsConstructor
@ToString
public class Car implements Comparable<Car> {
	String model;
	int price;

	@Override
	public int compareTo(Car car) {
//		가격으로 정렬 (오름차순)
//		return this.price - car.price;

//		가격이 같은 친구가 있으면 모델명으로 정렬하고싶다 (내림차순)
		int result = this.price - car.price; // 가격 오름차순
		if (result == 0) {
//			String.compareTo(str): 문자열이 얼마나 차이나는지
			return car.model.compareTo(this.model); // 모델명 내림차순
		}
		return result;
	}
}
