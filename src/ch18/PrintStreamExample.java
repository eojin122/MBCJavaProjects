package ch18;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {

	public static void main(String[] args) throws Exception {
		// PrintStream, PrintWriter는 print, println, printf와 같은 기능으로 출력
		// 1. 객체 생성
		FileOutputStream fos = new FileOutputStream("D:/Temp/printstream.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.print("마치 java의 System.out.print를 사용하는 것처럼");
		ps.println("내용이 출력이됩니다.");
		ps.println("데이터 출력이됩니다.");
		ps.printf("| %6d | %-10s | %10s | \n", 1 ,"홍길동", "의적");
		ps.printf("| %6d | %-10s | %10s | \n", 2 ,"이순신", "장군");
		
		ps.flush();		// 꼭 사용 안해도 됨
		// 입출력에서 메모리 버퍼를 flush 하는 경우 3가지
		// 1. 버퍼 공간이 다 찼을 때
		// 2. flush()를 실행했을 때(객체를 닫지 않은 상태에서 새로운 데이터를 받아야할 때 이전 데이터를 비워주는 용도)
		// 3. close()를 실행했을 때(객체를 닫고 사용이 데이터 사용이 끝났을 때)
		// 기존 메모리를 싹 비우는 용도로 주로 쓰임
		
		ps.close();
		
	}

}
