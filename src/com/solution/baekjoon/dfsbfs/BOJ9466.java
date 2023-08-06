package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 9466 텀 프로젝트, 골드 3
 */
public class BOJ9466 {
	static int[] people;
	static boolean[] check;
	static boolean[] done;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			people = new int[n+1];
			check = new boolean[n+1];
			done = new boolean[n+1];
			ans = 0 ;
			for(int i=1; i<=n; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=n; i++) {
				if(!done[i]) {
					dfs(i);
				}
			}
			System.out.println(n-ans);
		}
	}
	public static void dfs(int x) {
		if(done[x]) return;
		if(check[x]) {
			done[x] = true;
			ans++;
		}
		check[x] = true;
		dfs(people[x]);
		done[x] = true;
		check[x] = false;
	}
}
