package com.solution.baekjoon.dfsbfs;

/**
 * 백준 3109 빵집, 골드 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {
	static int r, c;
	static String[][] space;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static boolean[][] check;
	static boolean flags;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		space = new String[r][c];
		check = new boolean[r][c];

		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			String[] strs = st.nextToken().split("");
			for(int j=0; j<c; j++) {
				space[i][j] = strs[j];
			}
		}
		cnt=0;

		for(int i=0; i<r; i++) {
			flags = false;
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
	public static void dfs(int x, int y) {
		check[x][y] = true;
		if(y==c-1){
			flags = true;
			cnt++;
			return;
		}
		int nx, ny;

		for(int i=0; i<3; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(nx<0 || ny<0 || nx>=r || ny>=c) continue;

			if(!check[nx][ny] && space[nx][ny].equals(".")) {
				// System.out.println(nx+" "+ny + " "+space[nx][ny]);
				dfs(nx, ny);
				if(flags) {
					return;
				}
			}

		}
	}
}
