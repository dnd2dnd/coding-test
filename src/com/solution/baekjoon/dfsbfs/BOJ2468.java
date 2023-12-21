package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2468, 안전 영역, 실버 1
 * https://www.acmicpc.net/problem/2468
 */
public class BOJ2468 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0 ,1, -1};
	static int n;
	static boolean[][] visited;
	static int[][] maps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maps = new int[n+1][n+1];
		int maxArea = Integer.MIN_VALUE;
		int maxValue = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				maxValue = Math.max(maxValue, maps[i][j]);
			}
		}

		for(int i=0; i<maxValue; i++) {
			int cnt = 0;
			visited = new boolean[n+1][n+1];
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(!visited[j][k] && maps[j][k]>i) {
						check(j, k, i);
						cnt++;
					}
				}
			}
			maxArea = Math.max(cnt, maxArea);
		}
		System.out.println(maxArea);
	}
	public static void check(int x, int y, int r) {
		int nx, ny;
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(nx<0 || ny<0 || nx>=n || ny>=n || visited[nx][ny]) continue;

			if(maps[nx][ny] > r) {
				visited[nx][ny] = true;
				check(nx, ny, r);
			}
		}
	}
}
