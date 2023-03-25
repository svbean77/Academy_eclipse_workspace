// 05 - f1()
package com.shinhan.day08;

import java.util.Comparator;

// Comparable: 객체를 가져와 비교
// Comparator: 두 개의 값을 비교
public class DescendingInteger implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}
