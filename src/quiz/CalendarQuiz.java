package quiz;

import java.text.SimpleDateFormat; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.Locale;

public class CalendarQuiz {
	
	// 년, 월, 일을 입력받고 해당 날짜가 무슨 요일인지 출력하는 프로그램 작성
	// 년, 월, 일이 주어졌다 가정하고 만들기

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String name = scanner.nextInt();
//		
//		scanner.close();
		
		
//		//나의 답안
//		Calendar cal = Calendar.getInstance();
//		
//		int year = cal.get(Calendar.YEAR);
//		int month = cal.get(Calendar.MONTH) + 1;	// 시작 월의 값이 0부터 시작이므로 + 1
//		int date = cal.get(Calendar.DATE);
////		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//	
//		// SimpleDateFormat을 사용하여 요일을 한글로 포맷합니다. 
//		SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.KOREAN); 
//		String dayOfWeek = sdf.format(date);
//		
//		System.out.printf("%d년 %d월 %d일 %s\n",
//				year, month, date, dayOfWeek);
//		
		
		int year = 2024;
		int month = 11;
		int date = 12;
		
		String dayOfWeek = getDayOfWeek(year, month, date);
		System.out.println(dayOfWeek);
		
		
	}
	
	static String getDayOfWeek(int year, int month, int date) {
		// 선생님 답안
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, date);
		
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			return "월요일";
		case Calendar.TUESDAY:
			return "화요일";
		case Calendar.WEDNESDAY:
			return "수요일";
		case Calendar.THURSDAY:
			return "목요일";
		case Calendar.FRIDAY:
			return "금요일";
		case Calendar.SATURDAY:
			return "토요일";
		default:
			return "일요일";
		}
		

	}

}
