package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14891 {
	static int[][] gear = new int[5][8];
	static int[] dir = {0, 0, 0, 0, 0};
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<=4; i++) {
			String s = br.readLine();
			for(int j=0; j<s.length(); j++) {
				gear[i][j] = s.charAt(j)-'0';
			}
		}

		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			check = new boolean[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			find(x, y);
		}

		int sum = 0;
		sum += gear[1][dir[1]]==0 ? 0 : 1;
		sum += gear[2][dir[2]]==0 ? 0 : 2;
		sum += gear[3][dir[3]]==0 ? 0 : 4;
		sum += gear[4][dir[4]]==0 ? 0 : 8;
		System.out.println(sum);
	}
	public static void find(int x, int y) {
		check[x] = true;
		if(x+1<=4) {
			if(!check[x+1]) {
				int v = dir[x];
				int right = dir[x+1];
				if(gear[x][(v+2)%8] != gear[x+1][(right+6)%8]) {
					find(x+1, y*-1);
				}
			}
		}

		if(x-1>=1) {
			if(!check[x-1]) {
				int v = dir[x];
				int left = dir[x-1];
				if(gear[x][(v+6)%8] != gear[x-1][(left+2)%8]) {
					find(x-1, y*-1);
				}
			}
		}
		if(y==1) {
			dir[x] = (dir[x]+7)%8;
		} else {
			dir[x] = (dir[x]+1)%8;
		}
	}
}
