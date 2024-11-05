package ch6;

public class StaticExample2 {
	//정적블럭(초기화) 사전에 어떤 작업들을 정의하고 그 값을 가지고 작업을 할 때 사용
	/*
	 * 정적 블록 (static initializar)
	 * 	-> 정적 필드(멤버변수)를 선언할 때 복잡한 초기화 작업이 필요하다면 정적 블럭을 이용함
	 * 
	 * syntax>
	 * static {
	 * 	  ...
	 * }
	 * 
	 * 	- 생성자가 실행되기 전에 실행됨.
	 *  - static 변수 초기화에 사용된다.
	 *  - 객체를 여러개 생성해도 한 번만 실행(생성자와 다름) - 생성자와 관계가 없다.
	 *  - 정적 블럭을 클래스에서 여러개 선언되어 있다면, 선언된 순서대로 실행.
	 */

	public static void main(String[] args) {
		// StaticBlock 테스트 진행 (생성자보다 먼저 실행되며, 한 번만 실행됨)
		System.out.println(StaticBlock.a);
		System.out.println(StaticBlock.b);
		
		// static 블럭의 실행 확인 (생성자 호출 이후에 실행, 객체 생성(new)을 통해 접근해야 다시 활용 가능)
		StaticBlock s1 = new StaticBlock();
		System.out.println(s1);
		System.out.println(++StaticBlock.a);
		System.out.println(++StaticBlock.b);
		
		StaticBlock s2 = new StaticBlock();
		System.out.println(s2);
		System.out.println(++StaticBlock.a);
		System.out.println(++StaticBlock.b);
	
	}

}


class StaticBlock {
	static int a;	// 클래스 멤버변수(static 멤버변수)
	static int b;
	
	// 정적 블럭 사용
	static {
		a = 10;
		System.out.println("static block으로 static변수(a)를 초기화");
	}
	
	static {
			b = a + 10;
			System.out.println("static block으로 static변수(b)를 초기화");
	}
	
	//생성자
	public StaticBlock() {
		System.out.println("생성자가 호출되었습니다.");
	}

}