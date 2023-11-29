package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 16724, 피리 부는 사나이, 골드 3
 */
public class BOJ16724 {
	static String[][] maps;
	static boolean[][] visited;
	static boolean[][] finished;
	static String[] dd = {"D", "U", "R", "L"};
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n, m, cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maps = new String[n][m];
		visited = new boolean[n][m];
		finished = new boolean[n][m];

		for(int i=0; i<n; i++) {
			String[] strs = br.readLine().split("");
			for(int j=0; j<m; j++) {
				maps[i][j] = strs[j];
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
				}
			}
		}
		System.out.println(cnt);

	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for(int k=0; k<4; k++) {
			if(maps[x][y].equals(dd[k])) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if(nx<0 || ny<0 || nx>=n || ny>=m ) continue;

				if(!visited[nx][ny]) {
					dfs(nx, ny);
				} else {
					if(!finished[nx][ny]) {
						cnt++;
					}
				}

			}
		}
		finished[x][y] = true;
	}
}
