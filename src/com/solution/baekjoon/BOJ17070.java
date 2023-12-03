package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 17070, 파이프 옮기기 1, 골드 5
 */
public class BOJ17070 {
	public static class Node {
		int x1, y1, x2, y2;

		public Node(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	static int[][] map;
	static int n, cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];

		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 1);
		System.out.println(cnt);
	}

	public static void dfs(int x, int y, int pipe) {
		if(x<0 || y<0 || x>=n || y>=n || map[x][y] ==1 ) return;

		if(pipe == 1) {
			dfs(x, y+1, 1);
			dfs(x+1, y+1, 3);
		} else if(pipe == 2) {
			dfs(x+1, y, 2);
			dfs(x+1, y+1, 3);
		} else if(pipe == 3) {
			if(map[x-1][y]==1 || map[x][y-1]==1) return;
			dfs(x, y+1, 1);
			dfs(x+1, y, 2);
			dfs(x+1, y+1, 3);
		}

		if(x==n-1 && y==n-1) {
			cnt++;
		}
	}

}
