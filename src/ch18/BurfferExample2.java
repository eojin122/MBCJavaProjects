package ch18;

import java.io.BufferedReader;
import java.io.FileReader;

public class BurfferExample2 {

	public static void main(String[] args) throws Exception{
		// BufferedReader
		BufferedReader br = new BufferedReader(
			new FileReader("src/ch18/BurfferExample.java")
		);
		
		int lineNo = 1;
		while(true) {
			String str = br.readLine(); // "\n"을 만나기까지 데이터를 읽기 처리함
			if(str == null) break;
			System.out.println(lineNo + "\t" + str);
			lineNo ++;
		}
		// 3. close()
		br.close();
		
	}

}
