// 07 - 동기화
package com.shinhan.day09;

import lombok.Setter;

@Setter
public class User1Thread extends Thread {
	Calculator calculator;

	User1Thread() {
		setName("[user - 1 thread]");
	}
	
	void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory3(100);
	}

}
