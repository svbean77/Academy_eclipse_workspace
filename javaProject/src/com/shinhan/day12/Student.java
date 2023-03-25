// 01 - Example
// 02 - f9()
package com.shinhan.day12;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString
public class Student implements Serializable{
//	private static final long serialVersionUID = 1L; // 있어도 되고 없어도 됨
	private String name;
	private int engScore;
	private int mathScore;
}
