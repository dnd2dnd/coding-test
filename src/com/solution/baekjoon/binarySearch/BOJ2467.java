package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 2467, 용액, 골드 5
 *  https://www.acmicpc.net/problem/2467
 */
public class BOJ2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] solution = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		long min = Long.MAX_VALUE;
		int left =0, right = n-1;
		int[] answer = new int[2];
		while(left<right) {
			long value = solution[left] + solution[right];
			if(Math.abs(value)<min) {
				min = Math.abs(value);
				answer[0] = solution[left];
				answer[1] = solution[right];
			}

			if(value>=0) {
				right--;
			} else {
				left++;
			}
		}

		for (int i : answer) {
			System.out.print(i+ " ");
		}
	}

}
