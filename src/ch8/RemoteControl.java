package ch8;

// RemoteControl 인터페이스 생성
/* public interface 인터페이스이름 {
 * 		상수
 * 		추상 메서드 등등
 * }
 * 
 * 인터페이스
 * - abstract class 와 유사한데 여러개 상속 받을 수 있음.(추상 클래스의 단점을 보완)
 * - 인터페이스에 포함된 메서드들은 모드 abstract method(기본값)이다.
 * - abstract class 와 다르게 인스턴스 변수와 인스턴스 메서드를 만들 수 없음. 
 * - static 변수와 static 메서드는 사용이 가능하다. (자동으로 final 이 된다.)
 * - 클래스와 다르게 구현체가 여러개 일 수 있다.
 */

public interface RemoteControl {
	
	// 상수 필드(멤버변수) : 인터페이스 내의 멤버변수 (필드)설정을 하면 이것은 상수 값이 된다.
	// public static final 이 생략된 것임.
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 추상 메서드 -> 구현측에서 반드시 재정의해야 함.(실행부분이 없음), (추상 메서드의 구현은 오버라이드이다.)
	// 1. 반환 타입, 2. 매개변수의 타입과 갯수 지정, 3. 메서드 이름
	// -> 추상 메서드엔 구현 부분만 없다.
	void turnOn();		// public abstract 가 생략 (써도 됨.)
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 메서드 -> {}를 사용하여 코드 실행부분이 존재함.(추상 메서드는 아니지만 구현체가 들어감)
	// 키워드로 default 를 사용함. 상수 필드를 읽거나 추상 메서드를 호출하는 코드를 작성할 수 있음.
	// 무음(Mute) 버튼
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리를 합니다.");
			setVolume(MIN_VOLUME);		// 위에 있는 추상 메서드를 호출
		}else {
			System.out.println("무음 해제합니다.");
			// 여기 setVolume 설정을 안했는데 어떻게 5로 다시 값이 돌아왔지..?
		}
	}
	
	// static 메서드
	// 형식 : [public | private] static 리턴타입 메소드명(매개변수, ...) {...}
	// 선언시 public 생략했다면, 자동으로 컴파일 과정 중에 public 이 붙게 됨.
	// 실행부 작성시에 상수 필드(멤버변수)를 제외한 추상 메서드, 디폴트 메서드, private 메서드 등을 호출할 수 없다. (중요~!!)
	// 스테틱 사용시 내가 자식으로 불러다가 사용하는 것이 상관 없는 것을 구현해야 한다.(독립됨)
	static void changeBattery() {
		System.out.println("리모콘 건전지 교환합니다.");
	}
	
}







