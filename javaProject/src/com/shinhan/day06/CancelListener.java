// 02
package com.shinhan.day06;

public class CancelListener implements Button.ClickListener {
	// Button 내부의 인터페이스를 사용하고 싶다고 써야 함 (버튼이니까)

	@Override
	public void onClick() {
		System.out.println("Cancel Button 클릭시 수행되는 로직");
		System.out.println("* _ * * * * * * _ * * * * * * * _ *");
	}

}
