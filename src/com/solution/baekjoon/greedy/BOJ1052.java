package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1052, 물병, 실버 1
 */
public class BOJ1052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(bottleCount(n, k));
	}
	public static int bottleCount(int n, int k) {
		int buyBottle = 0;
		if(n<=k) {
			return buyBottle;
		}

		while (true) {
			int bottle = n + buyBottle;
			int cnt = 0;
			while(bottle>0) {
				if(bottle % 2 != 0) {
					cnt++;
				}
				bottle/=2;
			}

			if(cnt<=k) {
				break;
			}
			buyBottle++;
		}

		return buyBottle;
	}
}
