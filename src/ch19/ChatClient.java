package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
	// 필드
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;

	// 메소드: 서버 연결
	public void connect() throws IOException {
		socket = new Socket("localhost", 50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 서버에 연결됨");
	}

	// 메소드: JSON 받기
	public void receive() {
		Thread thread = new Thread(() -> {
			try {
				while (true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp + "> " + message);
				}
			} catch (Exception e1) {
				System.out.println("[클라이언트] 서버 연결 끊김");
				System.exit(0);
			}
		});
		thread.start();
	}

	// 메소드: JSON 보내기
	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}

	// 메소드: 서버 연결 종료
	public void unconnect() throws IOException {
		socket.close();
	}

	// 메소드: 메인
	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient();
			chatClient.connect();

			Scanner scanner = new Scanner(System.in);
			System.out.println("대화명 입력: ");
			chatClient.chatName = scanner.nextLine();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json);

			chatClient.receive();

			System.out.println("--------------------------------------------------");
			System.out.println("보낼 메시지를 입력하고 Enter");
			System.out.println("채팅를 종료하려면 q 를 입력하고 Enter");
			System.out.println("--------------------------------------------------");
			while (true) {
				String message = scanner.nextLine();
				if (message.toLowerCase().equals("q")) {
					break;
				} else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}
			scanner.close();
			chatClient.unconnect();
		} catch (IOException e) {
			System.out.println("[클라이언트] 서버 연결 안됨");
		}
	}
}

//package ch19;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//import java.util.Scanner;
//
//import org.json.JSONObject;
//
//public class ChatClient {
//	
//	// 필드
//	Socket socket;
//	// IO처리를 보조 스트림
//	DataInputStream dis;
//	DataOutputStream dos;
//	// 챗 이름
//	String chatName;
//	
//	// 메서드 : 서버 연결
//	public void connect() throws IOException {
//		// 연결을 위한 소켓 생성
//		socket = new Socket("192.168.0.124",50001);
//		dis = new DataInputStream(socket.getInputStream());
//		dos = new DataOutputStream(socket.getOutputStream());
//		System.out.println("[클라이언트] 서버에 연결됨");
//	}
//	// 메서드 : JSON 데이터를 받기 위한 메서드
//	public void receive() {
//		Thread thread = new Thread(() -> {
//			try {
//				while(true) {
//					String json = dis.readUTF(); 	// JSON형태의 문자열
//					JSONObject root = new JSONObject(json);
//					String clientIp = root.getString("clientIp");
//					String chatName = root.getString("chatName");
//					String message = root.getString("message");
//					System.out.println("<<<" + chatName + "@" + clientIp + "]" + message);
//				}
//			} catch (IOException e) {
//				System.out.println("[클라이언트] 서버 연결 끊김");
//				System.exit(0);		// 프로세스 종료(프로그램 종료)
//			}
//		});
//		thread.start();
//	}
//	
//	// 메서드 : JSON 데이터 전송하기
//	public void send(String json) throws IOException {
//		dos.writeUTF(json);
//		dos.flush();
//	}
//	
//	// 메서드 : 서버 연결 종료
//	public void unconnect() throws IOException {
//		socket.close();
//	}
//	
//	
//	// 메인
//	public static void main(String[] args) {
//		try {
//			// ChatClient 객체 생성(왜? 위 객체들이 전부 static이 아니기 때문)(메인은 스테틱이자나)
//			ChatClient chatClient = new ChatClient();
//			// 서버 연결
//			chatClient.connect();
//			
//			// 데이터 생성
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("대화명 입력 : ");
//			chatClient.chatName = scanner.nextLine();
//			
//			//JSON 데이터 생성
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("command", "incomming");
//			jsonObject.put("data", chatClient.chatName);
//			String json = jsonObject.toString();
//			chatClient.send(json);
//			// 여기까지 대화방 참여
//			
//			// 서버가 보내는 JSON 정보를 받기
//			chatClient.receive();
//			
//			System.out.println("-------------------------------------------------");
//			System.out.println("보낼 메시지를 입력하고 Enter");
//			System.out.println("채팅을 종료하려면 q를 입력하고 Enter");
//			System.out.println("-------------------------------------------------");
//			while(true) {
//				String message = scanner.nextLine();
//				if(message.toLowerCase().equals("q")) {
//					break;
//				}else {
//					jsonObject = new JSONObject();
//					jsonObject.put("command", "message");
//					jsonObject.put("data", message);
//					chatClient.send(json);
//				}
//			}
//			scanner.close();
//			chatClient.unconnect();
//			
//		} catch (IOException e) {
//			System.out.println("[클라이언트] 서버 연결 안됨");
//		}
//
//	}
//
//}
