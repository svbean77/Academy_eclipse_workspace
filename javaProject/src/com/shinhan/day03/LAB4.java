// 01
package com.shinhan.day03;

// class: object를 만드는 틀 (붕어빵 틀, 설계도)
// object: class를 이용해 만든 독립된 개체 = instance(실체, 메모리에 만들어짐)
public class LAB4 {

	public static void main(String[] args) {
		// 1번
		System.out.println("** 문제 1번 **");
		System.out.println("-------------Sample 1 --------------");
		String str = myReplace("hello world", 'l', '*');
		System.out.println(str);
		System.out.println("-------------Sample 2 --------------");
		String str2 = myReplace("hello world", ' ', '-');
		System.out.println(str2);
		System.out.println("-------------Sample 3 --------------");
		String str3 = myReplace("hello world", 'a', '*');
		System.out.println(str3);

		// 2번
		System.out.println("\n** 문제 2번 **");
		LAB4 p = new LAB4(); // static이 있는 애는 static이 없는 애를 부를 수 없음 -> 자신의 객체를 생성
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스";
		// split으로 한 예제
		// String[] arr = addr.split(",");
		// for (String s : arr) {
		// System.out.println(s);
		// }

		// String[] addrArr = p.split(addr, ",");
		// System.out.println("배열 크기 : " + addrArr.length);
		// for (int i = 0; i < addrArr.length; i++) {
		// System.out.print(addrArr[i] + " ");
		// }

	}

	public String[] split(String addr, char seperator) {
		String[] newArr = new String[3];
		String str = "";
		int idx = 0;

		for (int i = 0; i < addr.length(); i++) {
			if (addr.charAt(i) == seperator) {
				// newArr[idx] = str;
				str = "";
				idx++;
			} else {
				str += addr.charAt(i);
			}
		}

		return newArr;
	}

	// 함수: 문장의 묶음
	// 함수의 목적: 반복 코드 없이 재사용 하기 위해 (모듈화)
	public static String myReplace(String str, char oldChar, char newChar) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == oldChar) {
				newStr += newChar;
			} else {
				newStr += str.charAt(i);
			}
		}

		// return str.replace(oldChar, newChar);
		return newStr;

	}

}
