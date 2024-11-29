package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	// 필드
	chatServer chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String clientIp;
	String chatName;

	// 생성자
	public SocketClient(chatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostName();
			receive();
		} catch (IOException e) {
		}
	}

	// 메소드: JSON 받기
	public void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				while (true) {
					String receiveJson = dis.readUTF();

					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");

					switch (command) {
					case "incoming":
						this.chatName = jsonObject.getString("data");
						chatServer.sendToAll(this, "들어오셨습니다.");
						chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}
				}
			} catch (IOException e) {
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
		});
	}

	// 메소드: JSON 보내기
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
		}
	}

	// 메소드: 연결 종료
	public void close() {
		try {
			socket.close();
		} catch (Exception e) {
		}
	}
}

//package ch19;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//
//import org.json.JSONObject;
//
//public class SocketClient {
//	
//	// 필드
//	chatServer chatServer;
//	Socket socket;
//	
//	// 채팅 이름과 clientIP
//	String clientIp;
//	String chatName;
//	// 채팅 내용을 저장하기 위해서
//	DataInputStream dis;
//	DataOutputStream dos;
//	
//	// 생성자
//	public SocketClient(chatServer chetServer, Socket socket) {
//		
//		try {
//			this.chatServer = chatServer;
//			this.socket = socket;
//			// socket에 있는 data를 처리하기 위한 객체 초기화
//			this.dis = new DataInputStream(socket.getInputStream());	// 보조스트림 사용
//			this.dos = new DataOutputStream(socket.getOutputStream());
//			// clientIp 생성
//			InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
//			// JSON 받기 처리
//			receive();
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
//
//	}
//	
//	// 메서드 : JSON 받기
//	public void receive() {
//		chatServer.threadPool.execute(() -> {
//			try {
//				while(true) {
//					String receiveJson = dis.readUTF();
//					JSONObject jsonObject = new JSONObject(receiveJson);
//					String command = jsonObject.getString("commend");
//					// json에 command 키워드를 사용하는 값이 있겠지?
//					switch(command) {
//					case "incoming":
//						this.chatName = jsonObject.getString("data");
//						// this -> 지금 현재 객체
//						this.chatServer.sendToAll(this, "들어오셨습니다.");
//						this.chatServer.addSocketClient(this);
//						break;
//					case "message":
//						String message = jsonObject.getString("data");
//						chatServer.sendToAll(this, message);
//						break;
//					}
//				}
//			} catch (IOException e) {
//				chatServer.sendToAll(this, "나가셨습니다.");
//				chatServer.removeSocketClient(this);
//			}
//		});
//	}
//	
//	// 보내는 메서드(json 양식을 전달)
//	public void send(String json) {
//		try {
//			// dos는 getOutStream으로 내보내면 보조스트림이 최종적으로 소켓에 있는 outputstream으로 보낸다.
//			dos.writeUTF(json);
//			dos.flush();
//		} catch (Exception e) {}
//		
//	}
//	
//	// 메서드 : 연결 종료
//	public void close() {
//		try {
//			socket.close();
//		} catch (Exception e) {}
//	}
//	
//}
