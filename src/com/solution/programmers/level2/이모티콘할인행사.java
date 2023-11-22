package com.solution.programmers.level2;

import java.util.*;

public class 이모티콘할인행사 {
	class Solution {
		static int minK = Integer.MIN_VALUE;
		static int minV = Integer.MIN_VALUE;
		static int[][] users;
		static int[] emoticons;
		static int[] nums = {10, 20, 30, 40};
		public int[] solution(int[][] users, int[] emoticons) {
			int[] answer = new int[2];
			this.users = users;
			this.emoticons = emoticons;

			rec(0, emoticons.length, new int[emoticons.length]);
			answer[0] = minK;
			answer[1] = minV;
			return answer;
		}

		public void rec(int d, int r, int[] rates) {
			if(d == r) {
				int cnt = 0;
				int sum = 0;
				for(int i=0; i<users.length; i++) {
					int k = users[i][0];
					int v = users[i][1];
					int u = 0;
					for(int j=0; j<rates.length; j++) {
						if(k<=rates[j]) {
							u+=emoticons[j]-emoticons[j]*rates[j]/100;
						}
					}
					if(v<=u) {
						cnt++;
					} else {
						sum+=u;
					}
				}

				if(minK<cnt) {
					minK = cnt;
					minV = sum;
				} else if(minK==cnt) {
					minV = Math.max(minV, sum);
				}

				return;
			}

			for(int j=0; j<4; j++) {
				rates[d] = nums[j];
				rec(d+1, r, rates);
			}
		}
	}
}
