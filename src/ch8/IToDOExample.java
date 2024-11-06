package ch8;

public class IToDOExample {

   public static void main(String[] args) {
      // 다중 인터페이스 및 다중 상속 예제... 
      ToDo toDo = new ToDo();
      IToDo3 iToDo3 = toDo;		// 다형성으로 구현체인 toDo 객체가 인터페이스 IToDo3에 타입변환함.
      iToDo3.m1();
      iToDo3.m2();
      iToDo3.m3();
//    iToDo3.m4(); 		// 동작 X 이유는 해당 인터페이스 객체에서 m4()를 추상메서드로 선언 X
      IToDo4 iToDo4 = toDo;
      iToDo4.m4();			// 동작 X 이유는 해당 인터페이스 객체에서 m4()를 추상메서드로 선언 O

   }

}

// 인터페이스 들... 
interface IToDo1 {
   //추상 메서드
   void m1();
}

interface IToDo2 {
   //추상 메서드
   void m2();
}

// 다중 상속 인터페이스 
// 두개를 상속받았으니 결과가 
/* 
 * {
 * void m1();
 * void m2();
 * void m3();
 * }
 * 
 * 위와 같이 되어있다.
 */
interface IToDo3 extends IToDo1, IToDo2 {
   // 추상 메서드
   void m3();
}

interface IToDo4 {
   // 추상 메서드
   void m4();
}

// 다중 인터페이스 구현체
class ToDo implements IToDo3, IToDo4 {
	
	// 불러와진 순서는 상관 없음 결과는 같음
	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("m2() 실행");
	}

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("m1() 실행");
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		System.out.println("m4() 실행");
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("m3() 실행");
	}
	
}
