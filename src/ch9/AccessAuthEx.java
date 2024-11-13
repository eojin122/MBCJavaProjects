package ch9;

public class AccessAuthEx {

	public static void main(String[] args) {
		// AccessB 테스트
		// 객체 생성
//		AccessA accessA = new AccessA();
//		AccessA.AccessB accessB1 = accessA.new AccessB();	// 이 두 줄을 아래 한 줄로 작성 가능.
		AccessA.AccessB accessB2 = new AccessA().new AccessB();	// 객체를 생성하고 접근 가능
		accessB2.method();

		// AccessC 테스트
		AccessA.AccessC accessC = new AccessA.AccessC();	// 해당 내용으로 다이렉트로 접근 가능 (AccessC는 static으로 선언되지 않아서 생성해준 것)
		accessC.method();
		// 접근 방식 유의하면서 볼 것.
	}

}

class AccessA {
	// AccessA 인스턴스 필드와 메서드
	int field1;
	void method1() {}
	
	// 정적필드, 정적메서드
	static int field2;
	static void method2() {}
	
	// 인스턴스 멤버 클래스
	class AccessB {
		void method() {
			// AccessA 인스턴스 필드와 메서드 사용
			field1 = 10;
			method1();
			// AccessA의 정적 필드와 메서드 사용
			field2 = 10;
			method2();
		}
	}
	
	// 정적 멤버 클래스
	static class AccessC {
		void method() {
			// AccessA 인스턴스 필드와 메서드 사용
//			field1 = 10;	// 사용 X why? 정적이 아니기 때문에 아직 객체가 생성되지 않았다.
//			method1();		// 사용 X	 static은 non-static이 불러오거나 접근이 안됨.
			// AccessA의 정적 필드와 메서드 사용
			field2 = 10;	// 사용 O	
			method2();		// 사용 O
		}
	}
	
}