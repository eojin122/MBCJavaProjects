package ch8;

public class SealedInterfaceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// A 할아버지, B 아빠, C 나 같은 관계임
// interfaceA
sealed interface interfaceA permits interfaceB {
	void methodA();
}

non-sealed interface interfaceB extends interfaceA{		// interfaceA 를 상속 (A와 B는 상속관계)
	void methodB();
}

interface interfaceC extends interfaceB {		// interfaceA 를 상속받을 수 없음 퍼밋이 어쩌구 햇음..
	void methodC();
}

// 구현체
class ImplClass implements interfaceC {

	@Override
	public void methodB() {
		System.out.println("methodB() 실행");
		
	}

	@Override
	public void methodA() {
		System.out.println("methodA() 실행");
		
	}

	@Override
	public void methodC() {
		System.out.println("methodC() 실행");
		
	}
	
}