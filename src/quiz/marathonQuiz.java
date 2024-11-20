package quiz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class marathonQuiz {
	
	/*
	 * 단 한명의 선수를 제외하고 완주(getOrDefault)
	 * 마라톤에 참여한 선수들의 이름이 담긴 배열과 완주한 선수들의 이름이 담겨진 배열이 주어질 때
	 * 완주하지 못한 선수의 이름을 리턴하도록 
	 */

	public static void main(String[] args) {
//		//참여한 선수들의 이름이 담긴 배열
//		String[] participant = new String[20];
//		// 완주한 선수들의 이름이 담긴 배열
//		String[] completion = new String[20];
//		
//		String loser = solution(String[] participant, String[] completion);
//
//		Map<String, String> marathonmap = new HashMap<>();
		
		/* 
		 * 마라톤 완주하지 못한 사람 반환하는 메서드
		 * 
		 * participant			completion			return
		 * [leo, kiki, eden]	[eden, kiki]		leo
		 * [marina, josipan,	[marina, josipan,
		 * 	nikola, vinko,		 nikola, filipa]
		 * 	filipa]				
		 * 
		 */
		
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String[] participant2 = {"marina", "josipan", "nikola","vinko","filipa"};
		String[] completion2 = {"marina", "josipan", "nikola", "filipa"};
		System.out.println("완주하지 못한 사람 : " + solution(participant, completion));
		System.out.println("완주하지 못한 사람 : " + solution(participant2, completion2));
		
	}
	
	public static String solution(String[] participant, String[] completion) {
		System.out.println(Arrays.toString(participant));
		System.out.println(Arrays.toString(completion));
		String answer = "";
		
		HashMap<String, Integer> hm = new HashMap<>();
		// getOrDefault(key, 기본값) : key가 존재하면 그 값을 출력, 없으면 기본값 설정(파이썬에서 인자값 2개 받았을 때와 같음)
		for(String player : participant) {		// 참여자 체크
			// player가 키값이고 없으면 hm.getOrDefault(player, 0)+1 (숫자값)을 넣으라는 뜻
			hm.put(player, hm.getOrDefault(player, 0)+1);	// +1 을 하지 않고 1로 해도 됨(참여자값이니까~)
		}
		for(String player : completion) {		// 완주자 체크
			hm.put(player, hm.get(player)-1);	// -1의 의미 : 참여했고 완주 했으면 다시 0으로 돌아옴 -> 참여자중에 value값이 0이 아닌 애들은 미완주자가 됨.
		}
		
		for (String key : hm.keySet()) {
			if (hm.get(key)!=0) {
				answer = key;
			}
		}
		
//		System.out.println(hm);
		
		return answer;
	}

}


