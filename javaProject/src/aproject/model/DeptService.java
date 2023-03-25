// 06 내가 해보는 MVC2
package aproject.model;

import java.util.List;

import aproject.vo.DeptVO;

public class DeptService {
	DeptDAO deptDao = new DeptDAO();

	public List<DeptVO> selectAll() {
		return deptDao.selectAll();
	}

	public DeptVO selectById(int deptid) {
		return deptDao.selectById(deptid);
	}

	public DeptVO selectByCondition(String deptname, int managerid) {
		return deptDao.selectByCondition(deptname, managerid);
	}
}
