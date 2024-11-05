package ch7;

import ch7.obj.Employee;
import ch7.obj.Person;
import ch7.obj.Student;
import ch7.obj.Teacher;

public class PolymorphismEx1 {

	public static void main(String[] args) {
		// 부모 객체는 자식 객체를 포함한다.(자식 객체끼리는 독립적, 부모 > 자식)
		Person p; // 부모 객체 변수를 선언
		
		// 자식 객체를 부모 객체에 넣어줌 -> promotion(자동형변환)
		// 자동 형변환이 일어나면,
		// 자식 객체는 부모 객체가 가지고 있는 것들에 대해서 접근 및 실행이 가능함.
		// 즉, 멤버변수(필드)와 메서드를 실행할 수 있음.
		// 메서드는 재정의 했다면, 재정의한 것으로 실행합니다.
		p = new Student("홍길동", 18, "2024110501");
		System.out.println(p.info());
		System.out.println(p.getClass());
		p = new Teacher("홍길동사부", 100, "도술");
		System.out.println(p.info());
		System.out.println(p.getClass());
		p = new Employee("홍길자", 100, "식사담당");
		System.out.println(p.info());
//		p.working();	// 부모 클래스인 Person에 working()가 없기 때문에 실행X
		System.out.println(p.getClass());
		
		Employee e1 = (Employee)p;	// casting을 통해서 형변환
		// 형변환이 없으면 타입 미스 매치 : 부모(p)는 자식(Employee)을 포함할 수 있지만 자식은 부모를 포함할 수 없으므로 형변환.
		System.out.println(e1.info());
		e1.working();	// Employee에 working이 있으므로 실행 가능 -> 부모 클래스에서 알고 있는 것만 사용할 수 있다. 모르는 건 사용 불가능.
		System.out.println(e1.getClass()); 
	}

}




