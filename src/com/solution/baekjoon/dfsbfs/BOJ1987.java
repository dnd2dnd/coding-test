package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1987, 알파벳, 골드 4
 */
public class BOJ1987 {
	static int[] dx = {1, -1 , 0 , 0};
	static int[] dy = {0, 0 , 1 , -1};
	static int r, c, max=Integer.MIN_VALUE;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		visited = new boolean[26];

		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		dfs(0, 0, 0);
		System.out.println(max);
	}
	public static void dfs(int x, int y, int count) {
		if (visited[map[x][y]]) {
			max = Math.max(max, count);
		} else {
			int nx, ny;
			visited[map[x][y]] = true;
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;

				dfs(nx, ny, count+1);
			}
			visited[map[x][y]] = false;
		}
	}
}
