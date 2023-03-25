// 06 내가 해보는 MVC2
package aproject.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DeptVO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
}
