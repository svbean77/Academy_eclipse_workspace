// 02 - f3()
package com.shinhan.day07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@: 어노테이션: 컴파일러가 해석하는 주석
//@Getter
//@Setter
//@ToString

//위의 방식처럼 하나씩 쓰는게 귀찮아 -> 기본적인거는 Data로 만들어줌!
@Data // AllArgsConstructor를 생성해주지 않음
@AllArgsConstructor // 이걸 하면 NoArgs가 없음
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "maker" }) // 누구만 같으면 동등! (exclude: 누구만 빼고 같으면 동등!)
@RequiredArgsConstructor
public class Computer {
	@NonNull // null이면 안돼! (근데 다른 어노테이션이랑 쓰니까 되네.. 생성자들 지우면 에러 뜬다)
	private String model;
	
	private int price;
	private String maker;

}
