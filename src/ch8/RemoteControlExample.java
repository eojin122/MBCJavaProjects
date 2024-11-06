package ch8;

public class RemoteControlExample {

	public static void main(String[] args) {
		// 인터페이스 기능 테스트
		RemoteControl rc;		// 객체 정보가 아직 들어가지 않은 상태, 기본값으로 널을 가지고 있음
		
		// 상수 테스트
		System.out.println("리모콘 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최소 볼륨 : " + RemoteControl.MIN_VOLUME);
		
		// rc 변수에 Television 객체를 대입
		rc = new Television();
		rc.setVolume(5);
		rc.turnOn();
		rc.turnOff();
		
		// rc 변수에 Audio 객체를 대입
		rc = new Audio();
		rc.setVolume(5);
		rc.turnOn();
		rc.turnOff();
		
		// default 메서드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		// 정적메서드 호출
		RemoteControl.changeBattery();

	}

}
