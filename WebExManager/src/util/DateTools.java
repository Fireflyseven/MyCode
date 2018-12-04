package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author 岳玉宸、刘霞
 * DateTools:获取时间工具类
 */
public class DateTools {
	
	public static String getDate() {
		Calendar c = Calendar.getInstance();  
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return s.format(c.getTime());
	}
	
	public static String getTimeString() {
		Calendar c = Calendar.getInstance();  
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMddHHmmss");
		return s.format(c.getTime());
		
	}
	 
	 
}
