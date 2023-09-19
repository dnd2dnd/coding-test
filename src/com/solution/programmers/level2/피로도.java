package com.solution.programmers.level2;

/**
 * 프로그래머스, 피로도, Level 2
 */
public class 피로도 {
	class Solution {
		static boolean[] visited;
		static int answer;
		public int solution(int k, int[][] dungeons) {
			answer = -1;
			visited = new boolean[dungeons.length];
			dfs(k, dungeons, 0);

			return answer;
		}
		public void dfs(int k, int[][] dungeons, int d) {

			answer = Math.max(d, answer);

			for(int i=0; i<dungeons.length; i++) {
				if(!visited[i] && k >= dungeons[i][0]) {
					visited[i] = true;
					dfs(k-dungeons[i][1], dungeons, d+1);
					visited[i] = false;
				}
			}
		}
	}
}
