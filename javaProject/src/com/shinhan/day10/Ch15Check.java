package com.shinhan.day10;

import java.util.*;

public class Ch15Check {

	public static void main(String[] args) {
		num1_num6();
		num7();
		num8();
		num9();
		num10();
		num11_num13();
	}

	private static void num11_num13() {
//		11번
//		4. Stack과 Queue는 자바에서 클래스 타입이다.
		
//		12번
//		3. Vector와 HashMap은 동기화된 컬렉션이다.
		
//		13번
//		4. Array.asList() 메소드는 배열로부터 수정할 수 있는 List 컬렉션을 생성한다.
	}

	private static void num10() {
//		10번
		TreeSet<Student10> treeSet = new TreeSet<Student10>();
		treeSet.add(new Student10("blue", 96));
		treeSet.add(new Student10("hong", 86));
		treeSet.add(new Student10("white", 92));

		Student10 student = treeSet.last();
		System.out.println("최고 점수: " + student.score);
		System.out.println("최고 점수를 받은 아이디: " + student.id);
	}

	private static void num9() {
//		9번
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);

		String name = null;
		int maxScore = 0;
		int totalScore = 0;

		for (String key : map.keySet()) {
			int score = map.get(key);
			totalScore += score;
			if (maxScore < score) {
				name = key;
				maxScore = map.get(key);
			}
		}

		System.out.println("평균 점수: " + (totalScore / map.size()));
		System.out.println("최고 점수: " + maxScore);
		System.out.println("최고 점수를 받은 아이디: " + name);
	}

	private static void num8() {
//		8번
		Set<Student> set = new HashSet<Student>();

		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));

		System.out.println("저장된 객체 수: " + set.size());
		for (Student s : set) {
			System.out.println(s.studentNum + ": " + s.name);
		}
	}

	private static void num7() {
//		7번
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for (Board board : list) {
			System.out.println(board.getTitle() + " - " + board.getContent());
		}
	}

	private static void num1_num6() {
//		1번
//		4. Stack은 FIFO (선입선출) 자료구조를 구현한 클래스이다.

//		2번
//		3. ArrayList에서 객체를 삭제하면 삭제된 위치는 비어 있게 된다.

//		3번
//		4. Set 컬렉션에는 null을 저장할 수 없다.

//		4번
//		3. 멀티 스레드 환경에서는 Hashtable보다는 HashMap이 스레드에 안전하다.

//		5번
		List<Board> board = new ArrayList<>();

//		6번
		Map<String, Integer> student = new HashMap<>();
	}

}

// 7번
class Board {
	private String title;
	private String content;

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
}

class BoardDao {
	public List<Board> getBoardList() {
		List<Board> boardList = new ArrayList<>();
		boardList.add(new Board("제목1", "내용1"));
		boardList.add(new Board("제목2", "내용2"));
		boardList.add(new Board("제목3", "내용3"));
		return boardList;
	}
}

// 8번
class Student {
	public int studentNum;
	public String name;

	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentNum == other.studentNum;
	}
}

// 10번
class Student10 implements Comparable<Student10> {
	public String id;
	public int score;

	public Student10(String id, int score) {
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(Student10 student) {
		return score - student.score;
	}

}