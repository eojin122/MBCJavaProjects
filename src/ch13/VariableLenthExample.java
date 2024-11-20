package ch13;

public class VariableLenthExample {

	public static void main(String[] args) {
		// 가변 인자
		log("Hello");
		log("VariableLengthExample", "Hello");
		log("a", "b", "c");
		log();
		
		
	}
	

	public static void log(String...msg) {		// 가변 인자 "..." 를 사용함
		// 가변인자는 일반인자(매개변수) 앞에 사용할 수 없다.
//		System.out.println(msg.length); 	// 값을 배열로 받아 값의 갯수에 따라 다르게 처리할 수 있음(??)
		System.out.println("로그 : ");
		for (String message: msg) {
			System.out.println(message + ",");
		}
		System.out.println();
	}

}
