package exam;

public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
	}

	private static void printMaxScore(String[] array) {
		// 구현하세요.
		int maxScore = Integer.MIN_VALUE;
		String maxName = null;

		for (String value : array) {
			String name = "";
			String score = "";

			for (int i = 0; i < value.length(); i++) {
				char c = value.charAt(i);
				if (Character.isDigit(c)) {
					score += c;
				} else {
					name += value.charAt(i);
				}
			}

			if (maxScore < Integer.parseInt(score)) {
				maxScore = Integer.parseInt(score);
				maxName = name.substring(0, name.length() - 1);
			}
		}

		System.out.println("최고점수는 " + maxName + "님 " + maxScore + "점 입니다.");
	}
}
