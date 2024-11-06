package ch7;

public class SealedExample {

	public static void main(String[] args) {
		// 테스트 동작
		SealedPerson person = new SealedPerson();
		SealedEmployee employee = new SealedEmployee();
		SealedManager maneger = new SealedManager();
		Director director = new Director();
		
		person.work();
		employee.work();
		maneger.work();
		director.work();
		
	}

}


sealed class SealedPerson permits SealedEmployee, SealedManager {
	
	// 1. 필드(멤버변수)
	public String name;
	// 2. 생성자 (생략 -> 기본 생성자가 됨)
	
	// 3. 메서드
	public void work() {
		System.out.println("하는 일이 결정되지 않았습니다.");
	}
}

//무분별하게 상속을 제한 하기 위해 final, sealed, non-sealed 중 하나를 정하지 않으면 에러
// sealed 클래스를 상속 받는 경우 클래스는 final, sealed, non-sealed 중 하나를 선택
//  - final은 자식을 만들지 않겠다.
//  - sealed는 permits을 통해서 상속 받을 클래스를 지정하겠다.
//  - non-sealed는 상속에 제한을 두지 않겠다.
final class SealedEmployee extends SealedPerson {		// final 제한
	 @Override
	public void work() {
		System.out.println("공장에서 일합니다.");
		
	}
}

non-sealed class SealedManager extends SealedPerson {
	@Override
	public void work() {
		System.out.println("일하는 것을 관리합니다.");
	}
}

// 일반 상속 - non-sealed를 상속하는 경우
class Director extends SealedManager {
	@Override
	public void work() {
		System.out.println("제품 생산을 기획합니다.");
	}
}
	
	
	