// 교수님 풀이
package exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob1_1 {
	public static void main(String[] args) {
		String[] array = { "황남기ki85점", "조성호Ho89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
		printMaxScore2(array);
	}

	private static void printMaxScore(String[] array) {
		// 구현하세요.

		int maxScore = -1;
		String maxName = "";

		for (String str : array) {
//			System.out.println(str);
			char[] charArr = str.toCharArray();
			String name = "";
			String score = "";
			for (int i = 0; i < charArr.length - 1; i++) { // 마지막 '점'을 빼기 위해 길이-1만큼
				if (Character.isDigit(charArr[i])) {
					score += charArr[i];
				} else {
					name += charArr[i];
				}
			}

			int s = Integer.parseInt(score);
			if (s > maxScore) {
				maxScore = s;
				maxName = name;
			}
//			System.out.println(name + " --- " + score);
		}
		System.out.println("최고 점수는 " + maxName + " 님 " + maxScore + "점");

	}

//	정규표현식으로 풀어보기!
	private static void printMaxScore2(String[] array) {
		// 구현하세요.
		int maxScore = -1;
		String maxName = "";

		for (String str : array) {
			String regExp = "([가-힣A-Za-z]+)([0-9]+)점"; // 이 형식에서 추출하고싶은 것이기 때문에 그룹을 묶어줌
			Pattern pat = Pattern.compile(regExp);
			Matcher mat = pat.matcher(str);
			if (mat.find()) {
				String name = mat.group(1); // 그룹은 1번부터 시작
				int score = Integer.parseInt(mat.group(2));
//				System.out.println(name + " " + score);
				if (score > maxScore) {
					maxScore = score;
					maxName = name;
				}
			}
		}
		System.out.println("최고 점수는 " + maxName + " 님 " + maxScore + "점");
	}
}
