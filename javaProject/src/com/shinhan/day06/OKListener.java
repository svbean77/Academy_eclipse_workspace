// 02
package com.shinhan.day06;

import com.shinhan.day06.Button.ClickListener;

public class OKListener implements ClickListener { // Button.ClickListener도 가능

	@Override
	public void onClick() {
		System.out.println("OK button 클릭시 수앻되는 로직입니다");
		System.out.println("- _ - - - - - - _ - - - - - _ -");

	}

}
