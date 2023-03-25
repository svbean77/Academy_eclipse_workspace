// 06 - p.727
// 07 - f1(), f(), f11(), f12
package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
//@ToString
public class Student implements Comparable<Student> {
	private String name;
	private int score;

//	기본 방법을 사용하면 고정 문자열을 새로 만들어 리턴하는 것 -> StringBuilder가 더 좋다
//	따라서 가변인 StringBuilder가 조금 더 좋아
//	근데 계속 append 하는 것도 안좋아 -> chain 방식이 더 좋다
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student 정보: [name=").append(name).append(", score=").append(score).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student st) {
		int result = score - st.score;
		if (result == 0)
			return st.name.compareTo(name);
		return result;
	}

}
