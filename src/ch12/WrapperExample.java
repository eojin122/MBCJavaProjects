package ch12;

/*
 * 포자 객체(Wrapper Class)
 * 	기본타입의 값을 갖는 객체를 의미함. (Byte, Cheracter, Short, Integer, Long, Float, Double, Boolean)
 * 	포장(Boxing)하고 있는 기본 타입의 값을 변경할 수 없고, 단지 객체로 생성하기 위해서 사용
 * 	- boxing : 기본 타입 값을 포장개체로 만드는 과정 포장 클래스에 기본 값 대입시 발생
 * 	- unboxing : 포장 객체에서 기본 타입 값을 얻어내는 과정. 기본 타입 변수에 포장 객체가 대입시 발생
 */

public class WrapperExample {

	public static void main(String[] args) {
		// boxing
		Integer obj = 100;		// Integer obj = new Integer(100); deprecate 됨
//		System.out.println("value : " + obj + 100);		// unboxing이 일어났음
		System.out.println("value : " + obj.intValue() + 100);	// 정수 값으로 처리됨
		
		// unboxing 
		int value = obj;
		System.out.println("value : " + value);
		
		// 연산시 자동으로 unboxing
		int result = obj + 100;
		System.out.println("result : " + result);
		
//		Integer test = 100;
//		test.	// Wrapper Class(Integer 등)로 선언시 객체로 생성되기 대문에 참조연산자 사용 가능
		// 문자열 값을 int값으로 변환
		int test = Integer.parseInt("1000");
		System.out.println(test);
		
		// 값 비교
		// -128~127(1byte)의 범위를 넘는 값인 경우
		Integer obj1 = 300;
		Integer obj2 = 300;		// 오버라이드 된 거라 생각하면 됨
		System.out.println("== : " + (obj1 == obj2));	// 출력하면 == : false 왜? 객체이기 때문
		System.out.println("equals :" + (obj1.equals(obj2)));
		// -128~127(1byte)의 범위 내의 값인 경우
		Integer obj3 = 30;
		Integer obj4 = 30;		// 오버라이드 된 거라 생각하면 됨
		System.out.println("== : " + (obj3 == obj4));	// 같다고 나옴
		System.out.println("equals :" + (obj3.equals(obj4)));
		// 객체를 비교할 땐 무조건 equals()를 이용하는 것이 안정적임
	}

}
