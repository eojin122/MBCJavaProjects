package quiz;

import ch7.obj.Student;

/*
 *  1. Warrior 클래스 와 Wizard 클래스는 동일 속성과 기능을 갖고 있습니다.
 	2. 동일한 속성, 기능들을 Player 클래스로 정의 하고 상속 시키세요. 
	3. main에서 두 클래스를 만들어 info()를 사용하여 다음 결과가 나오도록 하세요.
	
	플레이어를 부모 객체로 일반화 해봐라
 */

public class ClassQuiz5 {

	public static void main(String[] args) {
		// player 클래스에 일반화를 통해 공통 코드를 이용한 객체 생성
		// 이를 Wizard와 Warrior 클래스에서 자식으로 받아서 사용할 수 있게 한다.
		
		ClassQuiz5_Wizard wiz = new ClassQuiz5_Wizard();
		wiz.name = "구르미그린달빛";
		wiz.hp = 500;
		wiz.mp = 1000;
		System.out.println("----마법사----");
		wiz.info();
		wiz.iceArrow();
		
		ClassQuiz5_Warrior war = new ClassQuiz5_Warrior();
		war.name = "강한친구대한전사";
		war.hp = 1000;
		war.mp = 500;
		System.out.println("-----전사----");
		war.info();
		war.bash(war);

	}

}


class Player {
	
	String name;
	int hp;
	int mp;
	
	void info() {
		System.out.println("캐릭명 : " + name);
		System.out.println("체력 : " + hp);
		System.out.println("마나 : " + mp);
	}
	
	void action() {
		
	}
	
}
