package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2470번 두 용액, 골드 5
 */
public class BOJ2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		int left = 0;
		int right = num.length - 1;
		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];
		while(left < right) {
			int x = num[left] + num[right];
			int absX = Math.abs(x);

			if(min > absX) {
				min = absX;
				answer[0] = num[left];
				answer[1] = num[right];
			}

			if(x > 0) {
				right--;
			} else if(x<0) {
				left++;
			} else {
				answer[0] = num[left];
				answer[1] = num[right];
				break;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
	}
}
