package com.solution.baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[n];
		int[] sushiTable = new int[d+1];

		for(int i=0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;
		for(int i=0; i<k; i++) {
			if(sushiTable[sushi[i]]==0) {
				count++;
			}
			sushiTable[sushi[i]]++;
		}
		int ans = count;

		for(int i = 1; i <= n; i++) {
			if(ans <= count) {
				if(sushiTable[c]==0) {
					ans = count+1;
				} else {
					ans = count;
				}
			}

			if(i==n) {
				break;
			}

			int end = (i+k-1)%n;
			if(sushiTable[sushi[end]]==0) {
				count++;
			}
			sushiTable[sushi[end]]++;

			sushiTable[sushi[i-1]]--;
			if(sushiTable[sushi[i-1]]==0) {
				count--;
			}
		}
		System.out.println(ans);
	}
}
