package ch02.verify;

public class Example {

	public static void main(String[] args) {
		num5();
		num6();
		num7();
		num9();
		num10();
		num11();
	}

	private static void num11() {
		// 2장 확인문제 11번
		int v1 = 1;
		System.out.println("v1: " + v1);
		if(true) {
			int v2 = 2;
			if(true) {
				int v3 = 2;
				System.out.println("v1: " + v1);
				System.out.println("v2: " + v2);
				System.out.println("v3: " + v3);
			}
			System.out.println("v1: " + v1);
			System.out.println("v2: " + v2);
			// System.out.println("v3: " + v3);
		}
		System.out.println("v1: " + v1);
		// System.out.println("v2: " + v2);
	}

	private static void num10() {
		// 2장 확인문제 10
		String str = "5";
		
		byte var1 = Byte.parseByte(str);
		// int var2 = Int.parseInt(str);
		float var3 = Float.parseFloat(str);
		double var4 = Double.parseDouble(str);
	}

	private static void num9() {
		// 2장 확인문제 9번
		byte byteValue = 10;
		float floatValue = 2.5F;
		double doubleValue = 2.5;
		
		// byte result = byteValue + byteValue;
		int result = 5 + byteValue;
		float result2 = 5 + floatValue;
		double result3 = 5 + doubleValue;
	}

	private static void num7() {
		// 2장 확인문제 7번
		int var1 = 10;
		long var2 = 10000000000L;
		// char var3 = '';
		float var4 = 10;
		String var5 = "abc\ndef";
		String var6 = """
				abc
				def
				""";
	}

	private static void num6() {
		// 2장 확인문제 6번
		int intValue = 10;
		char charValue = 'A';
		double doubleValue = 5.7;
		String strValue = "A";
		
		double var = (double) intValue;
		byte var2 = (byte) intValue;
		int var3 = (int) doubleValue;
		// char var4 = (char) strValue;
	}

	private static void num5() {
		// 2장 확인문제 5번
		byte byteValue = 10;
		char charValue = 'A';
		
		int intValue = byteValue;
		int intValue2 = charValue;
		// short shortValue = charValue;
		double doubleValue = byteValue;
	}

}
