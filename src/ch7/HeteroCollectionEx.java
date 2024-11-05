package ch7;

import ch7.obj.Employee;
import ch7.obj.Person;
import ch7.obj.Student;
import ch7.obj.Teacher;

/*
 *  이종모음(Heterogeneous Collection)
 *  - 이종모음은 배열에 다형성을 적용시키는 원리.
 *  - 예로 int[] iarr = new int[10]; 이런 구조의 배열을 만들어 둔다면,
 *    int형 데이터만을 저장할 수 있음.
 *  - 하지만, 다형성을 적용하면 이종 모음 구조를 가진 객체 배열을 생성할 수 있음
 */

// 다형성을 활용할 때 문제는 다시 자식 형태로 객체 타입으로 돌아가야 참조가 가능함
// 이때 오브젝트를 사용하게 되면 모든 클래스를 포함하고 있기 때문에 형 안정성에 문제가 발생한다.(데이터 타입을 구분할 수 있는 방법이 없어짐)

public class HeteroCollectionEx {

	public static void main(String[] args) {
		// Person을 객체로 하는 4개자리 배열을 선언
		Person[] pArr = new Person[4];
		
		// 배열에 각 요소에 값을 대입
		pArr[0] = new Person("홍길동", 180);
		pArr[1] = new Student("이율곡", 15, "24110502");
		pArr[2] = new Teacher("이황", 47, "자바프로그래밍");
		pArr[3] = new Employee("신사임당", 35, "교무처");
		
		for (int i = 0 ; i < pArr.length ; i++) {
			System.out.println(pArr[i].info());
		}
		
		// Object 배열
		Object[] objArr = new Object[5];
		objArr[0] = new Person("홍길동", 180);
		objArr[1] = new Student("이율곡", 15, "24110502");
		objArr[2] = new Integer(100);		// 줄은 곧 사라질 거라는 뜻 objArr[2] = 100; 과 같은 의미이므로 그냥 이렇게 써도 됨
		objArr[3] = new String("신사임당");
		objArr[4] = new java.util.Date();
		
		for (int i = 0 ; i < objArr.length ; i++) {
			System.out.println(objArr[i]);
		}

 	}

}
