package ch14;

public class InterruptExample {

	public static void main(String[] args) {
		// 스레드 생성
		Thread thread = new PrintThread2();
		thread.setPriority(0);
		thread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		thread.interrupt();		// 일시정지 상태의 스레드는 InterruptedException를 발생시킴

	}

}

class PrintThread2 extends Thread {
	@Override
	public void run() {
		// 방법 1
//		try {
//			while(true) {
//				System.out.println("실행 중");
//				Thread.sleep(1);	// 
//			}
//		} catch (InterruptedException e) {
//			System.out.println("InterruptedException 발생");
//			//슬립(스레드 일시정지 상태로 넘김)상태일 때 발생
//		}
		
		// 방법2
		while(true) {
			System.out.println("실행중");
			if (Thread.interrupted()) {
				break;
			}
		}
		
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}