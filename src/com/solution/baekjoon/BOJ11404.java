package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11404, 플로이드, 골드 4
 */
public class BOJ11404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) {
					map[i][j] = 0;
					continue;
				}
				map[i][j] = 10000001;
			}
		}

		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());

			map[a][b] = Math.min(map[a][b], cost);
		}

		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 10000001) {
					map[i][j] = 0;
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
