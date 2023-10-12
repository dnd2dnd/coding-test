package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 2583, 영역 구하기, 실버 1
 */
public class BOJ2583 {
	static int M, N, K;
	static boolean[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];

		int x1,y1,x2,y2;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for(int k=y1; k<y2; k++) {
				for(int j=x1; j<x2; j++) {
					map[j][k] = true;
				}
			}

		}

		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!map[i][j]) {
					list.add(dfs(i, j)+1);
				}
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}
	public static int dfs(int x, int y) {
		int count = 0;
		map[x][y] = true;
		int nx, ny;
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

			if(!map[nx][ny]) {
				count++;
				count += dfs(nx, ny);
			}
		}
		return count;
	}

}
