package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 6236, 용돈 관리, 실버 2
 */
public class BOJ6236 {
	static int N, M;
	static int[] money;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		money = new int[N];

		int max = 0;
		for(int i=0; i<N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, money[i]);
		}

		int left = max;
		int right = max * 100000;
		int result =0;
		while(left<=right) {
			int mid = (left+right)/2;

			if(check(mid)<=M) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(result);
	}
	public static int check(int mid) {
		int count = 1;
		int cMoney = mid;
		for(int i=0; i<N; i++) {
			cMoney -= money[i];

			if(cMoney<0) {
				count++;
				cMoney = mid - money[i];
			}
		}
		return count;
	}
}
