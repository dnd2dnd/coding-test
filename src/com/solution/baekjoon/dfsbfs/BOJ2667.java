package com.solution.baekjoon.dfsbfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 백준 2667 단지 번호 붙이기, 실버 1
 */
public class BOJ2667 {
	static int[][] map = null;
	static int[] sx = {1, -1, 0 ,0};
	static int[] sy = {0, 0, 1, -1};
	static int n;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String[] str = sc.nextLine().split("");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		ArrayList<Integer> ansList = new ArrayList<>();
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				if(map[y][x]==1) {
					count = 0;
					dfs(x, y);
					ansList.add(count);
				}
			}
		}
		System.out.println(ansList.size());
		Collections.sort(ansList);
		for(int i=0; i< ansList.size(); i++) {
			System.out.println(ansList.get(i));
		}
	}
	static void dfs(int x, int y) {
		map[y][x] = 0;
		count++;
		for(int i=0; i<4; i++) {
			int dx = x + sx[i];
			int dy = y + sy[i];

			if(dx<0 || dy<0 || dx>=n || dy>=n || map[dy][dx]==0) continue;

			dfs(dx, dy);
		}
	}
}
