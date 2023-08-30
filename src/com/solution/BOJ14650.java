package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  백준 14650, 걷다보니 신천역 삼, 실버 2
 */
public class BOJ14650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(cal(0, 0, n));

	}
	public static int cal(int depth, int sum, int n) {
		if(depth==n) {
			if(sum%3==0) {
				return 1;
			} else {
				return 0;
			}
		}
		int res = 0;
		for(int i=0; i<3; i++) {
			if(depth==0 && i==0) continue;
			res += cal(depth+1, sum+i, n);
		}
		return res;
	}
}
