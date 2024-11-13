package ch11;

import java.io.FileInputStream;
import java.io.IOException;

public class AutoResourceManagerException {

	public static void main(String[] args) {
		
		// Finally 를 사용하지 않는다. 왜? 자동으로 실행 후 정리 됨
		try(FileInputStream in = new FileInputStream("a.txt")) {
			System.out.println("read data : " + in.read());		// 파일에 내용을 읽어서 출력
		} catch (NullPointerException | IOException ex ) {		// 파일에 내용을 읽어서 출력
//			System.out.println(in);		// in 참조할 수 없어요
			System.out.println("예외 처리합니다.");
			System.out.println(ex.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//finally 로 정리하는 경우
		FileInputStream in2 = null;
		try {
			in2 = new FileInputStream("a,txt");
			System.out.println("read data : " + in2.read());
		}catch (NullPointerException ex) {
	         System.out.println("예외처리합니다.");
	         System.out.println(ex.toString());
	      } catch (IOException ioe) {
	         System.out.println("예외처리합니다.");
	         System.out.println(ioe.toString());
	      } finally {
	    	 // 객체 정리할 때 많이 사용함
	    	 // 정보가 메모리에 남기 때문
	         try {in2.close();} catch (IOException e) {}
	      }
	   }

}
