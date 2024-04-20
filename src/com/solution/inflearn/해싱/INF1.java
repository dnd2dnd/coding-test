package com.solution.inflearn.해싱;

import java.util.HashMap;
import java.util.Map;

public class INF1 {
	public int solution(String s){
		int answer = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (Character character : map.keySet()) {
			if(map.get(character) == 1) {
				answer = s.indexOf(character)+1;
				break;
			}
		}

		return answer == 0 ? -1 : answer;
	}

	public static void main(String[] args){
		INF1 T = new INF1();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
