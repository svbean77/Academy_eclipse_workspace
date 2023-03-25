// 07 - 동기화
package com.shinhan.day09;

import lombok.Setter;

@Setter
public class User2Thread extends Thread {
	Calculator calculator;

	User2Thread() {
		setName("[user - 2 thread]");
	}
	
	void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory2(50);
	}

}
