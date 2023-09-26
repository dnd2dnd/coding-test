package com.solution.baekjoon.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11660, 구간 합 구하기 5, 실버 1
 */
public class BOJ11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] sum = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<m; i++) {
			String[] strings = br.readLine().split(" ");
			int x1 = Integer.parseInt(strings[0]);
			int y1 = Integer.parseInt(strings[1]);
			int x2 = Integer.parseInt(strings[2]);
			int y2 = Integer.parseInt(strings[3]);

			System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
		}
	}
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	StringTokenizer st = new StringTokenizer(br.readLine());
	//
	// 	int n = Integer.parseInt(st.nextToken());
	// 	int m = Integer.parseInt(st.nextToken());
	//
	// 	int[] sum = new int[n*n+1];
	// 	for(int i=1; i<=n; i++) {
	// 		st = new StringTokenizer(br.readLine());
	// 		for(int j=1; j<=n; j++) {
	// 			sum[(i-1)*n+j] = sum[(i-1)*n+j-1] + Integer.parseInt(st.nextToken());
	// 		}
	// 	}
	//
	// 	for(int i=0; i<m; i++) {
	// 		String[] strings = br.readLine().split(" ");
	// 		int x1 = Integer.parseInt(strings[0]);
	// 		int y1 = Integer.parseInt(strings[1]);
	// 		int x2 = Integer.parseInt(strings[2]);
	// 		int y2 = Integer.parseInt(strings[3]);
	//
	// 		int x1y1 = sum[(x2-1)*n+y2];
	//
	// 		if((x1==1 && y1==1) || (x1==x2 && y1==y2)){
	// 			System.out.println(x1y1 - sum[(x1-1)*n+y1-1]);
	// 		} else {
	// 			System.out.println(x1y1 - sum[(x1-1)*n+y1]);
	// 		}
	// 	}
	// }
}
