// 04 - p.642
package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = { "subject", "writer" })
public class Board642 implements Comparable<Board642> {

	private int boardNo;
	private String subject;
	private String content;
	private String writer;

	@Override
	public int compareTo(Board642 board) {
//		subject -> writer -> boardNo (전부 다 오름차순으로 정렬)
		int result1 = subject.compareTo(board.subject); // ascending
		int result2 = writer.compareTo(board.writer);
		if (result1 == 0) {
			if (result2 == 0)
				return boardNo - board.boardNo;
			return result2;
		}

		return result1;
	}

}
