package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2573 빙산, 골드 4
 */
public class BOJ2573{
	static int[][] map;
	static int[][] dp;
	static int m, n;
	static boolean[][] visited;
	static int[] sx = {1, -1, 0, 0};
	static int[] sy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while(true) {
			visited = new boolean[m][n];
			dp = new int[m][n];
			int ice = 0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if (map[i][j]!=0) ice +=1;
				}
			}

			if (ice==0) {
				System.out.println(0);
				break;
			}

			int cnt=0;

			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						dfs(i, j);
					}
				}
			}

			// for(int i=0; i<m; i++) {
			// 	for (int j = 0; j < n; j++) {
			// 		System.out.print(map[i][j]+ " ");
			// 	}
			// 	System.out.println();
			// }

			for(int i=0; i<m; i++) {
				for (int j = 0; j < n; j++) {
					int x = map[i][j] - dp[i][j];
					if (x<=0) {
						map[i][j] = 0;
					} else {
						map[i][j] = x;
					}
				}
			}

			visited = new boolean[m][n];
			for(int i=0; i<m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j]!=0 && !visited[i][j]) {
						checkDfs(i, j);
						cnt+=1;
					}
				}
			}

			// for(int i=0; i<m; i++) {
			// 	for (int j = 0; j < n; j++) {
			// 		System.out.print(map[i][j]+ " ");
			// 	}
			// 	System.out.println();
			// }

			year += 1;
			// System.out.println(cnt + " " + year);
			if(cnt>1) {
				System.out.println(year);
				break;
			}
		}

	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		int dx, dy;
		for(int i=0; i<4; i++) {
			dx = x + sx[i];
			dy = y + sy[i];

			if (dx<0 || dy<0 || dx>=m || dy>=n) continue;

			if (map[dx][dy]==0 && map[x][y]>=1) {
				// map[x][y]-=1;
				dp[x][y]+=1;
			}
			if (map[dx][dy]!=0) {
				if (!visited[dx][dy]) {
					dfs(dx, dy);
				}
			}
		}
	}

	public static void checkDfs(int x, int y) {
		visited[x][y] = true;

		int dx, dy;
		for(int i=0; i<4; i++) {
			dx = x + sx[i];
			dy = y + sy[i];

			if (dx<0 || dy<0 || dx>=m || dy>=n) continue;

			if (map[dx][dy]!=0) {
				if (!visited[dx][dy]) {
					dfs(dx, dy);
				}
			}
		}
	}
}

