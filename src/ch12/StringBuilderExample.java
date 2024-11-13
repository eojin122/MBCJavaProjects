package ch12;

public class StringBuilderExample {

	public static void main(String[] args) {
		// StringBuilder는 String 클래스의 단점을 보완하기 위해서 사용하는 클래스
		StringBuilder data = new StringBuilder();
		data.append("DEF");		// StringBuilder객체 값을 더하기 (기존 문자열의 맨 뒤에 추가)
		data.insert(0, "ABC");  // insert(index, 문자열) -> 인덱스 위치에 문자열을 추가
		data.delete(3, 4);		// dalete(start, end) -> start인덱스qnxj end인덱스 전까지 삭제
		String dataStr = data.toString();	// 객체를 문자열로 반환하겠다는 뜻
		
		System.out.println(data);
		System.out.println("String 객체 출력 : " + dataStr);
		
		
		
		// String과 StringBuilder의 차이
		// String은 메모리를 각각 하나씩 잡고 있기 때문에 처리 속도가 느리다.
		long start, end;
		start = System.nanoTime();
		
		String str = "A";
		for (int i = 0; i < 300000; i++) {
			str = str + "A";

		}
		
		end = System.nanoTime();
		System.out.println("\tString : " + (end - start) + "ns");
		
		
		// StringBuilder
		start = System.nanoTime();
		
		StringBuilder sb = new StringBuilder("A");
		for (int i = 0; i < 300000; i++) {
			sb.append("A");

		}

		end = System.nanoTime();
		System.out.println(" StringBuilder : " + (end - start) + "ns");
		
		
		// daleteCharAt(index) : 특정 인덱스 값만 삭제(글자 하나 삭제)
		// replace(start, end, "문자열") 시작에서 끝이전까지 문자열 교체
		// reverse() 반전
		
	}

}
