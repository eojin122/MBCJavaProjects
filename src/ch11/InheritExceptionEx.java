package ch11;

import java.io.IOException;
import java.sql.SQLException;

// 예외의 상속 관계
// 부모가 throws 하지 않는 Exception은 throws 할 수 없음

public class InheritExceptionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Super {
	public void doIt() throws IOException {
		System.out.println("IOException을 throws합니다.");
	}
}

// 자식 클래스
class Sub extends Super {
	
	// 재정의 상황에서 throws에 ICException을 SQLException으로 변경하면?
	@Override
	public void doIt() throws IOException /*, SQLException 부모에 없는 건 사용 못해잉~~*/ {
		System.out.println("Sub.doIt");
		try {
			super.doIt();	// 부모의 메서드
		} catch (IOException e) {
//			throw new SQLException(e.getMessage());		//부모에 업자나~ SQLException은 나가있어
		}
	}
}
