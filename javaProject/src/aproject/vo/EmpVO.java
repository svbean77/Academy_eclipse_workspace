// day015 - 05 -  미니 프로젝트 (개인 프로젝트 MVC2 model 연습하기)
// day016 - 02 - 추가 기능 (추가된 내용 X, 그대로 사용하는 것)
// 1. VO부터 생성하자
package aproject.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// JavaBeans 기술 (3가지)
// 변수의 접근 지정자는 private으로 한다.
// -> getter, setter로 접근한다.
// 기본 생성자가 있어야 한다.
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter 
@ToString // 이건 우리 편하자고 넣은 내용
public class EmpVO {
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private double salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
}
