// day015 - 05 -  미니 프로젝트 (개인 프로젝트 MVC2 model 연습하기)
// day016 - 02 - 추가 기능
// 3. Service: db를 제외한 업무 로직 담당
package aproject.model;

import java.util.List;

import aproject.vo.EmpVO;

public class EmpService {
	EmpDAO empDao = new EmpDAO();

//	DAO와 함수 선언을 똑같이 하는 것이 좋음 (달라도 상관은 없지만)
//	day017
	public EmpVO getSalary(int empid) {
		return empDao.getSalary(empid);
	}

//	day015
	public List<EmpVO> selectAll() {
		// 보안코드, 조작이 필요한 코드가 있다면 return문 앞에 작성
		return empDao.selectAll();
	}

//	day015
	public EmpVO selectById(int empid) {
		return empDao.selectById(empid);
	}

//	day015
	public List<EmpVO> selectByDept(int deptid) {
		return empDao.selectByDept(deptid);
	}

//	day015
	public List<EmpVO> selectByCondition(int deptid, String jobid, double salary) {
		return empDao.selectByCondition(deptid, jobid, salary);
	}

//	day016
	public List<EmpVO> selectLAB() {
		List<EmpVO> emplist = empDao.selectLAB();
		System.out.println("[EmpService] 실행 건수: " + emplist.size());
		return emplist;
	}

//	day016
	public String empInsert(EmpVO emp) {
		int result = empDao.empInsert(emp);
		return result > 0 ? "입력 성공" : "입력 실패";
	}

//	day016
	public String empUpdate(EmpVO emp) {
		int result = empDao.empUpdate(emp);
		return result > 0 ? "수정 성공" : "수정 실패";
	}

//	day016
	public String empDelete(int empid) {
		int result = empDao.empDelete(empid);
		return result > 0 ? "삭제 성공" : "삭제 실패";
	}
}
