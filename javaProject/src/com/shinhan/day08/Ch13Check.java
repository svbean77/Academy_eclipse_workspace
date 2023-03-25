package com.shinhan.day08;

public class Ch13Check {

	public static void main(String[] args) {
		num1();
		num2();
		num3();
		num4();
	}

	private static void num4() {
		// 13장 확인문제 4번
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println(age);

		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer childAge = Util.getValue2(childPair, "홍삼순");
		System.out.println(childAge);

//		Pair를 상속하지 않기 때문에 컴파일 에러 발생
//		OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
//		int otherAge = Util.getValue(otherPair, "홍삼원");
//		System.out.println(otherAge);
	}

	private static void num3() {
		// 13장 확인문제 3번
		Container2<String, String> container1 = new Container2<String, String>();
		container1.set("홍길동", "도적");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1 + ": " + job);

		Container2<String, Integer> container2 = new Container2<String, Integer>();
		container2.set("홍길동", 35);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println(name2 + ": " + age);

//		추가) generic 타입의 컨테이너를 함수에서 생성해 리턴하기!
		Container2<String, String> container3 = makeContainerNo3ver1("이름", "내용이야");
		Container2<String, Integer> container4 = makeContainerNo3ver2("이름2", 1234);
		System.out.println(container3.getKey() + ": " + container3.getValue());
		System.out.println(container4.getKey() + ": " + container4.getValue());
	}

	private static <K, V> Container2<K, V> makeContainerNo3ver1(K key, V value) {
		Container2 container = new Container2<K, V>();
		container.set(key, value);
		return container;
	}

	private static <K, V> Container2<K, V> makeContainerNo3ver2(K key, V value) {
		return new Container2<K, V>(key, value);
	}

	private static void num2() {
		// 13장 확인문제 2번
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		System.out.println(str);

		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println(value);

//		추가) generic 타입의 컨테이너를 함수에서 생성해 리턴하기!
		Container<String> container3 = makeContainerNo2("문자열 타입이당");
		System.out.println(container3.get());
		Container<Integer> container4 = makeContainerNo2(1234);
		System.out.println(container4.get());
	}

	private static <T> Container<T> makeContainerNo2(T data) {
		return new Container<T>(data);
	}

	private static void num1() {
		// 13장 확인문제 1번
//		1. 컴파일 시 강한 타입 체크를 할 수 있다. -> O
//		2. 타입 변환(casting)을 제거한다. -> O
//		3. 제네릭 타입은 타입 파라미터를 가지는 제네릭 클래스와 인터페이스를 말한다. -> O
//		4. 제네릭 메소드는 리턴 타입으로 타입 파라미터를 가질 수 없다. -> X
	}

}

// 13장 확인문제 4번
class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class ChildPair<K, V> extends Pair<K, V> {
	public ChildPair(K k, V v) {
		super(k, v);
	}
}

class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class Util {
//	부모 = 자식으로 자동 형변환이 가능하기 때문에 타입을 Pair로 쓰면 된다
	public static <K, V> V getValue(Pair<K, V> pair, K key) {
		if (pair.getKey().equals(key))
			return pair.getValue();
//		else가 없어도 됨! 어차피 if문에 false가 되면 내려오니까
//		else
		return null;

	}

//	다른 방법이 있을까? -> 상속받는 것을 generic임을 알려주는 타입에 extends를 써주면 돼!!!! (문제가 원하는 답은 이거)
	public static <P extends Pair<K, V>, K, V> V getValue2(P pair, K key) {
		if (pair.getKey().equals(key))
			return pair.getValue();
		return null;

	}
}

// 13장 확인문제 3번
class Container2<K, V> {
	K key;
	V value;

	Container2() {
	}

	Container2(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public void set(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

// 13장 확인문제 2번
class Container<T> {
	T value;

	Container() {
	}

	Container(T value) {
		this.value = value;
	}

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}
}
