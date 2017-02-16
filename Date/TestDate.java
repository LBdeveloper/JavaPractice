import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;

public class TestDate{
public static void main(String[] args) throws  ParseException{
Date date = new Date();
System.out.println(date);
long timemillies = date.getTime();
String patern = "yyyy-MM-dd HH:mm:ss";
DateFormat df = new SimpleDateFormat(patern);
String formatedTime = df.format(date);
System.out.println(timemillies);
System.out.println(formatedTime);

String dateStr = "2017-1-1 14:11:02";
Date sdate = df.parse(dateStr);

System.out.println(sdate);
}

}
