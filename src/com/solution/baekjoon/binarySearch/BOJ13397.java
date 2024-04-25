package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ13397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] num = new int[n];
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, num[i]);
		}

		int left = 0;
		int answer = Integer.MAX_VALUE;
		while(left <= right) {
			int mid = (left + right) / 2;

			int k = split(n, num, mid);

			if(k <= m) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
	public static int split(int n, int[] num, int mid) {
		int cnt = 1;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int i=0; i<n; i++) {
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);

			if(max - min > mid) {
				min = Integer.MAX_VALUE;
				max = Integer.MIN_VALUE;
				cnt++;
				i--;
			}
		}
		return cnt;
	}
}
