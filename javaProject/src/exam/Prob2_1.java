// 교수님 풀이
package exam;

public class Prob2_1 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}

	public static String leftPad(String str, int size, char fillChar) {
		// 구현하시오.....return값 수정할것
		String result = "";
		try {
			if (str.length() > size) {
				throw new IllegalSizeException2("문자열의 길이보다 size가 큽니다.");
			}
		} catch (IllegalSizeException2 e) {
			System.out.println(e.getMessage());
		}
		
		for (int i = 0; i < size - str.length(); i++) {
			result += fillChar;
		}
		result += str;
		
		return result;
	}

}

//구현하시오.
class IllegalSizeException2 extends Exception {
	IllegalSizeException2(String message) {
		super(message);
	}
}
