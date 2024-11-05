package ch7.obj;

public final class FinalClass extends FinalTest {
	// final 클래스 : 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없음.
	 
	// 오버라이드(override)로 아래 public final void method() 메서드를 불러올 수 없다.(사용이 불가능 한 건 아님)
	// 부모의 final method()를 오버라이드(override) 할 수 없음.
}

//class FinalTest extends FinalClass {}		// 파이널클래스를 참조하고 있어서 현재의 클래스에서 자식 클래스를 만들 수 없다고 오류가 뜸.

class FinalTest {
	public final void method() {		// 부모 클래스가 될 수 없는 것이지 자식 클래스가 될 수 없는 건 아님.
		System.out.println("파이널 메서드 입니다.");
	}
}


