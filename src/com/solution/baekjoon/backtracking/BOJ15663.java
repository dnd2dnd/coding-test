package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15663, N과 M(9) , 실버 2
 */
public class BOJ15663 {
	static int n, m;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, new int[m]);
	}
	public static void dfs(int d, int[] temp) {
		if(d==m) {
			for (int i : temp) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		int num = 0;
		for(int i=0; i<n; i++) {
			if(!visited[i] && num != arr[i]) {
				visited[i] = true;
				temp[d] = arr[i];
				num = arr[i];
				dfs(d+1, temp);
				visited[i] = false;
			}
		}
	}
}
