package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableExample {

	public static void main(String[] args) {
		// List 불변 컬렉션 생성
		List<String> immutableList1 = List.of("A", "B", "C");
//		immutableList1.add("D");	// java.lang.UnsupportedOperationException
//		immutableList1.remove("C");	// java.lang.UnsupportedOperationException
//		immutableList1.set(2, "D"); // java.lang.UnsupportedOperationException
//		System.out.println(immutableList1);
		
		// Set 불변 컬랙션 생성
		Set<String> immutableSet1 = Set.of("A", "B", "C");
//		immutableSet1.add("D");		// java.lang.UnsupportedOperationException
//		System.out.println(immutableList1);
		
		
		// Map 불변 컬랙션 생성
		Map<Integer, String> immutableMap1 = Map.of(
				1,"A",
				2,"B",
				3,"C"
		);
//		immutableMap1.put(3, "D");	//java.lang.UnsupportedOperationException 	수정 불가
//		immutableMap1.put(4, "D");
//		System.out.println(immutableMap1);
		
		
		// copyof() 메서드
		// List 컬렉션을 불변 컬렉션으로 복사
		List<String> list = new ArrayList<>();
		list.add("D");
		list.add("E");
		list.add("F");
		List<String> immutableList2 = List.copyOf(list);	// 불변 처리
//		immutableList2.add("A");
		// 리스트를 배열에 저장할 수 없을까?
		List<String> test = new ArrayList<String> (immutableList2);		// 불변값을 인자로 넘겨서 새롭게 값을 만듦.(변경과정)
		test.add("A");													// 불변에서 값을 가져왔지만 일반에 새롭게 만들었으므로 불변의 특성을 가지지 않음. 변경이 가능하다.
		// 가능은 함.

		
		// Set 컬렉션을 불변 컬렉션으로 복사
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		Set<String> immutableSet2 = Set.copyOf(set);
		System.out.println(immutableSet2);		// [C, B, A]
		
		
		// Map 컬렉션을 불변 컬렉션으로 복사
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		Map<Integer, String> immutableMap2 = Map.copyOf(map);
		System.out.println(immutableMap2);
		
		
		// 배열로부터 List 불변 컬렉션 생성
		String[] arr = {"A", "B", "C"};
		List<String> immutablelist3 = Arrays.asList(arr);	// 불변 List 컬렉션 생성
//		immutablelist3.add("D");	// 동작 안함. java.lang.UnsupportedOperationException 
		System.out.println(immutablelist3);
		
		
		
		
		
		
	}

}
