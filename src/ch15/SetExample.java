package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExample {
	
	/*
	 * Set - 집합을 구현해 놓은 컬렉션. 중복 값을 저장하지 않음
	 * 
	 * 주요 메서드
	 * 	- add() : 값을 추가. 반환 타입은 true(성공) or false(중복)
	 * 	- contains() : 주어진 객체가 저장되어 있는지 여부 
	 * 	- isEmpty() : 객체가 비어있는지 여부
	 * 	- iterator() : 저장된 객체를 한 번씩 가져오는 반복자를 리턴
	 * 	- size() : 저장되어 있는 전체 객체 수 리턴
	 *  - clear() : 저장된 모든 객체를 삭제
	 *  - remove() : 주어진 객체를 삭제
	 *  
	 */

	public static void main(String[] args) {
		// HashSet 콜랙션
		//	- 가장 빠른 set
		//	- index가 없다. (set은 순서가 없음)
		//	- 순서를 예측할 수 없다
		
		Set set = new HashSet();
		
		set.add("three");
		set.add("one");
		set.add("four");
		set.add("five");
		set.add(4);
		boolean isAdded = set.add("three");		// 중복 X
		
		System.out.println(set);
		System.out.println(isAdded);
		
		String str = "Hello, world!! Hello, everyone!!\n";		// 이스케이프 문자(\n)도 들어감
		Set<Character> set2 = new HashSet<>();
		
		for (char ch : str.toCharArray()) {	// toCharArray() : 문자열을 char배열로 변환
			set2.add(ch);
		}
		set2.add(null);		// null 값을 넣을 수 있음
		System.out.println(set2);
		
		// contains
		System.out.println(set.contains('H'));
		
		// remove : boolean 타입 리턴만 존재함
		System.out.println("null이 지워졌니? : " + set2.remove(null));
		System.out.println(set2);
		System.out.println("null이 지워졌니? : " + set2.remove(null));
		
		// 컬렉션끼리는 생성자를 통해서 값을 그대로 유지한채 다른 종류의 컬렉션으로 생성할 수 있음
		List<Character> list = new ArrayList<>(set2);
		Object[] char_arr = list.toArray();		// toArray를 list를 배열로
		Arrays.sort(char_arr);					// 정렬 작업(인코딩 값의 숫자의 순서(아스키 코드))
		System.out.println("HashSet -> ArrayList -> 배열로 변경한 후 정렬 : "
				+ Arrays.toString(char_arr));	
		set.clear();
		set2.clear();
		System.out.println(set);
		System.out.println(set2);
		
		// iterator() 객체를 하나씩 가져와서 처리
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java");	// 중복된 값이라 나오지 않음
		set.add("spring");
		
//		System.out.println(set);
		
		Iterator iterator = set.iterator();	// 타입이 Object로 되어 있음
		while(iterator.hasNext()) {	// hasNext()는 값의 존재 유무(true 있음, false 없음)
			// 객체를 하나 가져오기
			String element = (String)iterator.next();		// 값을 하나 불러오는 메서드 next()
			System.out.println(element);
			if(element.equals("JSP")) {
				// 가져온 객체를 컬렉션에서 제거
				iterator.remove();		// 지워잇
			}
		}
		System.out.println();
		// 실제 컬렉션에 적용 여부 확인
		
		System.out.println(set);
	}

}
