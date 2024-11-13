package ch9;

// Local 클래스 : 클래스 내에 메서드에 생성되는 클래스를 의미함
public class LocalClassEX1 {

	public static void main(String[] args) {
		// LocalA1 객체 생성
		LocalA1 localA1 = new LocalA1();
		
		// LocalA1에 있는 메서드 호출
		localA1.useLocalB1();
		
		// LocalA2.method1 호출
		LocalA2 localA2 = new LocalA2();
		localA2.method1(10);

	}

}


// 구성
class LocalA {
	// 필드
	
	// 생성자
	public LocalA() {
		// 로컬 클래스 선언
		class LocalB {}
		// 로컬 객체 생성
		LocalB b = new LocalB();
	}
	
	// 메서드
	void method() {
		// 로컬 클래스 선언
		class LocalB {}
		// 로컬 객체 생성
		LocalB b = new LocalB();
	}
	
}


class LocalA1 {
	// 필드
	// 생성자
	// 메서드
	void useLocalB1() {		// 로컬 클래스는 메서드 내에서 선언되어 사용됨
		// 로컬 클래스
		class LocalB1 {
			// 필드
			int field1 = 1;
			static int field2 = 2;
			
			// 생성자
			LocalB1() {
				System.out.println("LocalB1 생성자 실행");
			}
			// 메서드
			void method1() {
				System.out.println("LocalB1 메서드1 실행");
			}
			
			static void method2() {
				System.out.println("LocalB1 메서드2 실행");
			}
		}
		
		LocalB1 localB1 = new LocalB1();
	    System.out.println(localB1.field1);
	    localB1.method1();
	    System.out.println(LocalB1.field2);
	    LocalB1.method2();
		
	}
}

class LocalA2 {
	public void method1(int arg) {		// **final int arg (값이 저장 전까지는 변수, 저장되고 나면 final)
		// 로컬 변수
		int var1 = 1;					// **final int var1 = 1;
										// 내가 final을 쓰지 않아도 JVL이 처리해줌, 하지만 **저렇게 코드를 만들어두면 확실해져서 좋음
		// 로컬 클래스
		class LocalB2 {
			// 메서드
			void method2() {
				// 로컬 변수 읽기
				System.out.println("arg : " + arg);		// 아래에서 말한 *위가 여기.
				System.out.println("var : " + var1);	// Local variable arg defined in an enclosing scope must be final or effectively final 
				
				// 로컬 변수 수정
//				arg = 2;  // Local variable arg defined in an enclosing scope must be final or effectively final
//				var = 2;  // 내부 클래스에서 사용되는 지역 변수는 변경되지 않도록 final 또는 사실상 변경되지 않는(effectively final) 상태여야 합니다.
			}
		}
		
		// 로컬 클래스 객체 생성
		LocalB2 localB2 = new LocalB2();
		// 로컬 클래스 객체 메서드 호출
		localB2.method2();
		
		// 변수 수정
//		arg = 3;		// 실행하고 나서 처리하면 처리가 됨. 클래스 선언이 아니었으면 원래 값을 넣을 수 있음. 대신 *위에 경고가 뜸
//		var1 = 3;		// 물론 얘도 안됨.
		// 정리하면 로컬 클래스로 들어가는 매개변수가 있다면 모두 final 처리를 해야한다.
	}
}

