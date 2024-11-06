package ch8;

public class InterfacePolyEx1 {

	public static void main(String[] args) {
		// 자동차 객체 생성
		Car myCar = new Car();
		
		// run 메서드 실행
		myCar.run();
		
		// 타이어 교체(다형성)
		myCar.tire1 = new kumhoTire();
		myCar.tire2 = new HankookTire();
		
		// run 메서드 실행
		myCar.run();

	}

}

//인터페이스는 타이어
//구현체는 한국타이어, 금호타이어, 넥센

interface Tire {
	// 추상 메서드
	void roll();
	
}

class HankookTire implements Tire {
	@Override
	public void roll() {
		System.out.println("한국타이어가 굴러갑니다.");
	}
}

class kumhoTire implements Tire {
	@Override
	public void roll() {
		System.out.println("금호타이어가 굴러갑니다.");
	}
}


class Car {
	// 필드
	Tire tire1 = new HankookTire();
	Tire tire2 = new kumhoTire();
	
	// 메소드
	void run() {
		tire1.roll();
		tire2.roll();
	}
	
}