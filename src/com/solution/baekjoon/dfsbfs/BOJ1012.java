package com.solution.baekjoon.dfsbfs;
import java.util.Scanner;

/**
 * 백준 1022번 유기농 배추, 실버 2
 */
public class BOJ1012 {
	static int[] sx = {1, -1, 0, 0};
	static int[] sy = {0, 0, 1, -1};
	static int m;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int i=0; i<t; i++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int k = sc.nextInt();

			int[][] map = new int[n][m];

			for(int j=0; j<k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
			int cnt = 0;
			for(int y=0; y<n; y++) {
				for(int x=0; x<m; x++) {
					if (map[y][x]==1) {
						dfs(x, y, map);
						cnt+=1;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void dfs(int x, int y, int[][] map) {
		map[y][x]=0;

		for(int i=0; i<4; i++) {
			int dx = x + sx[i];
			int dy = y + sy[i];

			if (dx<0 || dy<0 || dx>=m || dy>=n || map[dy][dx]==0 ) continue;

			dfs(dx, dy, map);
		}
	}

}