package aproject.controller;

import java.util.Scanner;

import aproject.model.DeptService;
import aproject.view.DeptView;

public class DeptController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DeptService dService = new DeptService();

		while (true) {
			System.out.println("============================");
			System.out.println("1. 모든 부서 조회");
			System.out.println("2. 부서 아이디 조회");
			System.out.println("3. 부서 이름과 매니저");
			System.out.println("exit. 종료");
			System.out.print("작업 선택 >> ");

			String job = sc.next();
			if (job.equals("exit")) {
				break;
			}

			switch (job) {
			case "1":
				DeptView.print(dService.selectAll());
				break;
			case "2": {
				System.out.print("조회할 부서 번호 입력 >> ");
				int empid = sc.nextInt();
				DeptView.print(dService.selectById(empid));
				break;
			}
			case "3": {
				System.out.print("조회할 부서 이름 입력 >> ");
				String deptname = sc.next();
				System.out.print("조회할 매니저 번호 입력 >> ");
				int managerid = sc.nextInt();
				DeptView.print(dService.selectByCondition(deptname, managerid));
				break;
			}

			default:
				break;
			}
		}
		System.out.println("수고하셨습니다...");
	}

}
