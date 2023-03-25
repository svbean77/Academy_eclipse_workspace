// day015 - 05 -  미니 프로젝트 (개인 프로젝트 MVC2 model 연습하기)
// day016 - 02 - 추가 기능
// 5. 프로그램 시작!
package aproject.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import aproject.model.EmpService;
import aproject.view.EmpView;
import aproject.vo.EmpVO;

public class EmpController {

	public static void main(String[] args) {
//		컨트롤러는 어떻게 짜는지에 따라 달라지는데 우리는 그냥 무한 while loop을 돌려보자
		Scanner sc = new Scanner(System.in);
		EmpService eService = new EmpService();

		while (true) {
			System.out.println("============================");
			System.out.println("1. 모든 직원 조회"); // day015
			System.out.println("2. 직원 상세 조회"); // day015
			System.out.println("3. 부서의 직원 조회"); // day015
			System.out.println("4. 부서, 직책, 급여로 조회"); // day015
			System.out.println("5. 부서의 평균 급여 이하의 급여를 받는 직원 조회"); // day016
			System.out.println("6. 신규 직원 등록"); // day016
			System.out.println("7. 직원 정보 수정"); // day016
			System.out.println("8. 직원 정보 삭제"); // day016
			System.out.println("9. 직원 급여 조회 (SP)"); // day017
			System.out.println("exit. 종료");
			System.out.print("작업 선택 >> ");

			String job = sc.next();
			if (job.equals("exit")) {
				break;
			}

			switch (job) {
			case "1": // day015
				EmpView.print(eService.selectAll());
				break;
			case "2": { // day015
				System.out.print("조회할 직원 번호 입력 >> ");
				int empid = sc.nextInt();
				EmpView.print(eService.selectById(empid));
				break;
			}
			case "3": { // day015
				System.out.print("조회할 부서 번호 입력 >> ");
				int deptid = sc.nextInt();
				EmpView.print(eService.selectByDept(deptid));
				break;
			}
			case "4": { // day015
//				같은 이름의 변수를 사용하고싶으니까 각 case를 블록으로 묶기
				System.out.print("조회할 부서 번호 입력 >> ");
				int deptid = sc.nextInt();
				System.out.print("조회할 직책 입력 >> ");
				String jobid = sc.next();
				System.out.print("조회할 급여 입력 >> ");
				double salary = sc.nextDouble();
				EmpView.print(eService.selectByCondition(deptid, jobid, salary));
				break;
			}
			case "5": { // day016
				List<EmpVO> empList = eService.selectLAB();
				System.out.println("[Controller] 5번 작업: " + empList.size());
				EmpView.print(eService.selectLAB());
				break;
			}
			case "6": { // day016
				EmpVO emp = makeEmp(sc);

				EmpView.print(eService.empInsert(emp));
				break;
			}
			case "7": { // day016
				System.out.print("수정할 직원의 번호 >> ");
				int empid = sc.nextInt();
//				수정 전 직원 정보 한 번 확인할래
				EmpView.print(eService.selectById(empid));
				EmpVO emp = makeEmp2(sc, empid);

				EmpView.print(eService.empUpdate(emp));
				break;
			}
			case "8": { // day016
				System.out.print("삭제할 직원의 번호 >> ");
				int empid = sc.nextInt();

				EmpView.print(eService.selectById(empid));
				System.out.print("삭제? (Y/N)>> ");
				String delete = sc.next();
				if (delete.equals("Y")) {
					EmpView.print(eService.empDelete(empid));
				}
				break;
			}
			case "9": { // day017
				System.out.print("조회할 직원 번호 입력 >> ");
				int empid = sc.nextInt();
				EmpVO emp = eService.getSalary(empid);
				EmpView.print("이름: " + emp.getFirst_name() + ", 급여: " + emp.getSalary());
				break;
			}

			default:
				break;
			}
		}
		System.out.println("수고하셨습니다...");
	}

//	day016: 신규 직원 등록 코드가 너무 길어서 함수로 빼봤어
	private static EmpVO makeEmp(Scanner sc) {
		System.out.print("신규 직원의 FIST NAME 입력 >> ");
		String firstName = sc.next();
		System.out.print("신규 직원의 LAST NAME 입력 >> ");
		String lastName = sc.next();
		System.out.print("신규 직원의 이메일 입력 >> ");
		String email = sc.next();
		System.out.print("신규 직원의 PHONE NUMBER 입력 >> ");
		String phone = sc.next();
//		날짜는 문자열 -> 날짜로 바꿔줘야 함
		System.out.print("신규 직원의 HIRE DATE 입력 (YYYY/MM/DD) >> ");
		String strDate = sc.next();
		Date hireDate = DateUtil.convertToDate(strDate);
		System.out.print("신규 직원의 JOB ID 입력 >> ");
		String jobid = sc.next();
		System.out.print("신규 직원의 SALARY 입력 >> ");
		double salary = sc.nextDouble();
		System.out.print("신규 직원의 COMMISSION 입력 >> ");
		double commission = sc.nextDouble();
		System.out.print("신규 직원의 MANAGER ID 입력 >> ");
		int manager = sc.nextInt();
		System.out.print("신규 직원의 DEPARTMENT ID 입력 >> ");
		int deptid = sc.nextInt();

		EmpVO emp = new EmpVO();
		emp.setFirst_name(firstName);
		emp.setLast_name(lastName);
		emp.setEmail(email);
		emp.setPhone_number(phone);
		emp.setHire_date(hireDate);
		emp.setJob_id(jobid);
		emp.setSalary(salary);
		emp.setCommission_pct(commission);
		emp.setManager_id(manager);
		emp.setDepartment_id(deptid);
		return emp;
	}

//	day016: 직원 정보 수정이 길어서 함수로 뺐어
//	framework를 사용하면 이 귀찮은 것들을 알아서 해줌! 그래서 프레임워크를 배우는거야
	private static EmpVO makeEmp2(Scanner sc, int empid) {
		System.out.print("수정할 직원의 이메일 입력 >> ");
		String email = sc.next();
		System.out.print("수정할 직원의 DEPARTMENT ID 입력 >> ");
		int deptid = sc.nextInt();
		System.out.print("수정할 직원의 JOB ID 입력 >> ");
		String jobid = sc.next();
		System.out.print("수정할 직원의 SALARY 입력 >> ");
		double salary = sc.nextDouble();
		System.out.print("수정할 직원의 입사일 입력 (yyyy/mm/dd) >> ");
		String sdate = sc.next();
		Date hiredate = DateUtil.convertToDate(sdate);
		System.out.print("수정할 직원의 관리자 번호 >> ");
		int manager = sc.nextInt();

		EmpVO emp = new EmpVO();
		emp.setEmployee_id(empid);
		emp.setEmail(email);
		emp.setJob_id(jobid);
		emp.setSalary(salary);
		emp.setDepartment_id(deptid);
		emp.setHire_date(hiredate);
		emp.setManager_id(manager);
		return emp;
	}
}
