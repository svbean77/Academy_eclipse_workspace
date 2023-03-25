package com.shinhan.day03;

public class EnumTest {

	// 상수: 고정값 (final static 변수선언), 대문자로 씀 (약속)
	final static double PI = 3.141592; // final과 static의 순서는 바뀌어도 됨
	static final int MONDAY = 1;
	static final int SUNDAY = 2;
	static final int SUCCESS = 2;

	public static void main(String[] args) {
		f1();
		f2(LoginEnum.SUCCESS);
		f3();
	}

	private static void f3() {

		System.out.println("** 함수 f3 실행 **");
		WeekEnum[] weeks = WeekEnum.values();

		for (WeekEnum week : weeks) {
			System.out.println(week.ordinal() + "번째 요일: " + week.name());
			String weekName = f4(week);
			String weekName2 = f5(week);
			System.out.println("if문: " + weekName);
			System.out.println("switch문: " + weekName2);
			System.out.println("--------------------------------");
		}
	}

	private static String f5(WeekEnum week) {
		String name = null;

		switch (week) { // switch에서는 타입이 정해졌기 때문에 상수 이름만 씀 (enum에 대해서는 if 문보다 간단함)
		case MONDAY:
			name = "월요일";
			break;
		case TUESDAY:
			name = "화요일";
			break;
		case WEDNESDAY:
			name = "수요일";
			break;
		case THURSDAY:
			name = "목요일";
			break;
		case FRIDAY:
			name = "금요일";
			break;
		case SATURDAY:
			name = "토요일";
			break;
		case SUNDAY:
			name = "일요일";
			break;
		default:
			name = "존재하지 않는 요일..";
			break;
		}
		return name;
	}

	private static String f4(WeekEnum week) {
		String name = null;

		if (week == WeekEnum.MONDAY)
			name = "월요일";
		else if (week == WeekEnum.TUESDAY)
			name = "화요일";
		else if (week == WeekEnum.WEDNESDAY)
			name = "수요일";
		else if (week == WeekEnum.THURSDAY)
			name = "목요일";
		else if (week == WeekEnum.FRIDAY)
			name = "금요일";
		else if (week == WeekEnum.SATURDAY)
			name = "토요일";
		else if (week == WeekEnum.SUNDAY)
			name = "일요일";
		return name;
	}

	private static void f2(LoginEnum login) {

		System.out.println("** 함수 f2 실행 **");
		System.out.println(login == LoginEnum.SUCCESS);
		System.out.println(login == LoginEnum.FAIL);

		System.out.println("LoginEnum의 값들 보기");
		LoginEnum[] arr = LoginEnum.values();
		for (LoginEnum item : arr) {
			System.out.println(item.ordinal() + ": " + item.name());
		}
	}

	private static void f1() {
		System.out.println("** 함수 f1 실행 **");
		// enum을 사용하지 않는 경우 -> 오류 발견하기 어려움
		System.out.println(PI);
		// PI = 3.14; // 상수는 고정값: 임의로 변경 불가능

		int input = 2;
		System.out.println(input == SUNDAY); // 관련있는 변수끼리 묶여있지 않아 전혀 다른 상수와 비교함. 상수값이 같아 성공으로는 뜨는 상황
	}

}
