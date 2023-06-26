package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 백준 2468 안전 영역, 실버 1
 */
public class BOJ2468 {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] sx = {1, -1, 0, 0};
	static int[] sy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		int max = -1;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max<map[i][j]) max = map[i][j];
			}
		}
		int maxCnt = 1;
		for(int i=1; i<max; i++) {
			int cnt = 0;
			visited = new boolean[n][n];
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(map[j][k]<=i) visited[j][k] = true;
				}
			}

			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(!visited[j][k]) {
						dfs(j, k);
						cnt+=1;
					}
				}
			}
			if(maxCnt<cnt) maxCnt = cnt;
		}
		System.out.println(maxCnt);
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		int dx, dy;
		for(int i=0; i<4; i++) {
			dx = x + sx[i];
			dy = y + sy[i];

			if(dx<0 || dy<0 || dx>=n || dy>=n) continue;

			if(!visited[dx][dy]) {
				dfs(dx, dy);
			}
		}
	}

}
