package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971 {
	static int n;
	static int min;
	static int[][] score;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		score = new int[n][n];
		visited = new boolean[n];


		StringTokenizer st;

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;

		visited[0] = true;
		dfs(0 ,0, 0, 0);

		System.out.println(min);

	}

	public static void dfs(int s, int x, int d, int sum) {
		if(d==n-1) {
			if(score[x][s]!=0) {
				sum += score[x][s];
				min = Math.min(sum, min);
			}
			return;
		}
		for (int i=0; i<n; i++) {
			if(!visited[i] && score[x][i]!=0) {
				visited[i] = true;
				dfs(s, i, d+1, sum+score[x][i]);
				visited[i] = false;
			}
		}
	}
}
