// day016 02 - 날짜 변환하는거 많이 사용할 것 같으니 유틸로 생성
package aproject.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

	public static Date convertToDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // M: 월, m: 분
		Date sqlDate = null;
		try {
			java.util.Date d = sdf.parse(strDate); // util의 date를 만들고싶다면 여기까지
			sqlDate = new Date(d.getTime()); // sql의 date를 만들고싶다면 이거를 해야 함
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

}
