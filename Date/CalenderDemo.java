import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
public class CalenderDemo {
	public static void main(String args[]) throws  ParseException
	{
		
		String Pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(Pattern);
		String sdate = "2017-1-20 23:59:59";
		Date date = sdf.parse(sdate);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(date);
		calendar.add(Calendar.MONTH,13);
		Date date2=calendar.getTime();
		System.out.println(date2);
		calendar.set(Calendar.MONTH,14);
		Date date3=calendar.getTime();
		System.out.println(date3);
		calendar.roll(Calendar.MONTH,12);;
		Date date4=calendar.getTime();
		System.out.println(date4);
	}
}