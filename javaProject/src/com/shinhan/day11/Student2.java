// 07 - f14()
package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student2 implements Comparable<Student2>{
	private String name;
	private int score;
	private String gender;

	@Override
	public int compareTo(Student2 st) {
		int result = score - st.score;
		if (result == 0)
			return st.name.compareTo(name);
		return result;
	}
}
