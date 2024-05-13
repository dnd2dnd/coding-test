package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.print.DocFlavor;

public class BOJ14712 {
	static int n, m, ans;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		dfs(0, 0);
		System.out.println(ans);
	}
	public static void dfs(int x, int y) {
		if (x==n) {
			for(int i=0; i<=n-2; i++) {
				for(int j=0; j<=m-2; j++) {
					if(arr[i][j]==1) {
						if(arr[i][j+1] ==1 && arr[i][j+1] == arr[i+1][j] && arr[i+1][j] == arr[i+1][j+1]) {
							return;
						}
					}
				}
			}
			ans++;
			return;
		}

		int ny = (y+1==m) ? 0 : y+1;
		int nx = ny==0 ? x+1 : x;
		arr[x][y] = 1;
		dfs(nx, ny);

		arr[x][y] = 0;
		dfs(nx, ny);
	}
}