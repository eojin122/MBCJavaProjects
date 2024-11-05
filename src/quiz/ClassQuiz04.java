package quiz;

/*
 * 문제
 1. 멤버변수-예금주이름(name : String), 비밀번호(password : int), 잔액(balace: int) 로 선언하세요.
 2. 생성자-3가지멤버변수를모두매개값으로받아초기화하는생성자를선언하세요.
 3. 메서드-입금기능메서드(deposit : void), 출금기능 메서드(withDrwa: void), 잔액 조회 메서드(getbalance: int)
 4. 아래와같이실행될수있도록클래스를만드세요.
 
 "홍길동님의 계좌 잔액은 : 2500원입니다."
 */

// Account 클래스를 생성하고 캡술화(은닉화)처리하라는 소리, private

public class ClassQuiz04 {
	
	public static void main(String[] args) {
		
		Account myAcc = new Account("홍길동", 1234, 3600);
		// 위를 보면서 생성자가 이름 받고, 비밀번호 받고, 금액 받는 것이라 생각 해야함
		
		myAcc.deposit(800);		// 입금
		myAcc.withDraw(1900);	// 출금
		
		int bal = myAcc.getBalance();
		System.out.println(myAcc.name + "님의 계좌 잔액은" + bal + "원입니다.");

	}

}

// 계좌 클래스
class Account {
	//클래스를 만들면 생각해야할 3가지
	// 1. 필드(멤버변수)
	public String name;
	public int password;
	public int balace;

	// 2. 생성자
	public Account(String name, int password, int balace) {
		super();
		this.name = name;
		this.password = password;
		this.balace = balace;
	}
	
	// 3. 메서드
	public void deposit(int money) {
		this.balace += money;
	}
	
	public void withDraw(int money) {
		this.balace -= money;
	}
	
	public int getBalance() {
		return balace;
	}
}






