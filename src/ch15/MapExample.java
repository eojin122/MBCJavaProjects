package ch15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	
	/*
	 * Map 
	 * 	- key-value 쌍으로 만들어지는 데이터 (엔트리 객체)
	 * 	- key를 이용해서 value를 참조하여 작업
	 * 	- key는 중복을 허용하지 않습니다. (만약에 같은 키를 사용해서 값을 대입하면 변경(갱신))
	 * 	- key와 value는 1:1 관계이다.
	 * 	 
	 * 주요 메서드
	 * 	- put(key, value) : 주어진 키와 값을 추가. 저장시 값을 리턴
	 * 	- containsKey(key) : 주어진 key 있는지 여부 확인
	 * 	- containValue(value) 
	 *  - Set<Map.Entry<K,V>> entrySet() : 키와 값을 쌍으로 구성된 모든 Map.entry를 set에 담아서 리턴
	 *  - get(key) : 주어진 키의 값을 리턴
	 *  - isEmpty() : 컬랙션이 비어있는지 여부
	 *  - Set<k> keySet() : 컬렉션에 있는 모든 키 값을 담아서 리턴
	 *  - size() : 컬렉션의 키의 총수
	 *  - values() : 저장된 모든 값을 Collection<V>로 리턴
	 *  - clear() :모든 Map.Entry(키와 값)를 삭제
	 *  - remove(key) : 주어진 키와 일치하는 Map.Entry 삭제. 삭제시 값 리턴 
	 * 
	 */

	public static void main(String[] args) {
		// HashMap
		// 	- 넣은 순서와 관계 없는 순서로 저장된다
		// 	- key를 통해서 값을 찾는 속도가 Map중에서 가장 빠르다
		
//		Object test1 = new Board("test","test","test");	// (new 제외하고 1, 2 같은 문자열로만 넣으면 값은 같다고 뜸)
//		Board test2 = new Board("test","test","test");	// 객체를 각각 생성하면 이 둘은 서로 다르다
//		System.out.println(test1 == test2);
		
		Map<String, Integer> map = new HashMap<>();
		Map map2 = new HashMap();
		
		// put(k, v) : 맵에 키와 값을 넣는다.
		map.put("홍길동", 99);
		map.put("임꺽정", 93);
		map.put("ABC", 123);
		map.put("FF", 123);
		map.put("홍길동", 88);	// 이미 있는 키에 값을 넣은 경우, 덮어쓴다(갱신)
		
//		System.out.println(map);
		
		// get(key) : 키를 넣으면 그에 해당하는 값을 반환
		System.out.println("get(key)의 출력   " + map.get("홍길동"));
		System.out.println("get(key)의 출력   " + map.get("임꺽정"));
		
		// keySet() : Map의 모든 키들을 Set으로 반환
//		Set<String> keys = map.keySet();  ==  String key: map.keySet()
		Set<String> keys = map.keySet();
		for (String key: map.keySet()) {		
			System.out.printf("keySet() 출력	%s : %d \n", key, map.get(key));
		}
		
		
		// entrySet() : Map의 entrySet을 반환 [k=v, k=v, ...] 형태
		System.out.println("entrySet()의 출력   "+map.entrySet());
		for (Entry<String, Integer> entry: map.entrySet()) {
			// Entry 인터페이스의 메서드, getkey(), getValue()
			System.out.print("entrySet()의 출력   "+entry.getKey()+" : ");
			System.out.println(entry.getValue());
		}
		
		
		// value() : Map에 있는 모든 값들을 Collection 타입을 반환
		System.out.println("value()의 출력(Collection 타입)  "+map.values());	// Collection 타입
		// 리스트로 받아서 처리하고 싶은 경우
		List<Integer> list = new ArrayList<>(map.values());
		System.out.println("value()의 출력(list 타입)  "+list);			// list 타입
		
		// containsKey(Key) : key가 포함되어 있는지 여부 확인
		System.out.println("containsKey(Key)의 출력   "+map.containsKey("홍길동"));
		System.out.println("containsKey(Key)의 출력   "+map.containsKey(10));
		
		// containsValue(value) : value가 존재하는지 여부 확인
		System.out.println("containsValue(value)의 출력   " + map.containsValue(88));
		
		// remove(key)
		System.out.println("remove(key)의 출력   | 삭제 후 반환 값 : " + map.remove("홍길동"));
		System.out.println("remove(key)의 출력   " + map);
		// clear() : Map에 있는 Entry 모두 삭제
		map.clear();
		// isEmpty : Map이 비어있는지 확인
		System.out.println("clear() 실행 후 isEmpty의 출력   " + map.isEmpty());
		
		map2.put(0, 10);
		map2.put('1', 20);
		map2.put(2, 30);
		map2.put(3.3, 40);
		System.out.println(map2);
		
		System.out.println(map2.get(0));
		System.out.println(map2.get(1));	// null 왜? 키가 없기에 연결된 값이 없음
		System.out.println(map2.get('1'));
		System.out.println(map2.get(2));
		System.out.println(map2.get(3.3));
		
	}

}
