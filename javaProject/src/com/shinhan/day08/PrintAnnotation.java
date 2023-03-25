// 01
package com.shinhan.day08;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 대상(method, field, type)에 적용할 것이다! (target, 배열로 여러 개 작성 가능)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
// 실행할 때 적용할 것이다! (retention) (실행시 적용이기 때문에 계속 유지되어야 함)
@Retention(RetentionPolicy.RUNTIME)

// PrintAnnotation이라는 이름으로 어노테이션을 쓰겠다는 의미!
public @interface PrintAnnotation {
	String value() default "-"; // value값을 안 준다면 default "-"를 리턴하겠다.
	int number() default 7; // number값을 안 준다면 default 7을 리턴하겠다.
	
	String myPrint() default "내 프린트다"; // 이런 속성이 하나 있었으면 좋겠어!
	 
	
}
