package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
	static int[] ans = new int[2];
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, n);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
	public static void divide(int x, int y, int len) {
		int value = arr[x][y];

		boolean check = true;
		for(int i=x; i<x+len; i++) {
			for(int j=y; j<y+len; j++) {
				if (value != arr[i][j]) {
					check = false;
				}
			}
		}

		if(!check) {
			len/=2;
			divide(x, y, len);
			divide(x, y+len, len);
			divide(x+len, y, len);
			divide(x+len, y+len, len);
		} else {
			if(value == 0) {
				ans[0]++;
			} else {
				ans[1]++;
			}
		}
	}
}
