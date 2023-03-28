package 常用类;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 日期类 {

	@Test
	@DisplayName("获取昨天的当前时刻")
	void 获取昨天的当前时刻() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime());
		// 格式化
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(cal.getTime());
		System.out.println("date = " + date);
	}
}
