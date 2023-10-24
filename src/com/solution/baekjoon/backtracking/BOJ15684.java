package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15684, 사다리 조작, 골드 3
 */
public class BOJ15684 {
	static int N, M, H;
	static int[][] ladder;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new int[H+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ladder[a][b] = 1;
		}

		for(int i=0; i<=3; i++) {
			dfs(1, 0, i);
		}
		System.out.println(-1);
	}
	public static void dfs(int le, int cnt, int size) {
		if(cnt == size) {
			if(check()) {
				System.out.println(size);
				System.exit(0);
			}
			return;
		}

		for(int i=le; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(ladder[i][j] == 1)
					continue;
				if(ladder[i][j-1] == 1)
					continue;
				if(ladder[i][j+1] == 1)
					continue;
				ladder[i][j] = 1;
				dfs(i, cnt+1, size);
				ladder[i][j] = 0;
			}
		}
	}

	public static boolean check() {
		for(int i=1; i<=H; i++) {
			int curr = i;
			int start = 1;
			while(start<=H) {
				if(ladder[start][curr] == 1) {
					curr++;
					start++;
				} else if(ladder[start][curr-1] == 1) {
					curr--;
					start++;
				} else {
					start++;
				}
			}
			if(i != curr) return false;
		}
		return true;
	}
}
