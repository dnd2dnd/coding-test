package com.solution.baekjoon.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  백준 11059, 크리 문자열, 실버 5
 */
public class BOJ11059 {
	static int[] nums;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		nums = new int[s.length()+1];
		visited = new boolean[s.length()+1];
		for(int i=1; i<=s.length(); i++) {
			nums[i] = nums[i-1] + Integer.parseInt(String.valueOf(s.charAt(i-1)));
		}

		for(int i=0; i<=s.length(); i++) {
			for(int j=i+2; j<=s.length(); j+=2) {
				int x = (j+i)/2;
				if(nums[x]-nums[i] == nums[j] - nums[x]) {
					max = Math.max(max, j-i);
				}
			}
		}
		System.out.println(max);
	}

}

