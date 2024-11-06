package ch8;


// RemoteControl 인터페이스의 구현체 클래스
public class Television implements RemoteControl {		// implements 키워드를 사용하여 구현 인터페이스 지정
	
	// 필드
	private int volume;		// 볼륨
	// Mute 시에 저장될 volume 값
	private int memoryVolume;
	
	@Override
	public void turnOn() {
		System.out.println("텔레비젼을 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("텔레비젼을 끕니다.");

	}
	
	// setVolume 추상 메서드 오버로드
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
	
	
	// default 메서드 재정의
	@Override
		public void setMute(boolean mute) {
			// 인터페이스에 있는 default 메서드를 재정의
			if (mute) {
				this.memoryVolume = this.volume;
				System.out.println("무음 처리합니다.");
				setVolume(RemoteControl.MIN_VOLUME);
			}else {
				System.out.println("무음 해제합니다.");
				// this.volume = this.memoryVolume; 	// 보통 이렇게 코드를 작성하지 않음. 메서드를 통해서 바꿔줘야함.
				setVolume(this.memoryVolume);
//				System.out.println("현재 TV 볼륨 : " + this.volume);		// 테스트 확인용
			}
		}

}
