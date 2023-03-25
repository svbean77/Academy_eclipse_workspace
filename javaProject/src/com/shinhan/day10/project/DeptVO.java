// 05? - 마지막시간 - 실제 로직대로 프로젝트를 해보자! (데이터가 있다고 가정)
package com.shinhan.day10.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter // 옆에 써도 됨^^
@ToString
public class DeptVO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
}
