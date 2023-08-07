package com.solution.baekjoon.dfsbfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1743, 음식물 피하기, 실버 1
 */
public class BOJ1743 {
	static int n, m, k;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		check = new boolean[n][m];

		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a-1][b-1] = 1;
		}

		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!check[i][j] && map[i][j]==1) {
					max = Math.max(dfs(i, j)+1, max);
				}
			}
		}
		System.out.println(max);

	}

	public static int dfs(int x, int y) {
		int cnt = 0;
		check[x][y] = true;

		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

			if(!check[nx][ny] && map[nx][ny]==1) {
				cnt+=dfs(nx, ny)+1;
			}
		}
		return cnt;
	}
}
