package ch14;

public class YieldExample {

	public static void main(String[] args) {
		WorkThread workThreadA =  new WorkThread("workThreadA");
		WorkThread workThreadB =  new WorkThread("workThreadB");
		workThreadA.start();
		workThreadB.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		workThreadA.work = false;
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		workThreadA.work = true;
	}

}

class WorkThread extends Thread {
	// 필드
	public boolean work = true;
	
	// 생성자
	public WorkThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while (true) {
			if(work) {
				try {
					System.out.println(getName() + ": 작업처리");
					Thread.sleep(300);
				} catch (InterruptedException e) {}
			}else {
				Thread.yield(); 	// 양보 (실행 -> 실행 대기)
			}
			
		}
	}
	
}