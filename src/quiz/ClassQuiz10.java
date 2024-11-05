package quiz;

//다형성, 대상지정과 관련된 문제
/*
 * 1. Warrior 클래스의 bash()에 매개변수로 Warrior, Wizard가 모두 전달 될 수 있도록 변경해보세요.
   2. bash스킬에 play들이 적중되면 “~~~님 배쉬 스킬 적중“ 을 출력하고
   3. 전달 된 객체의 hp를-100감소하도록 기능을만들어 보세요
 */


//10번 문제
//public class ClassQuiz10 {
//
//	public static void main(String[] args) {
//		
//		ClassQuiz5_Warrior me = new ClassQuiz5_Warrior("강한친구대한전사");
//		
//		ClassQuiz5_Wizard play2 = new ClassQuiz5_Wizard("구르미그린마법사"); // 체력: 500
//		ClassQuiz5_Warrior play3 = new ClassQuiz5_Warrior("전사약해요"); // 체력: 1000
//		
//		System.out.println("---나의 케릭 배쉬스킬 사용---");
//		me.bash(play2); // 강한친구대한전사 bash스킬 사용 (play2 적중)
//		me.bash(play3); // 강한친구대한전사 bash스킬 사용 (play3 적중)
//		
//		play2.info();
//		play3.info();
//		
//		
//	}
//
//}



//10-1번 문제
//public class ClassQuiz10 {
//
//	public static void main(String[] args) {
//		
//		ClassQuiz5_Warrior me = new ClassQuiz5_Warrior("강한친구대한전사");
//		
//		ClassQuiz5_Wizard play2 = new ClassQuiz5_Wizard("구르미그린마법사"); // 체력: 500
//		ClassQuiz5_Warrior play3 = new ClassQuiz5_Warrior("전사약해요"); // 체력: 1000
//		
//		System.out.println("---나의 케릭 배쉬스킬 사용---");
//		me.bash(play2); // 강한친구대한전사 bash스킬 사용 (play2 적중)
//		me.bash(play3); // 강한친구대한전사 bash스킬 사용 (play3 적중)
//		
//		me.bash(play2); // 강한친구대한전사 bash스킬 사용 (play2 적중)
//		me.bash(play3); // 강한친구대한전사 bash스킬 사용 (play3 적중)
//		
//		play2.info();
//		play3.info();
//		
//		
//	}
//
//}



//10-2번 문제
public class ClassQuiz10 {

	public static void main(String[] args) {
		
		ClassQuiz5_Warrior w1 = new ClassQuiz5_Warrior("강한친구");
		ClassQuiz5_Wizard w2 = new ClassQuiz5_Wizard("구르미"); // 체력: 500
		ClassQuiz5_Warrior me = new ClassQuiz5_Warrior("나의캐릭터"); // 체력: 1000
		
		Player[] target = new Player[2];
		target[0] = w1;
		target[1] = me;
		
		// w2의 블라지드를 5번 실행시키시오.
		for(int i = 0; i < 5; i++) {
//			w2.blizzard(target);					// 방법.1
			w2.blizzard(new Player[] {w1, me});		// 방법.2 (대상이 바뀔 수 있기 때문에 이게 더 좋은 방법)
		}
	}

}
