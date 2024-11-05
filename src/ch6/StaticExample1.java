package ch6;

public class StaticExample1 {
	
	// 정적 맴버 변수(필드) 및 메서드 => static
	// 정적 멤버 변수 -> 전역변수(프로그램 전에 영향을 주는 변수) 설정과 비슷함.
	// 전역변수는 프로그램 시작과 동시에 선언되어서 사용되거나 혹은 중간에 선언되어도 프로그램 종료까지 사용됨.
	// 젼역변수와 반대되는 지역변수는 {}(블럭) 내에 선언되어지는 변수. 블럭을 벗어나면 사라짐.
	
	public static void main(String[] args) {
		// static 확인, Count 객체 생성
		Count c1 = new Count();		//인스턴스 객체
		c1.a++;		//a필드에 대한 내용을 불러와서 증가
		c1.b++;		//스테틱 불러와서 값 증가
		System.out.println("Non-static a : " + c1.a);
		System.out.println("Static b : " + c1.b);
		
		Count c2 = new Count(); 	//인스턴스
		c2.a++;
		c2.b++;
		System.out.println("Non-static a : " + c2.a);
		System.out.println("Static b : " + c2.b);
		
		//Count.a++;  인스턴스 필드이기 때문에 안나옴(a는 아래에 선언되어 있음)
		
		Count.b++;	// 클래스 멤버로 접근
		System.out.println("c1.a : " + c1.a);
		System.out.println("c2.a : " + c2.a);
		System.out.println("Count.b : " + Count.b);
		
		// static 메서드
		System.out.println("Count.doIt(): " + Count.doIt());
		System.out.println("Count.doIt(): " + Count.doIt());
		//왜 값이 증가하지 않고 출력이 1, 1 일까?  한줄 실행될 때마다 같은 곳을 참조하는 것이 아닌 새로운 객체를 하나씩 생성했기 때문에 1, 1임
		//위 두 객체는 서로 다른 객체임(주소 다름)
		//클래스 변수는 공통 변수(값을 공유하고 있음)
		
	}

}


class Count {
	
	// 멤버변수(필드)
	public int a = 0;			// 인스턴스 멤버변수
	public static int b = 0;	// 클래스 멤버변수(static 사용)
	
	// 메서드 doIt() - static 메서드 (static 메서드는 static 값을 사용해야 함 -> a값 참조 불가)
	public static int doIt() {
		//return ++a;		// Cannot make a static reference to the non-static field a
		return ++new Count().a;	// 인스턴스 생성 후 a멤버 변수 참조 인스턴스와 스테틱의 차이
		//return ++b;		// static을 이용한 클래스 멤버변수라 그냥 ++을 해서 리턴해도 문제 없음
	}
}