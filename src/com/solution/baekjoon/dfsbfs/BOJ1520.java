package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1520 내리막 길, 골드 3
 */
public class BOJ1520 {
	static int m, n;
	static int[][] map;
	static int[][] dp;
	static int[] sx = {1, -1, 0 ,0};
	static int[] sy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		dp = new int[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0,0));
	}

	public static int dfs(int x, int y) {

		if(x==m-1 && y==n-1) return 1;

		if(dp[x][y]!=-1) {
			return dp[x][y];
		} else {
			dp[x][y] = 0;
			int dx, dy;
			for(int i=0; i<4; i++) {
				dx = x + sx[i];
				dy = y + sy[i];

				if(dx<0 || dy<0 || dx>=m || dy>=n || map[x][y] <= map[dx][dy]) continue;


				dp[x][y] += dfs(dx, dy);
			}
		}
		return dp[x][y];
	}
}
