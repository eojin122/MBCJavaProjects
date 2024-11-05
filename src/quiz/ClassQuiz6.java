package quiz;

public class ClassQuiz6 {

	public static void main(String[] args) {
		System.out.println("----마법사----");
		ClassQuiz5_Wizard wiz = new ClassQuiz5_Wizard();
		wiz.action();
		System.out.println("-----전사----");
		ClassQuiz5_Warrior war = new ClassQuiz5_Warrior();
		war.action();

	}

}
