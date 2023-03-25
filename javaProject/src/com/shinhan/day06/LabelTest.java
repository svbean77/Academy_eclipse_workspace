// 01
package com.shinhan.day06;

public class LabelTest {

	public static void main(String[] args) {
		Label v1 = new Label(20, 5, "이름입력", "black", "large");
		Resizable v2 = new Label(20, 5, "이름입력", "black", "large");
		Colorable v3 = new Label(20, 5, "이름입력", "black", "large");
		Changeable v4 = new Label(20, 5, "이름입력", "black", "large");

		// v1은 전부 보임
		v1.setBackground(null);
		v1.setFont(null);
		v1.setForeground(null);
		v1.resize(0, 0);

		v2.resize(0, 0);

		v3.setBackground(null);
		v3.setForeground(null);

		v4.setBackground(null);
		v4.setFont(null);
		v4.setForeground(null);
		v4.resize(0, 0);

		work(v1);
//		work(v2); // 자식에 부모를 담을 수 없음
//		work(v3); // 자식에 부모를 담을 수 없음
		work(v4);
	}

	// 자동형변환: 부모타입 객체참조변수 = 자식객체
	private static void work(Changeable c) {
		if (c instanceof Label label) {
			label.setBackground(null);
			label.setFont(null);
			label.setForeground(null);
			label.resize(0, 0);
		}

	}

}
