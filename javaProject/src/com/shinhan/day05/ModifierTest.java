// day04. 접근제한자 예제
package com.shinhan.day05;

import com.shinhan.day04.Phone; // 다른 패키지에서 불러오는 것이기 때문에 import해야 함

public class ModifierTest {
	// 다른 패키지 class 불러옴

	public static void main(String[] args) {
		Phone p = new Phone();
		System.out.println(p);
		
		p.f1();

	}

}
