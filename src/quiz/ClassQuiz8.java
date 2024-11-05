package quiz;

public class ClassQuiz8 {
	
	// 워리어 위자드에 생성자를 만들어야 함

	public static void main(String[] args) {
		System.out.println("----마법사----");
		ClassQuiz5_Wizard play1 = new ClassQuiz5_Wizard("구르미그린달빛");
		play1.info();
		
		System.out.println("-----전사----");
		ClassQuiz5_Warrior play2 = new ClassQuiz5_Warrior("강한친구대한전사");
		play2.info();

	}

}
