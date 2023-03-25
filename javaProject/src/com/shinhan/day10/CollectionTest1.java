// 02 - 컬렉션
// f1: 제네릭이 없는 ArrayList
// f2: 제네릭이 있는 ArraList
// f3: 멀티스레드 ArrayList
// f4: 멀티스레드 Vector
// f5: 멀티스레드 LinkedList
// f6: List3개의 시간 비교
// f7: HashSet<String>
// f8: HaseSet<Object>
// f9: HashMap<String, Integer>
// f10: HashMap<Object, Object>
// f11: Hashtable
// f12: properties
package com.shinhan.day10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*; // 하나씩 import하기 귀찮으면 * 사용
import java.util.Map.Entry;

public class CollectionTest1 {

	public static void main(String[] args) throws IOException {
//		f1();
//		f2();
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
	}

	private static void f12() throws IOException {
//		oracleInfo.properties 파일 사용 (내가 생성)
		Properties pro = new Properties();
//		pro.load(CollectionTest1.class.getResourceAsStream("oracleInfo.properties")); // 이 경로(bin)의 파일을 메모리에 로드 // 한 바이트씩 읽음
//		FileInputStream: 이 파일을 읽어라(개발환경 경로 -> 바람직한 방법은 아님)
//		FileInputStream fis = new FileInputStream("src/com/shinhan/day10/oracleInfo.properties"); 
//		pro.load(fis);
//		InputStream: 실행 환경(bin) 경로 -> 얘가 더 좋은 방법이야!
		InputStream is = CollectionTest1.class.getResourceAsStream("oracleInfo.properties");
		pro.load(is);
//		key의 이름을 알고 적을 때 하나씩 들고올 수 있음
		String driver = pro.getProperty("driver");
		System.out.println("driver: " + driver);

//		근데 key가 너무 많고 이름을 모르면?
		for (Object key : pro.keySet()) { // keySet이기 때문에 순서는 없다!
			String value = pro.getProperty((String) key);
			System.out.println("key: " + key + ", value: " + value);
		}
	}

	private static void f11() {
//		Hashtable: 멀티 스레드 환경에서 안정적 (결과는 같아~)

		Map<Employee, Account> data = new Hashtable<>();

		data.put(new Employee("김씨", "대리", 1000), new Account("12345", "김씨", 2000));
		data.put(new Employee("김씨", "대리", 5000), new Account("00000", "김씨", 5000)); // value 덮어쓰기
//		key는 set이기 때문에 기본금은 1000임! (이름, 직급만 같으면 같은 객체이기 때문에 동등한 객체로 판단 + 추가하지 않음)
//		값은 동등한 key가 있다면 덮어쓰기
		data.put(new Employee("김씨1", "과장", 7000), new Account("12340", "김씨1", 2000));
		data.put(new Employee("김씨2", "부장", 8000), new Account("12349", "김씨2", 2000));
		data.put(new Employee("김씨3", "사장", 9000), new Account("12348", "김씨3", 2000));

//		가장 쉽게 가져오는 방법은 향상된 for 문! (keySet 사용)
		for (Employee emp : data.keySet()) {
			System.out.println("key: " + emp);
			System.out.println("value: " + data.get(emp));
			System.out.println();
		}

//		동등 비교가 이름, 직급이기 때문에 기본금은 얼마이든 앞의 두 개가 같다면 true임!
		System.out.println(
				"key 찾기 'new Employee(\"김씨\", \"대리\", 5000)': " + data.containsKey(new Employee("김씨", "대리", 5000)));
		System.out.println(
				"key 찾기 'new Employee(\"김씨\", \"대리\", 1000)': " + data.containsKey(new Employee("김씨", "대리", 1000)));

		System.out.println("value 찾기 'new Account(\"12345\", \"김씨\", 2000)': "
				+ data.containsValue(new Account("12345", "김씨", 2000)));
		System.out.println("value 찾기 'new Account(\"00000\", \"김씨\", 5000)': "
				+ data.containsValue(new Account("00000", "김씨", 5000)));
	}

	private static void f10() {
//		HashMap
		Map<Employee, Account> data = new HashMap<>();

		data.put(new Employee("김씨", "대리", 1000), new Account("12345", "김씨", 2000));
		data.put(new Employee("김씨", "대리", 5000), new Account("00000", "김씨", 5000)); // value 덮어쓰기
//		key는 set이기 때문에 기본금은 1000임! (이름, 직급만 같으면 같은 객체이기 때문에 동등한 객체로 판단 + 추가하지 않음)
//		값은 동등한 key가 있다면 덮어쓰기
		data.put(new Employee("김씨1", "과장", 7000), new Account("12340", "김씨1", 2000));
		data.put(new Employee("김씨2", "부장", 8000), new Account("12349", "김씨2", 2000));
		data.put(new Employee("김씨3", "사장", 9000), new Account("12348", "김씨3", 2000));

//		가장 쉽게 가져오는 방법은 향상된 for 문! (keySet 사용)
		for (Employee emp : data.keySet()) {
			System.out.println("key: " + emp);
			System.out.println("value: " + data.get(emp));
			System.out.println();
		}

//		동등 비교가 이름, 직급이기 때문에 기본금은 얼마이든 앞의 두 개가 같다면 true임!
		System.out.println(
				"key 찾기 'new Employee(\"김씨\", \"대리\", 5000)': " + data.containsKey(new Employee("김씨", "대리", 5000)));
		System.out.println(
				"key 찾기 'new Employee(\"김씨\", \"대리\", 1000)': " + data.containsKey(new Employee("김씨", "대리", 1000)));

		System.out.println("value 찾기 'new Account(\"12345\", \"김씨\", 2000)': "
				+ data.containsValue(new Account("12345", "김씨", 2000)));
		System.out.println("value 찾기 'new Account(\"00000\", \"김씨\", 5000)': "
				+ data.containsValue(new Account("00000", "김씨", 5000)));
	}

	private static void f9() {
//		HashMap

//		Map: 키와 값의 쌍(=entry)
//		key는 set (중복 불가)
//		구현 클래스: HashMap, Hashtable
		HashMap<String, Integer> data = new HashMap<>();

		data.put("김", 100);
		data.put("박", 90);
		data.put("정", 95);
		data.put("양", 50);
		data.put("김", 80); // key가 같지만 value가 다름 -> 덮어쓰기

		System.out.println("key가 중복되면 값을 덮어씀: " + data.get("김")); // 80

		int sum = 0;
//		순서가 없기 때문에 일반 for 불가능 (찍을 수는 있음, 인덱스가 불가능이라는 의미!)

//		향상 for 문 (entry 사용)
		for (Entry<String, Integer> entry : data.entrySet()) {
//			entry: 한 건, entrySet: 여러 건
			System.out.println(entry.getKey() + "의 점수는 " + entry.getValue());
			sum += entry.getValue();
		}
		System.out.println("총점: " + sum);

//		향상 for 문 (keyset 사용: 'key들'을 의미)
		sum = 0;
		for (String key : data.keySet()) {
			System.out.println(key + "의 점수는 " + data.get(key));
			sum += data.get(key);
		}
		System.out.println("총점: " + sum);

//		keySet iterator 사용
		Iterator<String> it = data.keySet().iterator();
		while (it.hasNext()) { // 다음 데이터가 있는지 확인
			String key = it.next(); // next를 한 번 하면 다음 데이터로 넘어가기 때문에 next를 저장해줘야 함!
			System.out.println(key + ": " + data.get(key));
		}

		System.out.println("존재하는 키인가? '김': " + data.containsKey("김"));
		System.out.println("존재하는 키인가? '하': " + data.containsKey("하"));
		System.out.println("존재하는 값인가? '90': " + data.containsValue(90));
		System.out.println("존재하는 값인가? '200': " + data.containsValue(200));

	}

	private static void f8() {
//		HashSet에 객체 삽입

		Set<Account> data = new HashSet<>();
		data.add(new Account("1234", "홍", 1000));
		data.add(new Account("1234", "홍", 1000)); // equals, hashCode가 같아야 동등객체! 하나라도 다르면 주소가 달라
		data.add(new Account("1235", "홍1", 1100));
		data.add(new Account("1236", "홍2", 1200));
		data.add(new Account("1237", "홍3", 1300));

//	향상 for 문
		for (Account acc : data) {
			System.out.println(acc);
		}

		System.out.println();

//	interator (내부 반복자)
		Iterator<Account> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

//		원하는 객체 찾기
		Account searchData = new Account("1235", "홍1", 1100); // 동등비교를 하는 것! (hashCode, equals가 동일)
		boolean result = data.contains(searchData);
		System.out.println(result ? "찾았다" : "없다");
	}

	private static void f7() {
//		HashSet, TreeSet
//		Set: interface, 2개: 구현 클래스
//		HashSet: 순서가 없고 중복 불가능
//		단, TreeSet은 순서가 있음 (tree가 순서가 존재)
		Set<String> data = new HashSet<>();
		data.add("월요일");
		data.add("화요일");
		data.add("토요일");
		data.add("토요일"); // String은 equals가 내용 비교로 재정의됨 -> 같은 객체로 판단
		data.add("일요일");

//		일반 for 문
//		set은 순서가 없기 때문에 일반 for문 사용 불가능!

//		향상 for 문
		for (String week : data) {
			System.out.println(week);
		}

		System.out.println();

//		interator (내부 반복자)
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	private static void f6() {
//		싱글스레드에서 거린 시간을 측정해보자
//		ArrayList는 중간에 Data를 삽입하거나 삭제시 앞으로 당기는 것 때문에 느리다!
//		ArrayList
		List<Account> data = new ArrayList<>();
		long start = System.nanoTime();

		for (int i = 1; i <= 100000; i++) {
			data.add(new Account(i + "", "김" + i, 100));
		}

		for (int i = 100; i < 200; i++) {
			data.remove(0);
		}

		for (int i = 100; i < 200; i++) {
			data.add(i, new Account(i + "", "이" + i, 100));
		}

		long end = System.nanoTime();
		DecimalFormat df = new DecimalFormat("###,###");
		System.out.println("ArrayList 소요시간: " + df.format(end - start) + "ns");

//		Vector
		List<Account> data2 = new Vector<>();
		long start2 = System.nanoTime();

		for (int i = 1; i <= 100000; i++) {
			data2.add(new Account(i + "", "김" + i, 100));
		}

		for (int i = 100; i < 200; i++) {
			data2.remove(0);
		}

		for (int i = 100; i < 200; i++) {
			data2.add(i, new Account(i + "", "이" + i, 100));
		}

		long end2 = System.nanoTime();
		System.out.println("Vector 소요시간: " + df.format(end2 - start2) + "ns");

//		LinkedList
		List<Account> data3 = new LinkedList<>();
		long start3 = System.nanoTime();

		for (int i = 1; i <= 100000; i++) {
			data3.add(new Account(i + "", "김" + i, 100));
		}

		for (int i = 100; i < 200; i++) {
			data3.remove(0);
		}

		for (int i = 100; i < 200; i++) {
			data3.add(i, new Account(i + "", "이" + i, 100));
		}

		long end3 = System.nanoTime();
		System.out.println("LinkedList 소요시간: " + df.format(end3 - start3) + "ns");
	}

	private static void f5() {
//		ArrayList, 'LinkedList', Vector 비교: p.646 예제
		List<Account> data = new LinkedList<>();
		long start = System.nanoTime(); // 얼마나 걸리는지 보려고
//		2000건을 add 하고자 한다! -> 스레드를 나눠서 하고싶다 (1~1000, 1001~2000)
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					data.add(new Account(i + "", "김" + i, 100));
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					data.add(new Account(i + "", "이" + i, 100));
				}
			}
		};
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(data.size() + "개의 데이터가 저장되었다"); // 2000개가 나오지 않음 -> Thread에 안정적이지 않다..

		for (int i = 0; i < 100; i++) { // 시간 차이는 별로 없다
			data.remove(0);
		}

		long end = System.nanoTime();
		DecimalFormat df = new DecimalFormat("###,###");
		System.out.println("소요시간: " + df.format(end - start) + "ns");
	}

	private static void f4() {
//		ArrayList, LinkedList, 'Vector' 비교: p.646 예제
		List<Account> data = new Vector<>();
		long start = System.nanoTime(); // 얼마나 걸리는지 보려고
//		2000건을 add 하고자 한다! -> 스레드를 나눠서 하고싶다 (1~1000, 1001~2000)
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					data.add(new Account(i + "", "김" + i, 100));
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					data.add(new Account(i + "", "이" + i, 100));
				}
			}
		};
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		Vertor는 멀티스레드에 안정적 -> 동기화된다!
		System.out.println(data.size() + "개의 데이터가 저장되었다"); // 2000개가 나옴! -> Thread에 안정적

		for (int i = 0; i < 100; i++) { // 시간 차이는 별로 없다
			data.remove(0);
		}

		long end = System.nanoTime();
		DecimalFormat df = new DecimalFormat("###,###");
		System.out.println("소요시간: " + df.format(end - start) + "ns");
	}

	private static void f3() {
//		'ArrayList', LinkedList, Vector 비교: p.646 예제
		List<Account> data = new ArrayList<>();
		long start = System.nanoTime(); // 얼마나 걸리는지 보려고
//		2000건을 add 하고자 한다! -> 스레드를 나눠서 하고싶다 (1~1000, 1001~2000)
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					data.add(new Account(i + "", "김" + i, 100));
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					data.add(new Account(i + "", "이" + i, 100));
				}
			}
		};
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(data.size() + "개의 데이터가 저장되었다"); // 2000개가 나오지 않음 -> Thread에 안정적이지 않다..

		for (int i = 0; i < 100; i++) { // 시간 차이는 별로 없다
			data.remove(0);
		}

		long end = System.nanoTime();
		DecimalFormat df = new DecimalFormat("###,###");
		System.out.println("소요시간: " + df.format(end - start) + "ns");
	}

	private static void f2() {
//		제네릭을 사용한 ArrayList

		List<String> data = new ArrayList<>();
		data.add("java1");
		data.add("java2");
		data.add("java3");
		data.add("java4");
		data.add("java5");

		System.out.println("개수: " + data.size());

//		일반 for문으로 리스트 값 출력
		for (int i = 0; i < data.size(); i++) {
			System.out.println(i + "번째 값: " + data.get(i));
		}
//		향상 for문으로 리스트 값 출력
		for (String str : data) {
			System.out.println(str);
		}
//		iterator 사용해 while 문으로 리스트 값 출력
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}

	private static void f1() {
//		제네릭을 사용하지 않은 ArrayList

//		List: ArrayList, Vector, LinkedList
//		List: 인터페이스, 세 개: 구현 클래스
//		제네릭을 사용하지 않는 것도 가능 -> 바람직하지 않은 방법!
		List data = new ArrayList();
		data.add(100);
		data.add("java");
		data.add(new Account("1235", "길동", 100));
		int a = (Integer) data.get(0); // 순서가 존재!
		String s = (String) data.get(1);
		Account acc = (Account) data.get(2);
	}

}
