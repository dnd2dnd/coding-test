package com.solution.inflearn.해싱;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class INF2 {
	public int[] solution(String s){
		int[] answer = new int[5];
		int max = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			int x = map.getOrDefault(c, 0);
			max = Math.max(max, x+1);
			map.put(c, x+1);
		}

		for(int i=97; i<102; i++) {
			// System.out.println((char) i);
			answer[i-97] = max - map.getOrDefault((char)i, 0);
		}

		return answer;
	}

	public static void main(String[] args){
		INF2 T = new INF2();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
