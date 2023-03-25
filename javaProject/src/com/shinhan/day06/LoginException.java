// 08
package com.shinhan.day06;

// 사용자 정의 예외
// 만드는 이유: 업무상 예외 처리를 일관성있게 하기 위해 만듦
// extends 상위Exception (Exception: 일반예외, RuntimeException: 실행예외)
// 강제성을 주고 싶다면 Exception 상속: 일반 예외는 컴파일시 해결해야 하기 때문!
public class LoginException extends Exception {
	// Exception을 상속받으면 사용자 정의 예외로 사용할 수 있음!
	// Exception: 컴파일시 예외처리 필수
	// RuntimeException: 예외처리 필수는 아님

	public LoginException(String errMessage) {
		super(errMessage); // Exception 생성자 중 에러 메시지를 설정하는 게 있음! 따라서 명시적으로 호출
	}
	
	public void printMessage() {
		System.out.println("[ERROR] 로그인: " + getMessage());
	}
}
