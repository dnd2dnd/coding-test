package com.solution.programmers;

/**
 * 프로그래머스 Level 2, 기능 개발ㅎ
 */
public class 기능개발 {
	class Solution {
		public int[] solution(int[] progresses, int[] speeds) {

			int[] dp = new int[speeds.length];
			for(int i=0; i<progresses.length; i++) {
				int x = 100 - progresses[i];

				if(x%speeds[i]>=1) {
					progresses[i] = x/speeds[i]+1;
				} else {
					progresses[i] = x/speeds[i];
				}
			}

			dp[0] = progresses[0];
			for(int i=1; i<progresses.length; i++) {
				if(dp[i-1] > progresses[i]) {
					dp[i] = dp[i-1];
				} else {
					dp[i] = progresses[i];
				}
			}

			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<dp.length; i++) {
				map.put(dp[i], map.getOrDefault(dp[i], 0)+1);
			}

			List<Integer> keySet = new ArrayList<>(map.keySet());
			Collections.sort(keySet);
			int[] answer = new int[keySet.size()];
			int i=0;
			for (Integer key : keySet) {
				answer[i] = map.get(key);
				i++;
			}
			return answer;
		}
	}	
}
