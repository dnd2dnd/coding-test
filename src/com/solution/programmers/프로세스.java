package com.solution.programmers;

import java.util.*;
/**
 * 프로그래머스 Level 2,  프로세스
 */
public class 프로세스 {
	class Solution {
		public int solution(int[] priorities, int location) {
			int answer = 0;
			PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
			for(int i=0; i<priorities.length; i++) {
				que.add(priorities[i]);
			}

			int k=0;
			while(!que.isEmpty()) {
				for(int i=0; i<priorities.length; i++) {
					if(que.peek()==priorities[i]) {
						que.poll();
						answer++;
						if(i==location) {
							return answer;
						}
					}
				}
			}

			return answer;
		}
	}
}
