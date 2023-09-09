package com.solution.programmers.level2;

/**
 * 프로그래머스, 최대값과최솟값
 */
public class 최댓값과최솟값 {
	class Solution {
		public String solution(String s) {
			StringBuilder sb = new StringBuilder();

			String[] strs = s.split(" ");

			int max = Integer.parseInt(strs[0]);
			int min = Integer.parseInt(strs[0]);
			int x = 0;
			for(int i=0; i<strs.length; i++) {
				x = Integer.parseInt(strs[i]);

				if(x > max) {
					max = x;
				}
				if(x < min) {
					min = x;
				}
			}
			sb.append(min);
			sb.append(" ");
			sb.append(max);


			return sb.toString();
		}
	}
}
