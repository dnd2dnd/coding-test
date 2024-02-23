package com.solution.programmers.level2;

import java.util.*;

public class 광물캐기 {
}

class Solution {
	static int answer = Integer.MAX_VALUE;
	static String[] minerals;
	public int solution(int[] picks, String[] minerals) {
		this.minerals = minerals;
		int sum = 0;
		for(int pick : picks) {
			sum += pick;
		}
		int size;
		if(sum*5 < minerals.length) {
			size = sum;
		} else {
			size = minerals.length/5;
			if(minerals.length%5>0) {
				size++;
			}
		}

		rec(0, 0, size, new int[size], picks);

		return answer;
	}
	public void rec(int d, int s, int size, int[] p, int[] picks) {
		if(d==size) {
			int sum = 0;
			int len;
			if(p.length*5 < minerals.length) {
				len = p.length*5;
			} else {
				len = minerals.length;
			}

			for(int i=0; i<len; i++) {
				if(minerals[i].equals("diamond")) {
					if(p[i/5] == 0) {
						sum+=1;
					} else if(p[i/5] == 1) {
						sum+=5;
					} else if(p[i/5] == 2) {
						sum+=25;
					}
				} else if(minerals[i].equals("iron")) {
					if(p[i/5] == 0) {
						sum+=1;
					} else if(p[i/5] == 1) {
						sum+=1;
					} else if(p[i/5] == 2) {
						sum+=5;
					}
				} else if(minerals[i].equals("stone")) {
					if(p[i/5] == 0) {
						sum+=1;
					} else if(p[i/5] == 1) {
						sum+=1;
					} else if(p[i/5] == 2) {
						sum+=1;
					}
				}
			}
			answer = Math.min(answer, sum);
			return;
		}

		for(int i=s; i<picks.length; i++) {
			if(picks[i]>0) {
				p[d] = i;
				picks[i]--;
				rec(d+1, 0, size, p, picks);
				picks[i]++;
			}
		}
	}
}
