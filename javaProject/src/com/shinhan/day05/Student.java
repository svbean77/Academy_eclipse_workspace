// 01 - f1()
package com.shinhan.day05;

public class Student {
	// 1. field (데이터 저장하기 위한 변수들): instance변수, static변수
	// public, protected, 생략, private: 접근권한 -> 하나는 무조건 적용됨
	// final, static: 활용방법 -> 여러 개 적용 가능
	// instance 변수
	private String stdId; // private: 같은 class 내에서만 접근 가능 (상속 받아도 사용 불가)
	public String name; // public: 모든 package에서 접근 가능
	String major; // 생략: 같은 package에서 접근 가능
	protected int score; // protected: 같은 package와 상속 받은 class에서 접근 가능
	final String schoolName = "신한금융대학교"; // final: 초기화가 1회 (선언시, 생성시)
	// 생성시 초기화하면 생성자마다 초기화해야 하기 때문에 선언시 하는 게 편함

	// class 변수
	public static final String NATION = "대한민국"; // static final: 상수, class변수, 초기화가 1회 (선언시)
	public static int count; // static: class변수

	// 2. 생성자
	// default 생성자: 컴파일 시 자동으로 .class 파일에 추가됨 (재정의하면 생성 안 됨)
	Student(String stdId, String name) {
		// 중복 코드를 없애기 위해 매개변수가 더 많은 생성자를 호출
		// super(); : 원래는 super가 존재하지만 다른 생성자를 호출했기 때문에 super 사라짐 (이때는 생략이 아닌 제거!)
		// 부모, 생성자가 2개일 수 없기 때문^^
		this(stdId, name, null, 0);
	}

	Student(String stdId, String name, String major) {
		this(stdId, name, major, 0);
	}

	public Student(String stdId, String name, String major, int score) {
		super(); // super가 누구냐 -> extends~~ (기본값은 extends Object), 코드 맨 처음에 불러야 함
		this.stdId = stdId;
		this.name = name;
		this.major = major;
		this.score = score;
		count++;
	}

	// 3. method (getter, setter)
	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public static String getNation() {
		return NATION;
	}

	@Override
	public String toString() {
		// 내가 가진 정보로 toString 재정의
		return "Student 정보: [stdId=" + stdId + ", name=" + name + ", major=" + major + ", score=" + score
				+ ", schoolName=" + schoolName + "]";
	}

}
