package ch13;

public class GenericExample5 {
	
	// 와일드카드 타입 파라미터 : ?
	// 제너릭 타입을 매개값이나 리턴 타입으로 사용할 때 범위에 있는 모든 타입으로 대체할 수 있는 타입 파라미터를 의미함

	public static void main(String[] args) {
		// 모든 사람이 신청 가능
//		Course.registerCourse1(new Applicant(10));	// 범위를 지정하지 않으면 Integer값도 받아서 'Integer이(가) Course1을 등록함'를 출력함
		// 아래 public static void registerCourse1(Applicant<? extends Person> applicant)에서 ?에 person을 상속해서 java.lang.ClassCastException오류
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		
//		Course.registerCourse2(new Applicant<Person>(new Person()));	//동작 안함
//		Course.registerCourse2(new Applicant<Worker>(new Worker()));
		Course.registerCourse2(new Applicant<Student>(new Student()));	// 여기서부터 학생 및 자식객체
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		
		Course.registerCourse3(new Applicant<Person>(new Person()));	// Applicant<? super Worker로 불러왔으므로 자식(Worker)과 부모(Person)만 포함
		Course.registerCourse3(new Applicant<Worker>(new Worker()));	// Person중에서 학생들의 범위는 포함하지 않으므로 워커를 제외한 일반인(백수 등)을 가져움
//		Course.registerCourse3(new Applicant<Student>(new Student()));	// 학생 제외이므로 동작 안함
//		Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
//		Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
	}

}

// 과정 - Course클래스 생성
class Course {	// 여기서 와일드 카드 사용
	// 모든 사람이면 등록 가능
	public static void registerCourse1(Applicant<? extends Person> applicant) {	// 모든 타입의 Applicant를 받아와서 applicant에 저장(오브젝트와 같은 이야기임)
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course1을 등록함");
	}
	
	// 학생만 등록 가능
	// <? extends Student> 의미는 Student 객체를 포함한 하위 객체들을 의미하게 됨
	public static void registerCourse2(Applicant<? extends Student> applicant) {	// 모든 타입의 Applicant를 받아와서 applicant에 저장(오브젝트와 같은 이야기임)
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course2을 등록함");
	}
	
	// (학생을 제외한) 직장인 및 일반인만 등록 가능
	// <? super Worker> 의미는 Worker 객체를 포함 부모 객체까지라는 의미
	// -> person을 쓰면 학생 포함, Worker만 하면 워커가 아닌 일반인 제외됨. 따라서 super(부모)를 사용(현재 자식을 포함한 부모까지 라는 의미)
	public static void registerCourse3(Applicant<? super Worker> applicant) {	// 모든 타입의 Applicant를 받아와서 applicant에 저장(오브젝트와 같은 이야기임)
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course3을 등록함");
	}
	
}


// 지원자 - Applicant 클래스 생성
class Applicant<T>	{
	// 필드
	public T kind;
	
	//생성자
	public Applicant(T kind) {
		this.kind = kind;
	}
}


// 대상에 대한 클래스 - 상속관계
class Person {}
class Worker extends Person{}	// Person의 자식
class Student extends Person{}	// Person의 자식
class HighStudent extends Student{}		// Student의 자식
class MiddleStudent extends Student{}	// Student의 자식














