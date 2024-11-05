package ch7;

import java.lang.reflect.Field;

import ch7.obj.Employee;
import ch7.obj.FinalClass;
import ch7.obj.Person;
import ch7.obj.Student;
import ch7.obj.Teacher;

public class InheritanceEx1 {
	
	// 상속 테스트틀 위한 클래스
	/*
	 *  상속(Inheritance)
	 *  - OOP에서 상속은 기존의 클래스를 확장하여 새로운 클래스를 이끌어 내는 것을 의미함.
	 *  - 기존 코드를 재사용함으로써 불필요한 코드를 재작성하지 않아도 됨.
	 *  - 클래스의 상속은 단일 상속만 가능함.
	 *	  단, 인터페이스는 다중 상속이 가능함
	 *	- 상속은 extends라는 키워드를 사용하여 상속을 표현함.
	 *	- 어떤 클래스가 다른 클래스로부터 상속을 받아 만들어지면 새롭게 만들어진 클래스를 자식 클래스(child or sub)라고 부르며, 
	 *	  멤버변수와 메서드를 물려준 클래스를 부모클래스(parent or super)라고 합니다.
	 *	- 상속을 하게 되면 부모 클래스의 멤버변수(필드)와 메서드를 자식 클래스에 상속하게 됩니다.
	 *	  하지만, 생성자는 상속되지 않습니다.(생성자는 따로 직접 정의를 해야한다.)
	 *	- 자바의 모든 클래스는 Object 클래스를 상속받고 있습니다. Object가 최상위 클래스
	 *	- final 클래스는 상속이 불가능.(final은 자식 클래스가 나올 수 없다)
	 *	- abstrect 클래스는 반드시 상속해서 처리해야 함.(abstract 클래스는 추상 클래스)
	 *
	 *	상속을 잘 사용한 경우와 그렇지 못한 경우
	 *	- 잘못 사요한 경우 : 개별 클래스들이 중복된 속성(멤버변수,필드)/기능(메서드)을 포함하게 된다.
	 *	- 잘 사용한 경우 : 중복된 기능은 빼고, 새로운 클래스를 작성한 후에 구체화
	 *		일반화된 클래스는 부모 클래스로, 구체화된 클래스를 자식 클래스로 사용
	 *
	 */
	
	public static void main(String[] args) {
		
		// Person 과 Student, Teacher, Employee 의 관계
		// 자식 객체 생성
		Employee emp = new Employee();
		Teacher te = new Teacher();
		Student st = new Student();
		Person test1 = new Person("테스터", 26);
		
		
		emp.name = "홍길동";
		emp.age = 18;
		emp.height = 180.8;		// 메서드를 정의하지 않아도 부모로부터 필드 값과 메서드를 가져옴 -> 상속
		emp.depertment = "교육부";
		System.out.println(emp.info());
		
		te.name = "이황";
		te.age = 47;
		te.subject = "프로그래밍";
		System.out.println(te.info());
		
		st.name = "이율곡";
		st.age = 15;
		st.studentId = "progrem001";
		System.out.println(st.info());
		
		
		Student s1 = new Student("이율곡", 15, "program001");
		System.out.println(s1.info());
		System.out.println(s1);		// Override한 결과 : [이름 : 이율곡, 나이 : 15, 학번 : program001]
		Teacher t1 = new Teacher("이황", 47);
		System.out.println(t1.info());
		System.out.println(t1);		// Override 안함 : ch7.obj.Teacher@270421f5 
									//									(@ 뒤의 숫자값이 해쉬 값)
		// 객체 비교를 위한 출력
		System.out.println("s1 - 이율곡, 15의 해쉬값 : " + s1.hashCode());
		Student s2 = new Student("이율곡", 10, "progrem001");
		System.out.println("s2 - 이율곡, 10의 해쉬값 : " + s2.hashCode());
		Student s3 = new Student("이율곡", 15, "progrem0001");	// 0을 추가하여 학번을 일부러 다르게 설정함
		s3.height = 180;
		System.out.println("s3 - 이율곡, 15의 해쉬값 : " + s3.hashCode());
		// s2와 s3의 해쉬 값이 같게 출력 된다.(각각 같은 값들을 가지고 있기 때문에) 그렇다면 이 둘을 동등 비교 시 같을까? 다를까?
		System.out.println("s2과 s3의 비교 결과 : " + (s1 == s3));		// 해쉬코드 비교
		// s2과 s3은 같은 값을 가지고 있어도 서로 다른 공간에 각각 존재하고 있으므로 주소가 다름. 따라서 동등 비교 시 서로 다르다. "s2과 s3의 비교 결과 : false"
		// 문자와 객체를 비교할 때 이퀄즈 사용. 
		
		//재정의한 equals를 통해서 비교
		System.out.println("s2과 s3의 비교 결과 : " + s1.equals(s3));	// 이름과 나이가 같다면 같다고 출력. 
		//비교연산에 학번이 다르므로 비교 대상의 학번이 달라도 같다고 출력. "s2과 s3의 비교 결과 : true"
		
		System.out.println(s1.getClass());				// "class ch7.obj.Student"
		System.out.println(s2.getClass());				// "class ch7.obj.Student"
		System.out.println(new Person().getClass());	// "class ch7.obj.Person"
		
		
		//final 메서드 확인
		FinalClass finaltest = new FinalClass();
		finaltest.method();  // 오버라이드는 안되지만, 부모에게 상속받은 메서드는 사용은 가능함
		
	}

}
