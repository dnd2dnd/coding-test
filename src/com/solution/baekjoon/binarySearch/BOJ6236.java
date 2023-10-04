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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] money = new int[N];

		for(int i=0; i<N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(money);

		int left = 0;
		int right = N-1;
		int result = 0;
		while(left<=right) {
			int mid = (left+right)/2;
			int cnt = 1;
			int k = money[mid];
			for(int i=0; i<N; i++) {
				if(k>money[i]) {
					k-=money[i];
				} else if(k<money[i]) {
					cnt+=(money[mid]/money[i]+1);
					k=money[mid];
				} else {
					cnt++;
					k=money[mid];
				}
			}

			if(cnt>M) {
				left = mid+1;
			} else {
				result = k;
				right = mid-1;
			}
		}
		System.out.println(result);
	}
}
