package quiz;

/*
 * 10-2번 
 *	1.Wizard클래스에 Blizzard() 메서드를 만들겠습니다.
 	2.Blizzard()는 Player타입 배열을 받습니다.
 	3.기능을채워넣고main에서메서드를실행시키세요
 */


public class ClassQuiz5_Wizard extends Player{
	
	public ClassQuiz5_Wizard() {}
	public ClassQuiz5_Wizard(String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
	}
	public ClassQuiz5_Wizard(String name) {
		this(name, 500, 1000);
	}

	
	void iceArrow() {
		System.out.print("얼음화살 사용");
	}
	
	
	//
	public void blizzard(Player[] player) {
		System.out.print("-----------------------");
		System.out.print(this.name + "님의 눈보라 시전!");
		
		// 기능
		// 1. 매개변수 player배열을 향상된 for문으로 회전.
		// 2. for문 안에서는 10~15사이의 랜덤난수를 발생
		// 3. player배열의 hp를 각각 랜덤난수 만큼 감소시킵니다.
		// 4. player배열의 이름과 함께 랜덤 피해를 각각 출력하세요
		
	}
	//
	
	@Override
	void action() {
		System.out.println("마법사는 멋진 동작을 합니다.");
	}
}
