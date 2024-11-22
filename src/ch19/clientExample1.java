package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientExample1 {
	
	// 클라이언트 프로그램
	// Address already in use: bind		// 포트번호가 중복되어 발생하는 오류 메시지

	public static void main(String[] args) {
		try {
			// 1. Socket 생성
			// - 방법1 생성자에 직접 입력하는 방법
//			Socket socket = new Socket("192.168.0.124", 50001);		// 방법1: 생성자에게 서버의 정보를 직접적으로 연결(주소를 이미 알고 있는 경우)
			// - 방법2 생성자 주입 정보 : InetSocketAddress 객체 사용
			Socket socket = new Socket();							// 방법2 : 생성자를 만든 다음 작업 과정 중에 연결할 서버 정보를 나중에 연결(주소를 모르다가 나중에 연결하는 경우)
			InetSocketAddress serverAddr = new InetSocketAddress("192.168.0.124", 50001);	// 192.168.0.124 대신 localhost로 접근해도 됨
			socket.connect(serverAddr);		// connect() 주어진 객체 주소로 연결을 시도하는 메서드
			
			System.out.println("[클라이언트] 연결 성공");
			
			// 2. 데이터 처리를 위한 작업
			// 데이터 전송하기
			String sendMessage = "클라이언트가 말하길. 너에게 허니버터 아몬드를 하사하노라.";
			// getOutputStream() : OutputStream 객체 반환 - 전송시 내보낼 데이터 처리를 위한
			OutputStream os = socket.getOutputStream();
			// 보조 스트림 중 Data
			DataOutputStream dos = new DataOutputStream(os);	// 목적지에 대한 처리
			dos.writeUTF(sendMessage);
			dos.flush();
//			byte[] bytes = sendMessage.getBytes("UTF-8");	
//			os.write(bytes);
//			os.flush();
			System.out.println("[클라이언트] 데이터 전송 : " + sendMessage);
			
			
			// 전송 데이터 받기
			InputStream is = socket.getInputStream();
			//보조 스트림 중 DataInputStream
			DataInputStream dis = new DataInputStream(is);
			String recieveMessage = dis.readUTF();
//			byte[] bytes2 = new byte[1024];
//			int readByteCount = is.read(bytes2);		// 실제 차지하고 있는 데이터 크기를 카운트해서 처리하기 위함
//			String recieveMessage = new String(bytes2, 0, readByteCount, "UTF-8");
			System.out.println("[클라이언트] 서버에게 받은 데이터 : " + recieveMessage);
			
			
			// 3. 연결 끊기 : Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
			
			
		} catch (UnknownHostException e) {
			// IP 표기 방법이 잘못된 경우
		} catch (IOException e) {
			// 서버에 연결하지 못하는 경우
		}

	}

}
