// 03 - 컬렉션 (TreeSet)
// 04
// f1: TreeSet<String>
// f2: TreeSet<Object>
// f3: TreeSet<Object>
// f4: TreeSet
// f5: TreeMap p.679
// f6: Board p.642
// f7: Fruit p.674
// f8: Fruit to HashMap
// f9: Stack
// f10: Queue
// f11: 수정 불가능한 컬렉션 - List
// f12: 같음 - Set
// f13: 같음 - Map
// f14: 같음 - copyOf
// f15: 같음 - 배열을 List로
package com.shinhan.day10;

import java.util.*;
import java.util.Map.Entry;

// List: 순서 있음, 중복 가능 (ArrayList, Vector(멀티스레드 환경에서 동기화됨: 안정적), LinkedList)
// Set: 순서 없음, 중복 불가
// Map: 키와 값의 쌍
// HashSet: hashCode(), equals()로 동등비교, 동등하면 add 불가
// TreeSet: compareTo()로 크기 비교
public class CollectionTest2 {

	public static void main(String[] args) {
//		f1();
//		f2(); // 이거 다시 보자. 모두 '홍씨'로 하거나 '홍'으로 하면 중복 제거가 되지 않는다.. 코드 다시 확인
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
//		f13();
//		f14();
		f15();
	}

	private static void f15() {
//		수정 불가능 - 배열을 리스트로
		String[] arr = { "A", "B", "C" };
		List<String> data = Arrays.asList(arr);
//		data.add("F");
		for (String str : data) {
			System.out.println(str);
		}
	}

	private static void f14() {
//		수정 불가능 - copyOf
		Set<Fruit> data = new HashSet<>();
		data.add(new Fruit("귤1", 100));
		data.add(new Fruit("귤2", 100));
		data.add(new Fruit("귤3", 100));
		data.add(new Fruit("귤4", 100));
		data.add(new Fruit("귤5", 100));

		Set<Fruit> data2 = Set.copyOf(data);
//		data2.add(new Fruit("오렌지", 1000));
		for (Fruit fruit : data2) {
			System.out.println(fruit);
		}
	}

	private static void f13() {
//		수정 불가능한 map
		Map<String, Integer> data = Map.of("김", 100, "이", 90, "박", 80);
		for (String key : data.keySet()) {
			System.out.println(key + " --- " + data.get(key));
		}
//		data.put("양", 20);
	}

	private static void f12() {
//		수정이 불가능한 컬렉션 - Set
		Set<Integer> setData = Set.of(100, 88, 99, 55, 80); // 여기 중복값을 줄 수 없음 (에러 발생)
//		setData.add(100);
		for (Integer a : setData) {
			System.out.println(a);
		}
	}

	private static void f11() {
//		수정 불가능한 컬렉션 - List
		int[] arr = new int[] { 100, 88, 99, 55, 80 };
		List<Integer> listData = List.of(100, 88, 99, 55, 80);
//		List<int[]> listData2 = Arrays.asList(arr); // 이거는 배열로 받아버린다.. for문 찍으려면 for (int[] arr: listData2){Arrays.toString(arr))}
//		listData.add(345); // 수정이 불가능하기 때문에 에러 발생
		for (Integer a : listData) {
			System.out.println(a);
		}
	}

	private static void f10() {
//		Queue: 선입선출 (FIFO)
		Queue<Fruit> data = new LinkedList<>();
		data.offer(new Fruit("귤1", 20000));
		data.offer(new Fruit("귤2", 40000));
		data.offer(new Fruit("귤3", 10000));
		data.offer(new Fruit("귤4", 30000));
		data.offer(new Fruit("귤5", 70000));

		while (!data.isEmpty()) {
			System.out.println(data.poll());
		}
	}

	private static void f9() {
//		Stack: 후입선출 (LIFO)
		Stack<Fruit> data = new Stack<>();
		data.push(new Fruit("귤1", 20000));
		data.push(new Fruit("귤2", 40000));
		data.push(new Fruit("귤3", 10000));
		data.push(new Fruit("귤4", 30000));
		data.push(new Fruit("귤5", 70000));

		while (!data.isEmpty()) {
			System.out.println(data.pop());
		}
	}

	private static void f8() {
//		Map: HashMap, TreeMap

		TreeMap<String, Fruit> data = new TreeMap<>(new Comparator<String>() {
//			처음부터 내림차순으로 정렬하고 싶은 경우 Comparator 구현
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		data.put("A", new Fruit("사과", 1000));
		data.put("B", new Fruit("딸기", 4000));
		data.put("B", new Fruit("복숭아", 2000));
		data.put("C", new Fruit("복숭아", 4000));
		data.put("D", new Fruit("포도", 3000));

		for (Entry<String, Fruit> entry : data.entrySet()) {
			System.out.println(entry.getKey() + " ---- " + entry.getValue());
		}
		System.out.println();
		NavigableMap<String, Fruit> data2 = data.descendingMap();
		for (Entry<String, Fruit> entry : data2.entrySet()) {
			System.out.println(entry.getKey() + " ---- " + entry.getValue());
		}
	}

	private static void f7() {
		Set<Fruit> data = new TreeSet<>();
		data.add(new Fruit("사과", 1000));
		data.add(new Fruit("딸기", 4000));
		data.add(new Fruit("복숭아", 2000));
		data.add(new Fruit("복숭아", 4000));
		data.add(new Fruit("포도", 3000));
		data.add(new Fruit("포도", 2000));
		data.add(new Fruit("배", 3000));
		data.add(new Fruit("사과", 3500));
		data.add(new Fruit("사과", 3500));

		for (Fruit fruit : data) {
			System.out.println(fruit);
		}
	}

	private static void f6() {
		Set<Board642> data = new TreeSet<>();
		data.add(new Board642(1, "회식", "술마셔도되나요?", "jin"));
		data.add(new Board642(2, "자율학습", "저녁개방?", "jin"));
		data.add(new Board642(3, "아침", "빨리와~?", "jin"));
		data.add(new Board642(4, "회식", "술마셔도되나요?", "jin"));
		data.add(new Board642(5, "회식", "술마셔도되나요?", "jin"));

		for (Board642 board : data) {
			System.out.println(board);
		}
	}

	private static void f5() {
//		default: key로 정렬
		TreeMap<String, Integer> data = new TreeMap<>();
		data.put("홍길동5", 88);
		data.put("홍길동1", 99);
		data.put("홍길동4", 66);
		data.put("홍길동3", 77);
		data.put("홍길동3", 100); // key가 같음: key는 변하지 않음 (처음거 그대로), value는 덮어쓰기 (뒤의 값이 결과)

		for (String key : data.keySet()) {
			System.out.println(key + " --- " + data.get(key));
		}

		System.out.println(data.firstKey() + " --- " + data.get(data.firstKey()));
		System.out.println(data.lastEntry());
		System.out.println(data.lowerKey("홍길동3")); // key만 리턴
		System.out.println(data.lowerKey("홍길동4")); // lowerKey: 미만, lowerEntry: 이상

		NavigableMap<String, Integer> data2 = data.descendingMap();
		for (String key : data2.keySet()) {
			System.out.println(key + " --- " + data2.get(key));
		}
	}

	private static void f4() {
//		p. 670
		TreeSet<Integer> scoreSet = new TreeSet<>();
		scoreSet.add(100);
		scoreSet.add(20);
		scoreSet.add(50);
		scoreSet.add(80);
		scoreSet.add(80);

		for (Integer score : scoreSet) {
			System.out.println(score);
		}

		System.out.println("first: " + scoreSet.first());
		System.out.println("last: " + scoreSet.last());
		System.out.println("50 초과 (첫 번째): " + scoreSet.higher(50));
		System.out.println("50 미만 (첫 번째): " + scoreSet.lower(50));
		System.out.println("50 이상 (첫 번째): " + scoreSet.ceiling(50));
		System.out.println("50 이하 (첫 번째): " + scoreSet.floor(50));
		System.out.println("50 이상 (전부): " + scoreSet.tailSet(50));
		SortedSet<Integer> data = scoreSet.tailSet(50);
		for (Integer i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("50 이하 (전부): " + scoreSet.headSet(50));
		SortedSet<Integer> data2 = scoreSet.headSet(50, true); // false이거나 생략하면 미만, true이면 이하
		for (Integer i : data2) {
			System.out.print(i + " ");
		}

	}

	private static void f3() {
//		TreeSet
		Set<Employee> data = new TreeSet<>();
		data.add(new Employee("직원1", "사원", 1000));
		data.add(new Employee("직원1", "사원", 1000));
		data.add(new Employee("직원5", "사장", 10000));
		data.add(new Employee("직원7", "대리", 7000));
		data.add(new Employee("직원7", "주임", 7000));
		data.add(new Employee("직원2", "과장", 3000));
		data.add(new Employee("직원2", "과장", 8000));
		data.add(new Employee("직원2", "사장", 5000));

		for (Employee s : data) {
			System.out.println(s);
		}
	}

	private static void f2() {
//		TreeSet - 비교가 가능한 클래스를 사용해야 함 -> comparable 인터페이스를 구현

		Set<Account> data = new TreeSet<>();
		data.add(new Account("12345", "홍4", 1000));
		data.add(new Account("12343", "홍씨1", 1000));
		data.add(new Account("12342", "홍3", 13000));
		data.add(new Account("12347", "홍2", 122000));
		data.add(new Account("12345", "홍4", 8000)); // 이미 존재하기 때문에 add되지 않음 (덮어쓰기 X)

		for (Account s : data) {
			System.out.println(s);
		}
	}

	private static void f1() {
//		TreeSet

		Set<String> data = new TreeSet<>();
		data.add("월1");
		data.add("월5");
		data.add("월5"); // 중복key: add되지 않음 (key는 엎어쓰기가 아님!)
		data.add("월2");
		data.add("월4");

		for (String s : data) {
			System.out.println(s);
		}
	}

}
