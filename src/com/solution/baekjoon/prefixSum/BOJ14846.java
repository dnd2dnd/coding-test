package com.solution.baekjoon.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 14846, 직사각형과 쿼리, 골드 4
 */
public class BOJ14846 {
	static int[][][] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		nums = new int[11][n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<=10; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					nums[i][j][k] = nums[i][j-1][k] + nums[i][j][k-1] - nums[i][j-1][k-1];
					if(map[j][k]==i) {
						nums[i][j][k]++;
					}
				}
			}
		}

		// for(int i=1; i<10; i++) {
		// 	for(int j=1; j<=n; j++) {
		// 		for(int k=1; k<=n; k++) {
		// 			System.out.print(nums[i][j][k]+ " ");
		// 		}
		// 		System.out.println();
		// 	}
		// 	System.out.println();
		// }

		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(check(x1, y1, x2, y2));
		}

	}
	public static int check(int x1, int y1, int x2, int y2) {
		int ans = 0;
		for(int k=1; k<=10; k++) {
			int v = nums[k][x2][y2] - nums[k][x1-1][y2] - nums[k][x2][y1-1] + nums[k][x1-1][y1-1];
			if(v>=1) {
				ans++;
			}
		}
		return ans;
	}
}
