import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;

public class DateDemo2{
	public static void main(String[]  args) throws  ParseException
	{
		Date date1 = new Date();
		String Pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(Pattern);
		String sdate = "2017-1-20 23:59:59";
		Date date2 = sdf.parse(sdate);
		System.out.println(date1.after(date2));
	}
	
	
}
