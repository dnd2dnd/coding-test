package com.solution.baekjoon.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {
	static long min = Long.MAX_VALUE;
	static int n;
	static long[][] favor;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		favor = new long[n][2];
		StringTokenizer st = null;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			favor[i][0] = Integer.parseInt(st.nextToken());
			favor[i][1] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[n];
		dfs(1, 0);
		System.out.println(min);
	}

	public static void dfs(int g, int s) {
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				g *= favor[i][0];
				s += favor[i][1];
				long n = g-s;
				if(n>=0) {
					min = Math.min(min, n);
				}
				dfs(g, s);
				visited[i] = false;
			}
		}
	}
}
