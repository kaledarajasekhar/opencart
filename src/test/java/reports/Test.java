package reports;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		String format = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		
		System.out.println(format);
	}
}
