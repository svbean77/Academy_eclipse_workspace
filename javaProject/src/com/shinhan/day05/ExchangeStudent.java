// 01 - f1()
package com.shinhan.day05;

import java.util.Arrays;

public class ExchangeStudent extends Student { // 같은 package이기 때문에 import하지 않음

	String[] language;

	public ExchangeStudent(String stdId, String name, String[] language) {
		// 부모가 default 생성자 없을 때 해결법
		// 1. 부모가 default 생성자를 만든다.
		// 2. 자식이 명시적으로 생성자를 호출한다.
		super(stdId, name);
		// 부모의 생성자를 호출하지 않은 경우 (or default 생성자를 호출한 경우)
		// this.setStdId(stdId); // stdId: private이기 때문에 setter로 접근
		// this.name = name; // name: public이기 때문에 직접 접근 가능
		this.language = language;
	}

	void display() {
		System.out.println(getClass().getSimpleName() + "에서 추가된 method");
	}

	@Override
	public String toString() {
		// 부모가 가진 정보 + 내가 가진 정보로 toString을 재정의
		return "ExchangeStudent 정보: [language=" + Arrays.toString(language) + ", name=" + name + ", major=" + major
				+ ", score=" + score + ", schoolName=" + schoolName + "]";
	}

}
