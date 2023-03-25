// 05 - p.675

package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = { "name" })
public class Fruit implements Comparable<Fruit> {
	String name;
	int price;

	@Override
	public int compareTo(Fruit fruit) {
		int result = name.compareTo(fruit.name);
		if (result == 0) {
			return price - fruit.price;
		}
		return result;
	}

}
