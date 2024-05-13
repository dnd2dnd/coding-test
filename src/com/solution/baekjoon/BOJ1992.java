package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
	static StringBuffer ans = new StringBuffer();
	static int[][] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		nums = new int[n][n];

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				nums[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}

		quadTree(0,0, n);
		System.out.println(ans);
	}
	public static void quadTree(int x, int y, int len) {
		int v = nums[x][y];
		boolean check = true;

		if(len != 1) {
			for(int i=x; i<x+len; i++) {
				for(int j=y; j<y+len; j++) {
					if(v != nums[i][j]) {
						check = false;
					}
				}
			}
		}

		if(check) {
			ans.append(v);
		} else {
			len/=2;
			ans.append("(");
			quadTree(x, y, len);
			quadTree(x, y+len, len);
			quadTree(x+len, y, len);
			quadTree(x+len, y+len, len);
			ans.append(")");
		}
	}
}
