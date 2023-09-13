package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14888, 연산자 끼워넣기, 실버 1
 */
public class BOJ14888 {
	static int n;
	static int[] nums;
	static int[] ops;
	static boolean[] visited;
	static int max, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n+1];
		visited = new boolean[n+1];

		ops = new int[4];
		StringTokenizer	st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		back(0, 0);
		System.out.println(max);
		System.out.println(min);
	}
	public static void back(int sum, int d) {
		if(d==n) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		for(int i=0; i<4; i++) {
			if(ops[i]>0) {
				ops[i]--;

				switch (i) {
					case 0:
						back(sum + nums[d], d + 1);
						break;
					case 1:
						back(sum - nums[d], d + 1);
						break;
					case 2:
						back(sum * nums[d], d + 1);
						break;
					case 3:
						back(sum / nums[d], d + 1);
						break;
				}

				ops[i]++;
			}
		}
	}
}
