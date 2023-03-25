// 01
package com.shinhan.day08;

public class Service {
	@PrintAnnotation
//	"-", 7, "내 프린트다"
	public void method1() {
		System.out.println("실행 내용1");
	}

	@PrintAnnotation("*")
//	"*", 7, "내 프린트다"
//	기본적으로 적지 않으면 value로 들어감
	public void method2() {
		System.out.println("실행 내용2");
	}

	@PrintAnnotation(value = "#", number = 20 )
//	"#", 20, "내 프린트다"
	public void method3() {
		System.out.println("실행 내용3");
	}
	
	@PrintAnnotation(value = "%", number = 2, myPrint = "마이프린트")
	public void method4() {
		System.out.println("실행 내용 4");
	}
}
