package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 20303, 할로윈의 양아치, 골드 3
 * https://www.acmicpc.net/problem/20303
 */
public class BOJ20303 {
	static int n;
	static int[] parent, candy, person;
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		candy = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}

		person = new int[n+1];
		Arrays.fill(person, 1);

		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			union(x, y);
		}
		makeList();
		// System.out.println(Arrays.toString(parent));
		// System.out.println(Arrays.toString(candy));
		// System.out.println(Arrays.toString(person));

		int[][] dp = new int[list.size()+1][k];
		for(int i=1; i<list.size()+1; i++) {
			int personSum = list.get(i-1)[0];
			int candySum = list.get(i-1)[1];
			for(int j=0; j<k; j++) {
				if(personSum <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-personSum] + candySum);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[list.size()][k-1]);
	}
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x==y) return;
		parent[y] = x;
	}
	public static void makeList() {
		for (int i = 1; i < n + 1; i++) {
			if (parent[i] != i) {
				int p = find(i);
				candy[p] += candy[i];
				person[p] += person[i];
			}
		}

		for (int i = 1; i < n + 1; i++) {
			if (parent[i] == i) {
				list.add(new int[]{person[i], candy[i]});
			}
		}
	}
}
