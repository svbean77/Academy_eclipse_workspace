// 03 - f5()
package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 제네릭 - 여러 개 사용
// 관례: 대문자 한 자리로 사용

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"kind"})
@Getter
@Setter
public class Product<T, M> {
	T kind;
	M model;

}
