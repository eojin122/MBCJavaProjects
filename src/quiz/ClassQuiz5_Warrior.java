package quiz;

import ch7.obj.Employee;
import ch7.obj.Student;
import ch7.obj.Teacher;

public class ClassQuiz5_Warrior extends Player {
	
	public ClassQuiz5_Warrior() {}
	public ClassQuiz5_Warrior(String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
	}
	public ClassQuiz5_Warrior(String name) {
		this(name, 1000, 500);
	}

	// 매개값 추가 워리어 위자드
	void bash(Player player) {
		
		// 만약 mp가 100 미만이면, 스킬 동작 x
		if(mp < 100 ) {
			System.out.println("mp가 모자릅니다.");
			return;
		}else {
			// 실행시 mp를 감소
			this.mp -= 100;
			
			if (player instanceof ClassQuiz5_Warrior) { 
				player.hp -= 100;		// hp 100 감소
			}else if (player instanceof ClassQuiz5_Wizard){
				player.hp -= 200;		// hp 200 감소
			}
			
			System.out.println(player.name + "님 배쉬 스킬 적중");
//			//System.out.println("때리기 스킬 사용");
		}
		
//		System.out.println(player.name + "님 배쉬 스킬 적중");
//		//System.out.println("때리기 스킬 사용");
	}
	
	@Override
	void action() {
		System.out.println("전사는 멋진 동작을 합니다.");
	}

}
