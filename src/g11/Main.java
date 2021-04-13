package g11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String beginTime = scan.next();
		
		Calendar c = Calendar.getInstance();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date;
		
		try {
			date = df.parse(beginTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		c.setTime(date);
		// System.out.println(df.format(c.getTime()));

		
		boolean foundHuiWen = false;
		String huiWenString = null;
		boolean foundABABBABA = false;
		String ABABBABAString = null;
		for(int i=0; i<1000000; i++) {
			c.add(Calendar.DAY_OF_YEAR, 1);
			String dateStr = df.format(c.getTime());
			// System.out.println(dateStr);

			if(!foundHuiWen && isHuiWen(dateStr)) {
				foundHuiWen = true;
				huiWenString = dateStr;
			}
			if (!foundABABBABA && isABABBABA(dateStr)) {
				foundABABBABA = true;
				ABABBABAString = dateStr;
			}
			
			if(foundABABBABA && foundHuiWen) {
				System.out.println(huiWenString);
				System.out.println(ABABBABAString);
				break;
				
			}
		}
		

		
	}
	
	public static boolean isHuiWen(String str) {
		int a = str.length();
		if(a % 2 != 0) {
			 return false;
		}
		for(int i=0; i<a/2; i++) {
			// System.out.println(str + " " + str.charAt(i) + " " + str.charAt(a-1-i));
			if(str.charAt(i) != str.charAt(a-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isABABBABA(String str) {
		if(str.charAt(0) != str.charAt(2) || str.charAt(1) != str.charAt(3)) return false;
		
		if(! str.substring(0, 4).equals(new StringBuffer(str.substring(4, 8)).reverse().toString())) return false;
		
		return true;
	}
	

}
