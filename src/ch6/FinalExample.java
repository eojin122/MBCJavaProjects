package ch6;

import ch6.obj.Person;

public class FinalExample {

	public static void main(String[] args) {
		// final 테스트
		Person hong = new Person("1111111-1111111", "홍길동");
		//nation, ssn => final로 설정되어 있음
		hong.name = "홍두께";
//		hong.nation = "울도국";	// 에러 : 변경 불가
//		hong.ssn = "000111";	// 에러 : 변경 불가
		
		System.out.println("[" + hong.name + ", " + hong.nation + ", " + hong.ssn + "]");
		
	}

}

class parson {
	//final 테스트를 위한 Person 클래스
	//final을 사용하면 변수를 상수화 처리를 하게 됩니다.
	
	
	//필드(멤버변수) -- final 초기화 방법 2가지
	final String nation = "한국";		// 1. 선언시 초기화
	final String ssn;	//final은 초기값이 반드시 필요함. 값을 고정하기 위함 
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;				// 2. 생성자를 이용한 초기화
		this.name = name;
	}
}
