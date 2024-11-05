package ch7.obj;

//Person 클래스의 자식
public class Student extends Person {
	
	// 1. 필드(멤버변수)
	public String studentId; //학번
	
	
	// 2. 생성자
	public Student() {}
	
	public Student(String name, int age, String studentId) {
		super(name, age);
		this.studentId = studentId;
		/*
		 *  super는 현재 객체의 부모 객체, 바로 위의 부모 객체를 의미함.
		 *  super. 인 경우
		 *  - 부모의 변수 또는 메서드 참조
		 *  ex) super.name, super.info()
		 *  super() 인 경우
		 *  - 부모의 생성자를 참조
		 *  ex) super();  // 부모의 기본 생성자
		 *  	super(name, age);  // 부모 객체의 Person(name, age)참조
		 *  ## this(), super() 생략한 경우... 자동으로 super() 를 자동으로 처리함.
		 */
	}
	
	
	// 3. 메서드
	/*
	 *  메서드 재정의(Override)
	 *   부모 클래스로부터 상속받은 메서드를 자식 크래스에서 해위를 바꾸거나 보완하기 위해서 다시 정의해서 사용하는 것.
	 *   
	 *  - 재정의 규칙
	 *  	1. 상속을 전제로 한다.(상속을 안하면 그냥 만드는 거지 재정의 아님)
	 *  	2. 리턴타입, 메서드 이름, 파라미터(매개) 변수 설정이 일치해야 합니다.
	 *  	3. 접근 제한자는 같거나 more public 해야 한다.(한 단계 더 제한이 덜하거나 같은 걸로 해야 한다는 뜻)
	 */
	
	@Override
	public String info() {
		return "이름 : " + name + ", 나이 : " + age + ", 학번 : " + studentId;
	}
	
	@Override
	public int hashCode() {
		//"test".equals(studentId);
		
		// 객체 동등비교를 위해서 사용하는 메서드, 재정의 (텍스트를 받아 숫자 값을 반환)
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());		// 학번이 있으면 학번(문자열) 해쉬 값(숫자)을 만들어서 넘겨줘라
		result = prime * result + ((name == null) ? 0 : name.hashCode());				// 해쉬 코드는 숫자 값을 반환한다.(값의 의미가 같은지 확인 하는 코드(단방향 함수)
		return result;																	// 문자열, 공백 하나라도 다르면 다른 값을 반환
	}
	
	@Override
	public boolean equals(Object obj) {		// Object 모든 클래스 최상위에 있는 클래스, 이걸 사용하면 모든 타입을 받을 수 있음
		// 객체 동등비교를 위해 사용하는 메서드, 재정의 (텍스트를 받아 부울 값 반환)
		if (this == obj) return true; 	// 같은 객체. 주소가 같다.
		if (obj == null) return false;	// (매개변수로 넘어온) 객체가 없는 경우
		if (getClass() != obj.getClass()) return false;		// getClass() 해당 객체의 클래스를 나타냄.(근본부터 다른 비교한 코드임. 이해를 하자)
		Student other = (Student)obj;	// 오브젝트 값을 받았을 때 스튜던트 값으로 받아서 저장하겠다는 뜻
		if (age != other.age) return false;
		if (name == null) {
			if(other.name != null) return false;
		}else if (!name.equals(other.name)) return false;
		
		return true;
		//return super.equals(obj);		//오버라이드 시 자동으로 만들어진 리턴 값
	}
	
	@Override
	public String toString() { 	// 객체를 문자열로 전환
		// 기본적으로 클래스명@hashcode 값으로 출력됨. (Object.toStfing()의 결과)
		// 재정의를 통해서 객체 내 정보를 확이하기 위한 용도로 사용
		return "[이름 : " + name + ", 나이 : " + age + ", 학번 : " + studentId + "]";
	}

}
