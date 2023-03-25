// 01 - 리뷰
package com.shinhan.day11;

import java.util.*;
import java.util.Map.Entry;

public class Review {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
//		ArrayList, HashSet, HashMap

//		Collection - List (순서 O, 중복 O), Set (순서 X, 중복 X) (인터페이스)
//		Map(key, value의 쌍 = 엔트리. key=set, 따라서 중복되면 add되지 않음, value는 key가 중복이면 덮어쓰기) (인터페이스)
//		List - ArrayList, Vector, LinkedList (구현클래스)
//		Set - HashSet (hashCode, equals로 동등객체 판단), TreeSet (데이터 추가시 순서 정해짐 -> 크기를 비교할 수 있어야 함: compareTo() (구현클래스)
//		Map - HashMap, TreeMap, Properties (구현클래스)

		List<Integer> data1 = new ArrayList<>();
		Set<Integer> data2 = new HashSet<>();
		Map<String, Integer> data3 = new HashMap<>();

//		데이터 넣기
		data1.add(100);
		data2.add(200);
		data3.put("aa", 300);

//		데이터 가져오기
		System.out.println(data1.get(0)); // 리스트는 순서가 존재하기 때문에 n번째 가져오기!가 가능
		for (Integer num : data2) { // set의 방법1: 향상 for 문
			System.out.print(num + " ");
		}
		System.out.println();
		Iterator<Integer> it2 = data2.iterator(); // set의 방법2: iterator를 통해 내부 반복자를 생성
		while (it2.hasNext()) {
			System.out.print(it2.next() + " "); // 내부 반복자에서 가져와라
		}
		System.out.println();
		// Map은 키가 있으면 값을 읽을 수 있다!
		for (Entry<String, Integer> entry : data3.entrySet()) { // map의 방법1: entry를 이용해 향상 for문 사용
			System.out.println(entry.getKey() + " --- " + entry.getValue());
		}
		for (String key : data3.keySet()) { // map의 방법 2: keySet을 이용해 향상 for문 사용
			System.out.println(key + " --- " + data3.get(key));
		}
	}

}
