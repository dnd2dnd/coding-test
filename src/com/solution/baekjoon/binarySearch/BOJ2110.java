package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] home = new int[n];
		for(int i=0; i<n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(home);

		int left = 1;
		int right = home[n-1];

		int answer = Integer.MIN_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;

			if(router(n, home, mid) < c) {
				right = mid - 1;
			} else {
				answer = Math.max(answer, mid);
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
	public static int router(int n, int[] home, int mid) {
		int cnt = 1;
		int lastRouter = home[0];
		for (int i=1; i<n; i++) {
			if(home[i] - lastRouter >= mid) {
				lastRouter = home[i];
				cnt++;
			}
		}
		return cnt;
	}

}
